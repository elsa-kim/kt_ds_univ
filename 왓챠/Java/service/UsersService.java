package com.ktdsuniversity.watcha.service;

import com.ktdsuniversity.watcha.dao.UsersDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.UsersVO;

public class UsersService {
	
	private UsersDao usersDao;
	
	public UsersService() {
		this.usersDao = new UsersDao();
	}
	
	public boolean createNewUSer(String userId, String name, String background, String profile) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		UsersVO usersVO = new UsersVO();
		usersVO.setUserId(userId);
		usersVO.setName(name);
		usersVO.setBackground(background);
		usersVO.setProfile(profile);
		
		
		int insertedCount = 0;
		try {
			insertedCount = this.usersDao.insertNewUSer(dbSupporter, usersVO);
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
