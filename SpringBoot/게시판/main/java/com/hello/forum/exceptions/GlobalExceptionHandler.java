package com.hello.forum.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * "Base Package (com.hello.forum)" 아래에서 발생하는 
 * 처리되지 않은 모든 예외들을 ControllerAdvice가 처리해준다.(catch 안된 것들만 처리)
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * PageNotFoundException이 발생했을 때, 동작하는 메소드
	 * @param pnfe ControllerAdvice까지 처리되지 않은 PageNotFoundException 객체 
	 * @return 에러페이지
	 */
	@ExceptionHandler(PageNotFoundException.class)
	public String viewPageNotFoundPage(PageNotFoundException pnfe, Model model) {
		
		model.addAttribute("message", pnfe.getMessage());
		
		return "error/404";
	}
	
}
