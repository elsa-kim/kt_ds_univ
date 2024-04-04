package com.hello.forum.beans;

import org.springframework.web.servlet.HandlerInterceptor;

import com.hello.forum.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BlockDuplicateLoginInterceptor implements HandlerInterceptor {

	// 세션 있으면 보드리스트로 이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER_");
		
		// 로그인 되어 있다면
		if(memberVO != null) {
			response.sendRedirect("/board/search");
			return false;
		}
		
		return true;
	}
}
