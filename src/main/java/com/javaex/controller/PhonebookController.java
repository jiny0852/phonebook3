package com.javaex.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;



@Controller
public class PhonebookController {
	
	//필드
	//dao를 메모리에 올린다
	@Autowired
	private PhonebookDao phonebookDao;
	
	
	//생성자
	//메서드 gs
	//메서드 일반
	
	//등록폼
	//등록
	//리스트
	//등록폼
	
	
	//메서드 일반 ////////////////////////////////////////	
	
	/* 수정 */
	//  /editform?no=2
	
	@RequestMapping ( value="edit", method= { RequestMethod.GET, RequestMethod.POST } )
	public String edit ( @ModelAttribute PersonVo personVo ) {
		
		System.out.println("phonebookController.editform()");
		
		//System.out.println(no);
		
		//메소드를 이용해서 저장한다
		//PersonVo personVo = phonebookDao.getPersonOne(Integer.parseInt(no));
		System.out.println("edit : " + personVo);
		
		int count = phonebookDao.updatePerson(personVo);
		System.out.println(count);

		
		return "redirect:/list";
	} 
	
	/* 수정폼 */
	//  /editform?no=2
	@RequestMapping ( value="editform", method= { RequestMethod.GET, RequestMethod.POST } )
	public String editForm ( @RequestParam(value="no") int no , Model model) {
		
		System.out.println("phonebookController.editform()");
		
		System.out.println(no);

		
		//메소드를 이용해서 저장한다
		PersonVo personVo = phonebookDao.getPersonOne(no);
		System.out.println("editform: " + personVo);
		
		//
		model.addAttribute("personVo", personVo);
		
		return "editForm";
		//return "/WEB-INF/views/editForm.jsp";
	}
	
	
	/* 삭제 */
	@RequestMapping ( value="delete", method= {RequestMethod.GET, RequestMethod.POST} ) 
	public String delete( @RequestParam(value="no") String no  ) {
		
		System.out.println("phonebookController.delete()");
		
		System.out.println(no);

		
		//메소드를 이용해서 저장한다
		int count = phonebookDao.deletePerson(Integer.parseInt(no));
		System.out.println(count);		
		
		//리스트로 리다이렉트
		return "redirect:/list";
	}
	
	
	/* 등록폼 */
	@RequestMapping ( value="writeform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String writeForm() {
		
		System.out.println("phonebookController.writeForm()");
		
		//return "/WEB-INF/views/writeForm.jsp";
		return "writeForm";
	}
	
	/* 등록 */
	//Vo로 받을떄
	@RequestMapping ( value="/write", method={RequestMethod.GET, RequestMethod.POST}  )
	public String write ( @ModelAttribute PersonVo personVo ) {
		
		System.out.println("phonebookController.write()");
		
		//System.out.println(personVo);

		
		//메소드를 이용해서 저장한다
		int count = phonebookDao.insertPerson(personVo);
		System.out.println(count);
		
		//리스트로 리다이렉트
		return "redirect:/list";
		
	}
	
	//파라미터 하나씩 받을때
	@RequestMapping ( value="/write2", method={RequestMethod.GET, RequestMethod.POST}  )
	public String write2 ( @RequestParam(value="name") String name,
						   @RequestParam(value="hp") String hp,
						   @RequestParam(value="company") String company ) {
		
		System.out.println("phonebookController.write2()");
		/*System.out.println(name);
		System.out.println(hp);
		System.out.println(company);*/
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
	
		
		return "redirect:/list";
		
	}
	
	@RequestMapping ( value="/list", method={RequestMethod.GET, RequestMethod.POST}  )
	public String list ( Model model ) {
		System.out.println("phonebookController.list()");
		

		
		//메소드를 이용해서 저장한다
		List<PersonVo> personList = phonebookDao.getPersonList();
		//System.out.println(personList);
		
		model.addAttribute("personList", personList);
		
		//리스트로 리다이렉트		
		//return "/WEB-INF/views/list.jsp";
		return "list";
		
	}
	
	
	
	
	
	
	
	/*
	
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
	
	

	*/
	
	
	
	

}
