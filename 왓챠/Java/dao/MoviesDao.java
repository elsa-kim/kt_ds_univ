package com.ktdsuniversity.watcha.dao;

import java.util.List;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.MoviesVO;

public class MoviesDao {
	
	/**
	 * 다음 PK의 값을 만들어준다
	 * 
	 */
	public String makeNextValue(DBSupporter dbSupporter) {
		StringBuffer query = new StringBuffer();
		query.append(" SELECT 'MV-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_MOVIES_PK.NEXTVAL, 6, 0) ");
		query.append("   FROM DUAL ");
		
		return dbSupporter.selectOne(query.toString(), null, String.class);
	}
	
	public int insertNewMovie(DBSupporter dbSupporter, MoviesVO moviesVO) {
		
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO MOVIES ");
		query.append("  (MOVIE_ID ");
		query.append(" , TITLE ");
		query.append(" , MINIMUM_AGE ");
		query.append(" , OPEN_YEAR ");
		query.append(" , RUNNING_TIME ");
		query.append(" , GENRE ");
		query.append(" , ATMOSPHERE ");
		query.append(" , LOCATION ");
		query.append(" , SUMMARY ");
		query.append(" , POSTER) ");
		query.append(" VALUES "); 
		query.append("  (? /*MOVIE_ID*/ ");
		query.append(" , ? /*TITLE*/ ");
		query.append(" , ? /*MINIMUM_AGE*/ ");
		query.append(" , ? /*OPEN_YEAR*/ ");
		query.append(" , ? /*RUNNING_TIME*/ ");
		query.append(" , ? /*GENRE*/ ");
		query.append(" , ? /*ATMOSPHERE*/ ");
		query.append(" , ? /*LOCATION*/ ");
		query.append(" , ? /*SUMMARY*/ ");
		query.append(" , ? /*POSTER*/) ");
		
		return dbSupporter.insert(query.toString(), new Object[] {moviesVO.getMovieId(), moviesVO.getTitle(), moviesVO.getMinimumAge(), moviesVO.getOpenYear(), moviesVO.getRunningTime(), moviesVO.getGenre(), moviesVO.getAtmosphere(), moviesVO.getLocation(), moviesVO.getSummary(), moviesVO.getPoster()});
	}
	
	public List<MoviesVO> selectMoviesByDirectorId(DBSupporter dbSupporter, String directorId) {
		
		StringBuffer query = new StringBuffer();
		query.append(" SELECT * ");
		query.append("   FROM MOVIES ");
		query.append("  WHERE MOVIE_ID IN (SELECT MOVIE_ID ");
		query.append(" 					 FROM PRODUCING ");
		query.append(" 					WHERE DIRECTOR_ID = ?) ");
		
		
		// selectList(실행시킬 쿼리문, ?에 들어갈 것, 어디의 데이터 쓸건지(A)) : A 인스턴스 만들고 잘 생성되면 컬럼 값들 리스트에 넣고 데이터 할당된 리스트를 A에 넣어 이 리스트 반환
		return dbSupporter.selectList(query.toString(), new Object[] {directorId}, MoviesVO.class);
	}

}
