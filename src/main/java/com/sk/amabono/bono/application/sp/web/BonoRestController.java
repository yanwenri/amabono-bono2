package com.sk.amabono.bono.application.sp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	//loginForm
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(String id) {
		System.out.println("Submit ID :: " + id);
		Bono bono1 = new Bono();
		bono1.setName(id);
		bonoRepository.save(bono1);
		return "account";
	}
/*	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(String id) {
		
		return "/bono";
	}
*/	
}
