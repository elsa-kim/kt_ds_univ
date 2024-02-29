package com.ktdsuniversity.watcha.service;

import java.util.List;

import com.ktdsuniversity.watcha.dao.MoviesDao;
import com.ktdsuniversity.watcha.dao.ProducingDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.MoviesVO;

public class MoviesService {
	
	private MoviesDao moviesDao;
	private ProducingDao producingDao;
	
	public MoviesService() {
		this.moviesDao = new MoviesDao();
		this.producingDao = new ProducingDao();
	}
	
	public boolean createNewMovie(String title
								  , int minimumAge
								  , String openYear
								  , int runningTime
								  , String genre
								  , String athmosphere
								  , String location
								  , String summary
								  , String poster
								  , List<String> directorsId) {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		//영화의 새로운 PK값을 받아온다.
		String newMoviePk = this.moviesDao.makeNextValue(dbSupporter);
		
		MoviesVO moviesVO = new MoviesVO();
		moviesVO.setMovieId(newMoviePk);
		moviesVO.setTitle(title);
		moviesVO.setMinimumAge(minimumAge);
		moviesVO.setOpenYear(openYear);
		moviesVO.setRunningTime(runningTime);
		moviesVO.setGenre(genre);
		moviesVO.setAtmosphere(athmosphere);
		moviesVO.setLocation(location);
		moviesVO.setSummary(summary);
		moviesVO.setPoster(poster);
		
		int insertMovieCount = 0;
		try {
			insertMovieCount = this.moviesDao.insertNewMovie(dbSupporter, moviesVO);
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			dbSupporter.rollback();
		}
		
		int insertDirectorsCount = 0;
		
		// 영화 등록에 성공했다면
		if(insertMovieCount > 0) {
			// 제작 정보를 insert 한다
			// 영화 1--n 제작 n--n 감독
			for (String directorId : directorsId) {
				try {
					insertDirectorsCount += this.producingDao.insertNewProducing(dbSupporter, directorId, newMoviePk);
				}
				catch(RuntimeException re) {
					re.printStackTrace();
					dbSupporter.rollback();
					dbSupporter.close();
					return false;
				}
			}
//			directorsId.forEach(directorId -> {
//				// 람다 안에서 외부 변수 존재를 모름(인스턴스이기 때문), 변경할 수 없음 => 상수로 만들어라 에러뜸 => 일반적 for 사용하거나 forEach 사용
//				insertDirectorsCount += this.producingDao.insertNewProducing(dbSupporter, directorId, newMoviePk);
//			});
		}
		
		dbSupporter.close();
		return insertDirectorsCount > 0;
	}

}
