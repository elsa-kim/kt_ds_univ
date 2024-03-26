package com.hello.forum.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.forum.member.service.MemberService;
import com.hello.forum.member.vo.MemberVO;
import com.hello.forum.utils.AjaxResponse;
import com.hello.forum.utils.ValidationUtils;
import com.hello.forum.utils.Validator;
import com.hello.forum.utils.Validator.Type;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/regist")
	public String viewRegistMemberPage() {
		return "member/memberregist";
	}
	
	// http://localhost:8080/member/regist/available?email=aaa@aaa.com
	@ResponseBody // 응답하는 데이터를 JSON으로 변환해 클라이언트에게 반환한다.
	@GetMapping("/member/regist/available")
	public Map<String, Object> checkAvailableEmail(@RequestParam String email){
		
		// 사용가능한 이메일이라면 true, 아니라면 false
		boolean isAvailableEmail = this.memberService.checkAvailableEmail(email);
		
		/*
		 * {
		 * 	"email": "aaa@aaa.com",
		 * 	"available": false
		 * }
		 */
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("email", email);
		responseMap.put("available", isAvailableEmail);
		
		return responseMap;
	}
	
	@PostMapping("/member/regist")
	public String doRegistMember(MemberVO memberVO, Model model) {
		
		boolean isNotEmptyEmail = ValidationUtils.notEmpty(memberVO.getEmail());
		boolean isEmailFormat = ValidationUtils.email(memberVO.getEmail());
		boolean isNotEmptyName = ValidationUtils.notEmpty(memberVO.getName());
		boolean isNotEmptyPassword = ValidationUtils.notEmpty(memberVO.getPassword());
		boolean isNotEmptyConfirmPassword = ValidationUtils.notEmpty(memberVO.getConfirmPassword());
		boolean isPasswordFormat = ValidationUtils.size(memberVO.getPassword(), 10);
		boolean isPasswordEqual = ValidationUtils.isEquals(memberVO.getPassword(), memberVO.getConfirmPassword());
		
		if(!isNotEmptyEmail) {
			model.addAttribute("errorMassage", "이메일은 필수 입력 값입니다.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		if(!isEmailFormat) {
			model.addAttribute("errorMassage", "이메일을 올바른 형태로 작성해주세요.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		if(!isNotEmptyName) {
			model.addAttribute("errorMassage", "이름은 필수 입력 값입니다.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		if(!isNotEmptyPassword) {
			model.addAttribute("errorMassage", "비밀번호는 필수 입력 값입니다.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		if(!isPasswordFormat) {
			model.addAttribute("errorMassage", "비밀번호는 최소 10자리 이상 입력해주세요.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}

		if(!isNotEmptyConfirmPassword) {
			model.addAttribute("errorMassage", "비밀번호 확인은 필수 입력 값입니다.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		if(!isPasswordEqual) {
			model.addAttribute("errorMassage", "비밀번호와 일치하지 않습니다.");
			model.addAttribute("memberVO", memberVO);
			return "member/memberregist";
		}
		
		boolean isSuccess = this.memberService.createNewMember(memberVO);
		if (isSuccess) {
			System.out.println("회원가입 성공");
			return "redirect:/member/login";
		}else {
			System.out.println("회원가입 실패");
		}
		model.addAttribute("memberVO", memberVO);
		return "member/memberregist";
	}
	
	@GetMapping("/member/login")
	public String viewLoginPage() {
		return "member/memberlogin";
	}
	
	@ResponseBody
	@PostMapping("/member/login")
	public AjaxResponse doLogin(MemberVO memberVO, HttpSession session){
		
		// Validation check (파라미터 유효성 검사)
		Validator<MemberVO> validator = new Validator<>(memberVO);
		validator.add("email", Type.NOT_EMPTY, "이메일을 입력해주세요.")
				 .add("email", Type.EMAIL, "이메일 형식이 아닙니다.")
				 .add("password", Type.NOT_EMPTY, "비밀번호를 입력해주세요.")
				 .start();
		
		if(validator.hasErrors()) {
			Map<String, List<String>> errors = validator.getErrors();
			return new AjaxResponse().append("errors", errors);
		}
		
		try {
			MemberVO member = this.memberService.getMember(memberVO);
			// 로그인이 정상적으로 이루어졌다면 세션을 생성한다.
			session.setAttribute("_LOGIN_USER_", member);
		} catch(IllegalArgumentException iae) {
			// 로그인에 실패했다면 화면에 실패 사유를 보내준다.
			return new AjaxResponse().append("errorMessage", iae.getMessage());
		}
		
		return new AjaxResponse().append("next", "/board/list");
	}
	

}
