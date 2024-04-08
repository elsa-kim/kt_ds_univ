package com.hello.forum.member.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import com.hello.forum.beans.SHA;
import com.hello.forum.exceptions.AlreadyUseException;
import com.hello.forum.exceptions.UserIdentifyNotMatchException;
import com.hello.forum.member.dao.MemberDao;
import com.hello.forum.member.dao.MemberDaoImpl;
import com.hello.forum.member.vo.MemberVO;

@SpringBootTest // jUnit 테스트를 위해 필요한 Bean을 가져오기 위한 애노테이션
@ExtendWith(SpringExtension.class) // Spring Test를 위해서 jUnit5를 사용하기 위한 설정 // jUnit4 이하 사용하면 생략
// MemberServiceImpl을 테스트 하기 위해 Import
// MemberServiceImpl이 동작하기 위해 MemberDaoImpl을 Import
// MemberServiceImpl이 동작하기 위해 SHA를 Import
@Import({MemberServiceImpl.class, MemberDaoImpl.class, SHA.class})
public class MemberServiceImplTest {

	/**
	 * Import 해온 MemberServiceImpl을 주입한다.
	 */
	@Autowired
	private MemberService memberService;
	
	/**
	 * MemberServiceImpl에 DI해주기 위한 MemberDao 선언
	 */
	@MockBean 
	private MemberDao memberDao;
	
	/**
	 * MemberServiceImpl에 DI해주기 위한 SHA 선언
	 */
//	@MockBean
//	private SHA sha;
	
	@Test // jUnit에 테스트 하라고 알려주는 것
	@DisplayName("회원 ID 중복체크 테스트")
	public void checkAvailableEmailTest() {
		// MemberServiceImpl의 checkAvailableEmail(email) 함수를 테스트 하기 위해서
		// MemberDaoImpl의 getEmailCount(email)이 동작해야하는 방법을 작성한다. (= Given)
		
		// 1. Given
		BDDMockito.given(this.memberDao.getEmailCount("user01@gmail.com")).willReturn(0);
		
		// 2. Given
		BDDMockito.given(this.memberDao.getEmailCount("user02@gmail.com")).willReturn(1);
		
		// 3. when
		boolean isAvailableEmail = this.memberService.checkAvailableEmail("user01@gmail.com"); // true
		
		// 4. then
		// isAvailableEmail의 값이 true면 성공, 아니라면 실패
		Assertions.assertTrue(isAvailableEmail);
		
		// 5. when
		isAvailableEmail = this.memberService.checkAvailableEmail("user02@gmail.com"); // false
		
		// isAvailableEmail의 값이 false면 성공, 아니라면 실패
		Assertions.assertFalse(isAvailableEmail);
		
		// 6. Verify
		// 정말 이대로 전달되었는가
		Mockito.verify(this.memberDao).getEmailCount("user01@gmail.com"); 
		Mockito.verify(this.memberDao).getEmailCount("user02@gmail.com"); 
	}
	
	@Test
	@DisplayName("회원가입 실패 테스트")
	public void createNewMemberFailTest() {
		
		// 1. Given
		BDDMockito.given(this.memberDao.getEmailCount("user01@gmail.com")).willReturn(1);
		
		// 2. when 
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("user01@gmail.com");
		
		// 작성된 테스트 코드는 AlreadyUseException이 발생해야한다!
//		boolean isSuccess = this.memberService.createNewMember(memberVO);
		// 예외 발생해야 성공(정확히 해당 예외가 발생해야한다)
//		Assertions.assertThrows(PageNotFoundException.class, ()-> this.memberService.createNewMember(memberVO)); // 실패
		AlreadyUseException exception = Assertions.assertThrows(AlreadyUseException.class, ()-> this.memberService.createNewMember(memberVO));
		
		// 3. then
		// 예상되는 예외 메시지와 실제 발생된 예외의 메시지가 같은지 비교
		String message = "이미 사용중인 이메일입니다.";
		Assertions.assertEquals(message, exception.getMessage());
		
		// 4. verify
		Mockito.verify(this.memberDao).getEmailCount("user01@gmail.com");
		
	}
	
