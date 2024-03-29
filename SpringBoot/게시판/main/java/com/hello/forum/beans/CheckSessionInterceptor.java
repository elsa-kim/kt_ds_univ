package com.hello.forum.beans;

import org.springframework.web.servlet.HandlerInterceptor;

import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CheckSessionInterceptor implements HandlerInterceptor{

	/**
	 * Controller 실행 전에 Interceptor가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행할 controller
	 * @return controller 실행을 계속할 것인지 여부(false일 경우, 컨트롤러 실행을 하지 않고 즉시 응답해버린다.) 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 요청 객체에서 session 얻어온다.
		// 원래 HttpSession은 request.getSession() 으로 얻어와야한다.
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER_");
		
		// 세션이 없는 경우
		if (memberVO == null) {
			
			// 원래 가려했던 URL정보(현재 요청중인 URL 확인)
			// GET, POST, PUT, DELETE, FETCH 등등..
			String httpMethod = request.getMethod().toLowerCase();
			
			// /board/write
			String uri = request.getRequestURI();
			// 호스트, 도메인, 포트 포함 전체 주소 // http://localhost:8080/board/write
//			String url = request.getRequestURL().toString();
			// 쿼리스트링 파라미터('?' 제외) // id=123, 없을 땐 null
			String queryString = request.getQueryString();
			
			System.out.println("HttpMethod : "+ httpMethod);
			System.out.println("RequestURI : "+ uri);
//			System.out.println("RequestURL : "+ url);
			System.out.println("QueryString : "+ queryString);
			
			if(httpMethod.equals("get")) {
				String nextUrl = uri;
				if(!StringUtils.isEmpty(queryString)) {
					nextUrl += "?" + queryString;
				}
				
				// Model로 로그인 이후에 요청할 주소를 보내준다.
				request.setAttribute("nextUrl", nextUrl);
			}
			
			// 로그인 화면을 보여주기 위한 RequestDispatcher 객체를 만든다.
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/memberlogin.jsp");
			//로그인 화면으로 이동시킨다.
			// URL은 바뀌지 않는다.
			rd.forward(request, response);
			// 컨트롤러 실행을 하지 않는다.
			return false;
		}
		
		// 컨트롤러 실행을 계속한다.
		return true;
	}
	
	/**
	 * Controller 실행 된 후에 Interceptor가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행한 controller
	 * @param modelAndView controller가 반환한 modelAndView 객체(컨트롤러가 String 반환해도 modelAndView로 변환된다.)
	 */
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
	
	/**
	 * 요청과 응답처리가 모두 완료된 후에 Interceptor가 개입
	 * @param request 브라우저가 서버에게 요청한 정보
	 * @param response 서버가 브라우저에게 응답할 정보
	 * @param handler 실행한 controller
	 * @param ex 실행 중 발생한 예외 객체(예외가 발생하지 않았다면 null이다.)
	 */
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
	
}
