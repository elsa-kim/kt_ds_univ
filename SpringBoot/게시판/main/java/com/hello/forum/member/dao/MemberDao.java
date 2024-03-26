package com.hello.forum.member.dao;

import com.hello.forum.member.vo.MemberVO;

public interface MemberDao {
	
	public String NAME_SPACE = "com.hello.forum.member.dao.MemberDao";

	
	/**
	 * 파라미터로 전달 된 이메일이 DB에 몇 건 존재하는지 확인한다.
	 * @param email 사용자가 가입 요청한 이메일
	 * @return 동일한 이메일로 등록된 회원의 수
	 */
	public int getEmailCount(String email);
	
	/**
	 * 회원가입 쿼리를 실행한다.
	 * @param memberVO 사용자가 입력한 회원 정보
	 * @return DB에 Insert한 회원의 개수
	 */
	public int createNewMember(MemberVO memberVO);

	/**
	 * 로그인시 비밀번호 암호화를 위해 기존에 발급했던 salt값을 조회
	 * @param email 조회할 이메일
	 * @return 회원가입시 발급받은 salt값
	 */
	public String selectSalt(String email);

	/**
	 * 이메일과 비밀번호로 회원정보를 조회
	 * @param memberVO 이메일과 비밀번호
	 * @return 이메일과 비밀번호가 일치하는 회원의 정보
	 */
	public MemberVO selectMemberByEmailAndPassword(MemberVO memberVO);

}