	@Test
	@DisplayName("회원가입 성공 테스트")
	public void createNewMemberSuccessTest() {
		
		// 1. Given
		BDDMockito.given(this.memberDao.getEmailCount("user01@gmail.com")).willReturn(0);
		
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("user01@gmail.com");
		memberVO.setName("테스트 사용자");
		memberVO.setPassword("testpassword");
		memberVO.setConfirmPassword("testpassword");
		
		BDDMockito.given(this.memberDao.createNewMember(memberVO)).willReturn(1);
		
		// 2. When
		boolean isSuccess = this.memberService.createNewMember(memberVO);
		// isSuccess ==> true
		
		// 3. Then
		Assertions.assertTrue(isSuccess); // 회원가입의 결과가 true인지 검증.
		Assertions.assertNotNull(memberVO.getSalt()); // 비밀번호 암호화를 위한 salt가 생성되었는지 검증
		
		Assertions.assertNotEquals(memberVO.getPassword(), memberVO.getConfirmPassword());
		
		// 4. Verify
		Mockito.verify(this.memberDao).getEmailCount("user01@gmail.com");
		Mockito.verify(this.memberDao).createNewMember(memberVO);
	}
	
	@Test
	@DisplayName("회원정보 조회 실패 테스트-salt null")
	public void getMemberSaltNullFailTest() {
		
		// 1. Given
		BDDMockito.given(this.memberDao.selectSalt("user01@gmail.com")).willReturn(null);

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("user01@gmail.com");
		
		// 2. When
		UserIdentifyNotMatchException exception = Assertions.assertThrows(UserIdentifyNotMatchException.class, ()->this.memberService.getMember(memberVO));
		
		// 3. Then
		Assertions.assertNotNull(exception);
		String message = "이메일 또는 비밀번호가 일치하지 않습니다.";
		Assertions.assertEquals(message, exception.getMessage());
		
		// 4. Verify
		Mockito.verify(this.memberDao).selectSalt("user01@gmail.com");
	}
	
	@Test
	@DisplayName("회원정보 조회 실패 테스트-회원 정보 null")
	public void getMemberNullFailTest() {
		
		// 1. Given
		BDDMockito.given(this.memberDao.selectSalt("user01@gmail.com")).willReturn("salt");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("user01@gmail.com");
		memberVO.setPassword("testpassword");
		
		BDDMockito.given(this.memberDao.selectMemberByEmailAndPassword(memberVO)).willReturn(null);
		
		// 2. When
		UserIdentifyNotMatchException exception = Assertions.assertThrows(UserIdentifyNotMatchException.class, ()->this.memberService.getMember(memberVO));
		
		// 3. Then
		Assertions.assertNotNull(exception);
		String message = "이메일 또는 비밀번호가 일치하지 않습니다.";
		Assertions.assertEquals(message, exception.getMessage());
		
		// 4. Verify
		Mockito.verify(this.memberDao).selectSalt("user01@gmail.com");
		Mockito.verify(this.memberDao).selectMemberByEmailAndPassword(memberVO);
	}
	
	@Test
	@DisplayName("회원정보 조회 성공 테스트")
	public void getMemberSuccessTest() {
		
		// 1. Given
		BDDMockito.given(this.memberDao.selectSalt("user01@gmail.com")).willReturn("salt");

		MemberVO memberVO = new MemberVO();
		memberVO.setEmail("user01@gmail.com");
		memberVO.setPassword("testpassword");
		

		BDDMockito.given(this.memberDao.selectMemberByEmailAndPassword(memberVO)).willReturn(memberVO);
		
		// 2. When
		MemberVO member = this.memberService.getMember(memberVO);
		
		// 3. Then
		Assertions.assertNotNull(member);
		Assertions.assertEquals(memberVO.getEmail(), member.getEmail());
		Assertions.assertNotEquals(member.getPassword(), "testpassword");
		
		// 4. Verify
		Mockito.verify(this.memberDao).selectSalt("user01@gmail.com");
		Mockito.verify(this.memberDao).selectMemberByEmailAndPassword(memberVO);
	}
	
	@Test
	@DisplayName("회원 삭제 실패 테스트")
	public void deleteMeFailTest() {
		// 1. Given
		BDDMockito.given(this.memberDao.deleteMemberByEmail("user01@gmail.com")).willReturn(0);
		
		// 2. When
		boolean isSuccessDelete = this.memberService.deleteMe("user01@gmail.com");
		
		// 3. Then
		Assertions.assertFalse(isSuccessDelete);
		
		// 4. Verify
		Mockito.verify(this.memberDao).deleteMemberByEmail("user01@gmail.com");
	}
	
	@Test
	@DisplayName("회원 삭제 성공 테스트")
	public void deleteMeSuccessTest() {
		// 1. Given
		BDDMockito.given(this.memberDao.deleteMemberByEmail("user01@gmail.com")).willReturn(1);
		
		// 2. When
		boolean isSuccessDelete = this.memberService.deleteMe("user01@gmail.com");
		
		// 3. Then
		Assertions.assertTrue(isSuccessDelete);
		
		// 4. Verify
		Mockito.verify(this.memberDao).deleteMemberByEmail("user01@gmail.com");
	}
	
	
}
