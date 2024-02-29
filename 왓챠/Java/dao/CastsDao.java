package com.ktdsuniversity.watcha.dao;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.ActorsVO;
import com.ktdsuniversity.watcha.vo.CastsVO;

public class CastsDao {
	
	
	public int insertNewActor(DBSupporter dbSupporter, CastsVO castsVO) {
		
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO CASTS ");
		query.append("  (CAST_ID ");
		query.append(" , ACTOR_ID ");
		query.append(" , MOVIE_ID ");
		query.append(" , CHARACTER_NAME ");
		query.append(" , MAIN_ACTOR_YN) ");
		query.append(" VALUES ");
		query.append("  ('CT-' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '-' || LPAD(SEQ_CASTS_PK.NEXTVAL, 6, '0')/*CAST_ID*/ ");
		query.append(" , ?/*ACTOR_ID*/ ");
		query.append(" , ?/*MOVIE_ID*/ ");
		query.append(" , ?/*CHARACTER_NAME*/ ");
		query.append(" , ?/*MAIN_ACTOR_YN*/) ");
		
		
		return dbSupporter.insert(query.toString(), new Object[] {castsVO.getActorId(), castsVO.getMovieId(), castsVO.getCharacterName(), castsVO.getMainActorYn()});
	}

}
