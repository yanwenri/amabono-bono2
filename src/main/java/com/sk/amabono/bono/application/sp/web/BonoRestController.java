package com.sk.amabono.bono.application.sp.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.amabono.bono.domain.model.Bono;


@Controller
public class BonoRestController {
/*	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	//loginForm
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public void loginPOST(String id) {
		System.out.println("Submit ID :: " + id);
	}
*/	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public ResponseEntity<Void> PostBono(@RequestBody final Bono bono){
		
		return new ResponseEntity<Void>;
	}
	
}
