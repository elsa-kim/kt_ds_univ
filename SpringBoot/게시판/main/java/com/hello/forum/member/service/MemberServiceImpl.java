package com.hello.forum.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.forum.beans.SHA;
import com.hello.forum.exceptions.AlreadyUseException;
import com.hello.forum.member.dao.MemberDao;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.StringUtils;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SHA sha;

	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		int emailCount = memberDao.getEmailCount(memberVO.getEmail());
		
		if (emailCount > 0) {
			throw new AlreadyUseException(memberVO.getEmail());
		}
		
		String password = memberVO.getPassword();
		String salt = this.sha.generateSalt();
		password = this.sha.getEncrypt(password, salt);
		
		memberVO.setPassword(password);
		memberVO.setSalt(salt);
		
		int insertCount = memberDao.createNewMember(memberVO);
		return insertCount > 0;
	}

	
	@Override
	public boolean checkAvailableEmail(String email) {
		return this.memberDao.getEmailCount(email) == 0;
	}


	@Transactional
	@Override
	public boolean deleteMe(String email) {
		return this.memberDao.deleteMemberByEmail(email) > 0;
	}

}
