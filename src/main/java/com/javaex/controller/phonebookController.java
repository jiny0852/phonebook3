package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Controller
public class phonebookController {
	
	@Autowired
    private PhonebookDao phonebookDao;
	
	//필드
	//생성자
	//메서드 gs
	//메서드 일반
	
	//등록폼
	
	//등록
	
	//리스트
	
	//등록폼

	
	@RequestMapping ( value="/list", method={RequestMethod.GET, RequestMethod.POST}  )
	public String list() {
		
		System.out.println("phonebookController.list()");
		
		return "/WEB-INF/views/list.jsp";
		
	}
	
	@RequestMapping ( value="/writeform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String writeForm() {
		
		System.out.println("phonebookController.writeForm()");
		
		return "/WEB-INF/views/writeForm.jsp";
		
	}
	
	@RequestMapping ( value="/editform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String editForm() {
		
		System.out.println("phonebookController.editForm()");
		
		return "/WEB-INF/views/editForm.jsp";
		
	}
	
	@RequestMapping ( value="/insert", method={RequestMethod.GET, RequestMethod.POST}  )
	public String insertPerson ( @ModelAttribute PersonVo personVo ) {
		
		PersonVo pVo = personVo;
		
		
		return "redirect:/views/list.jsp";
	}
	
	
	@RequestMapping ( value="/update/{no}", method={RequestMethod.GET, RequestMethod.POST}  )
	public String updatePerson ( @PathVariable("no") int no ) {
		
		int id = no;
		
				
		
		return "redirect:/views/list.jsp";
	}
	
	@RequestMapping ( value="/delete", method={RequestMethod.GET, RequestMethod.POST}  )
	public String deletePerson ( @RequestParam(value="personid") int id ) {
		
		
		
		
		return "redirect:/views/list.jsp";
	}
	
	

	
	
	
	
	

}
