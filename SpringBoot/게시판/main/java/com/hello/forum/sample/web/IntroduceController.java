package com.hello.forum.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroduceController {
	
	// http://localhost:8080/introduce
	// 이 url이 뭘 나타내는건지를 메소드명으로 표현하는게 좋음
	@GetMapping("/introduce")
	public String viewIntroducePage(Model model) {
		model.addAttribute("name", "김소현");
		model.addAttribute("age", 28);
		model.addAttribute("city", "Seoul");
		
		return "introduce";
	}

}
