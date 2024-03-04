package com.ktdsuniversity.watcha.dao;

import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.UsersVO;

public class UsersDao {
	
	public int insertNewUSer(DBSupporter dbSupporter, UsersVO usersVO) {
		
		StringBuffer query = new StringBuffer();
		
		query.append(" INSERT INTO USERS ");
		query.append("  (USER_ID ");
		query.append(" , NAME ");
		query.append(" , BACKGROUND ");
		query.append(" , PROFILE) ");
		query.append(" VALUES ");
		query.append("  (?/*USER_ID*/ ");
		query.append(" , ?/*NAME*/ ");
		query.append(" , ?/*BACKGROUND*/ ");
		query.append(" , ?/*PROFILE*/) ");
		
		return dbSupporter.insert(query.toString(), new Object[] {
				usersVO.getUserId(),
				usersVO.getName(),
				usersVO.getBackground(),
				usersVO.getProfile()
		});
	}

}
