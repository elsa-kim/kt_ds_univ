package com.hello.forum.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.forum.bbs.dao.ReplyDao;
import com.hello.forum.bbs.vo.ReplyVO;
import com.hello.forum.bbs.vo.SearchReplyVO;
import com.hello.forum.exceptions.PageNotFoundException;
import com.hello.forum.utils.AuthUtil;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDao replyDao;

	@Override
	public List<ReplyVO> getAllReplies(SearchReplyVO searchReplyVO) {
		return replyDao.getAllReplies(searchReplyVO);
	}

	@Transactional
	@Override
	public boolean createNewReply(ReplyVO replyVO) {
		int insertCount = replyDao.createNewReply(replyVO);
		return insertCount > 0;
	}

	@Transactional
	@Override
	public boolean deleteOneReply(int replyId, String email) {
		ReplyVO replyVO = replyDao.getOneReply(replyId);
		if(!email.equals(replyVO.getEmail()) && !AuthUtil.hasRole("ADMIN")) {
			throw new PageNotFoundException();
		}
		return replyDao.deleteOneReply(replyId) > 0;
	}

	@Transactional
	@Override
	public boolean modifyOneReply(ReplyVO replyVO) {
		ReplyVO originReplyVO = replyDao.getOneReply(replyVO.getReplyId());
		if(!replyVO.getEmail().equals(originReplyVO.getEmail()) && !AuthUtil.hasRole("ADMIN")) {
			throw new PageNotFoundException();
		}
		return replyDao.modifyOneReply(replyVO) > 0;
	}

	@Transactional
	@Override
	public boolean recommendOneReply(int replyId, String email) {
		ReplyVO replyVO = replyDao.getOneReply(replyId);
		if(email.equals(replyVO.getEmail())) {
			throw new PageNotFoundException();
		}
		return replyDao.recommendOneReply(replyId) > 0;
	}

}
