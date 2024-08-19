package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class phonebookController {
	
	//필드
	//생성자
	//메서드 gs
	//메서드 일반
	
	//등록폼
	
	//등록
	
	//리스트
	
	//등록폼
	@RequestMapping ( value="/writeform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String writeForm() {
		
		System.out.println("phonebookController.writeForm()");
		
		return "/WEB-INF/views/writeForm.jsp";
		
	}
	
	@RequestMapping ( value="/list", method={RequestMethod.GET, RequestMethod.POST}  )
	public String list() {
		
		System.out.println("phonebookController.list()");
		
		return "/WEB-INF/views/list.jsp";
		
	}
	
	@RequestMapping ( value="/editform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String editForm() {
		
		System.out.println("phonebookController.editForm()");
		
		return "/WEB-INF/views/editForm.jsp";
		
	}
	

	
	
	
	
	

}
