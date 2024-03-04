package com.ktdsuniversity.watcha.dao;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.RatingsVO;

public class RatingsDao {
	
	public int insertNewRating(DBSupporter dbSupporter, RatingsVO ratingsVO) {
		
		StringBuffer query = new StringBuffer();
		
		query.append(" INSERT INTO RATINGS ");
		query.append("  (RATING_ID ");
		query.append(" , USER_ID ");
		query.append(" , RATING ");
		query.append(" , DESCRIPTION ");
		query.append(" , MOVIE_ID) ");
		query.append(" VALUES ");
		query.append("  ('RT-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_RATINGS_PK.NEXTVAL, 6, 0)/*RATING_ID*/ ");
		query.append(" , ?/*USER_ID*/ ");
		query.append(" , ?/*RATING*/ ");
		query.append(" , ?/*DESCRIPTION*/ ");
		query.append(" , ?/*MOVIE_ID*/) ");
		
		return dbSupporter.insert(query.toString(), new Object[] {
				ratingsVO.getUserId(),
				ratingsVO.getRating(),
				ratingsVO.getDescription(),
				ratingsVO.getMovieId()
		});
	}

	public int deleteRatingsByMovieId(DBSupporter dbSupporter, String movieId) {

		StringBuffer query = new StringBuffer();
		
		query.append(" DELETE ");
		query.append("   FROM RATINGS ");
		query.append("  WHERE MOVIE_ID = ? ");
		
		return dbSupporter.insert(query.toString(), new Object[] {movieId});
	}

}
