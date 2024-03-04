package com.ktdsuniversity.watcha.service;

import java.util.List;

import com.ktdsuniversity.watcha.dao.CastsDao;
import com.ktdsuniversity.watcha.dao.DirectorsDao;
import com.ktdsuniversity.watcha.dao.MoviesDao;
import com.ktdsuniversity.watcha.dao.ProducingDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.DirectorsVO;
import com.ktdsuniversity.watcha.vo.MoviesVO;

/**
 * DB의 트랜잭션을 관리.
 * (insert 성공적 -> commit / 문제가 있으면 -> rollback)
 */
public class DirectorsService {
	
	private DirectorsDao directorsDao;
	private MoviesDao moviesDao;
	private ProducingDao producingDao;
	
	public DirectorsService() {
		this.directorsDao = new DirectorsDao();
		this.moviesDao = new MoviesDao();
		this.producingDao = new ProducingDao();
	}
	
	public boolean createNewDirector(String directorsName, String directorsProfile) {
		
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open(); // Database에 연결하는 역할. Autocommit 비활성화 처리
		
		DirectorsVO directorsVO = new DirectorsVO();
		directorsVO.setName(directorsName);
		directorsVO.setProfile(directorsProfile);
		
		//insert 처리중에 예외가 발생한다면, 변경사항들을 모두 ROLLBACK 한다.
		int insertedCount = 0;
		try {
			insertedCount = this.directorsDao.insertNewDirector(dbSupporter, directorsVO);
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			dbSupporter.rollback();
		}
		
		dbSupporter.close(); // Database와 연결을 해제한다.
		return insertedCount > 0;
	}

	public List<DirectorsVO> findDirectorsWithMovies(){
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open(); // Database에 연결하는 역할. Autocommit 비활성화 처리
		
		// 데이터베이스에 등록된 모든 감독을 조회한다.
		// select는 트랜잭션 처리 필요 없지만 DB연결 위해 서포터 사용(dbSupporter.open())
		List<DirectorsVO> directors = this.directorsDao.selectAllDirectors(dbSupporter);

		// 감독목록을 반복하면서 해당 감독이 제작한 영화 목록을 조회한다.
		directors.forEach((director) -> {
			List<MoviesVO> movies = this.moviesDao.selectMoviesByDirectorId(dbSupporter, director.getDirectorId());
			
			director.setMovies(movies);
		});
		
		dbSupporter.close(); // Database와 연결을 해제한다.
		return directors;
	}

	public List<DirectorsVO> findAllDirectors() {
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open();

		List<DirectorsVO> directors = this.directorsDao.selectAllDirectors(dbSupporter);

		
		dbSupporter.close(); 
		return directors;
	}

	public List<DirectorsVO> findDirectorsByName(String name) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open();

		List<DirectorsVO> directors = this.directorsDao.selectDirectorsByName(dbSupporter, name);

		
		dbSupporter.close(); 
		return directors;
	}

	public DirectorsVO findDirectorById(String directorsId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open();

		DirectorsVO directorsVO = this.directorsDao.selectDirectorById(dbSupporter, directorsId);

		
		dbSupporter.close(); 
		return directorsVO;
	}

	public boolean modifyOneDirector(DirectorsVO directorsVO) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open();

		int updatedCount = this.directorsDao.updateOneDirector(dbSupporter, directorsVO);

		
		dbSupporter.close(); 
		return updatedCount > 0;
	}

	public boolean deleteOneDirectorById(String directorsId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA","WATCHA");
		dbSupporter.open();
		
		int deletedProducingCount = this.producingDao.deleteProducingByDirectorsId(dbSupporter, directorsId);
		System.out.println(deletedProducingCount + "건의 제작 정보가 삭제되었습니다.");

		int deletedCount = this.directorsDao.deleteOneDirectorById(dbSupporter, directorsId);

		
		dbSupporter.close(); 
		return deletedCount > 0;
	}
	
}



