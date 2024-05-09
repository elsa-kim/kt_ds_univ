package com.hello.forum.beans.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hello.forum.beans.security.SecurityUser;
import com.hello.forum.member.vo.MemberVO;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 사용자가 Api 요청을 할 경우
 * 함께 전송된 JWT를 검증하는 역할.
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private JsonWebTokenProvider jwtPeovider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		
		// 요청 URL이 "/api/"로 시작하는 경우만 처리
		if(servletPath.startsWith("/api/")) {
			// HttpRequest Header에 추가된 Authorization 값을 추출
			String jwt = request.getHeader("Authorization");
			
			// 토큰에서 MemberVO 객체를 가져온다.
			MemberVO member = jwtPeovider.getUserFromToken(jwt);
			SecurityUser user = new SecurityUser(member);
			
			// 인증과 권한 정보 생성
			Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			
			// Security Context에 인증정보를 셋팅한다.
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		// doFilter : 다음할 일 해라 == controller 호출해라
		filterChain.doFilter(request, response);
		
	}

}
