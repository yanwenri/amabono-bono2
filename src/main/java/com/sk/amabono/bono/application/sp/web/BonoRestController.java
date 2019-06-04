package com.sk.amabono.bono.application.sp.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.amabono.bono.domain.model.Bono;
import com.sk.amabono.bono.domain.repository.BonoRepository;


@Controller
public class BonoRestController {

	@Autowired
	private BonoRepository bonoRepository;
	
	
	@RequestMapping("/login")
	public String login() { 
		return "login"; 
	} 
	   
	
	
	
	
	/*
	 * @RequestMapping(value="/login", method = RequestMethod.POST) public void
	 * PostBono(@RequestBody final Bono bono){
	 * 
	 * bonorepository.save(bono); }
	 */
	

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void PostBono(HttpServletRequest request, HttpServletResponse response){
			
	
		/*
		 * name Desc address requestcount requiredlevel
		 */
    //getParameter는 중복되지 않고 유일하게 하나만 넘어올 떄 사용된다.
    //getParameter의 반환값은 String이다. 
    String name = request.getParameter("name");
    String Desc = request.getParameter("Desc");
    String address = request.getParameter("address");
    String requestcount = request.getParameter("requestcount");
    String requiredlevel = request.getParameter("requiredlevel");

		 
    //멤버객체에 회원정보를 저장한다.
    Bono bono = new Bono();
    bono.setName(name);
    bono.setDesc(Desc);
    bono.setAddress(null);
    bono.setRequestcount(0);
    bono.setRequiredlevel(null);

    
    System.out.println(bono.getDesc());
    
    bonoRepository.save(bono);

	}
	

	
}
