package com.ktdsuniversity.watcha.service;

import com.ktdsuniversity.watcha.dao.RatingsDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.RatingsVO;

public class RatingsService {
	
	private RatingsDao ratingsDao;
	
	public RatingsService() {
		this.ratingsDao = new RatingsDao();
	}
	
	public boolean createNewRating(String userId, double rating, String description, String movieId) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		RatingsVO ratingsVO = new RatingsVO();
		ratingsVO.setUserId(userId);
		ratingsVO.setRating(rating);
		ratingsVO.setDescription(description);
		ratingsVO.setMovieId(movieId);
		
		int insertedCount = 0;
		try {
			insertedCount = this.ratingsDao.insertNewRating(dbSupporter, ratingsVO);
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			dbSupporter.rollback();
			return false;
		}
		
		dbSupporter.close();
		return insertedCount > 0;
	}

}
