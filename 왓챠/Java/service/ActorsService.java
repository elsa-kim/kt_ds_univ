package com.ktdsuniversity.watcha.service;

import java.util.List;

import com.ktdsuniversity.watcha.dao.ActorsDao;
import com.ktdsuniversity.watcha.dao.CastsDao;
import com.ktdsuniversity.watcha.util.DBSupporter;
import com.ktdsuniversity.watcha.vo.ActorsVO;
import com.ktdsuniversity.watcha.vo.CastsVO;

public class ActorsService {
	
	private ActorsDao actorsDao;
	private CastsDao castsDao;
	
	public ActorsService() {
		this.actorsDao = new ActorsDao();
		this.castsDao = new CastsDao();
	}
	
	public boolean createNewActor(String profile, String name, List<CastsVO> casts) {
		DBSupporter dbSupporter = new DBSupporter("WATCHA", "WATCHA");
		dbSupporter.open();
		
		String newActorPk = this.actorsDao.makeNextValue(dbSupporter);
		ActorsVO actorsVO = new ActorsVO();
		actorsVO.setActorId(newActorPk);
		actorsVO.setProfile(profile);
		actorsVO.setName(name);
		int insertActorsCount = 0;
		try {
			insertActorsCount = this.actorsDao.insertNewActor(dbSupporter, actorsVO);
		}
		catch(RuntimeException re) {
			re.printStackTrace();
			dbSupporter.rollback();
			return false;
		}
		
		int insertCastsCount = 0;
		if (insertActorsCount > 0) {
			for (CastsVO castsVO: casts) {
				castsVO.setActorId(newActorPk);
				try {
					insertCastsCount += this.castsDao.insertNewActor(dbSupporter, castsVO);
				}
				catch(RuntimeException re) {
					re.printStackTrace();
					dbSupporter.rollback();
					return false;
				}
			}
		}
		
		dbSupporter.close();
		return insertCastsCount > 0;
	}

}
