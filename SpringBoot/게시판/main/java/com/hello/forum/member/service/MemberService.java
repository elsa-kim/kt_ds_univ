package com.hello.forum.member.service;

import com.hello.forum.member.vo.MemberVO;

public interface MemberService {
	
	/**
	 * 회원가입을 처리한다.
	 * @param memberVO 사용자가 작성한 사용자 정보
	 * @return 회원가입이 정상적으로 처리되었는지 여부
	 */
	public boolean createNewMember(MemberVO memberVO);
	
	/**
	 * 사용자가 입력한 이메일이 사용가능한지 확인한다.
	 * @param email 사용자가 입력한 이베일
	 * @return 사용가능한 이메일인지 여부 (true: 사용가능한 이메일)
	 */
	public boolean checkAvailableEmail(String email);


	public boolean deleteMe(String email);

}
