package com.sk.amabono.bono.application.sp.web;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.amabono.bono.domain.model.Address;
import com.sk.amabono.bono.domain.model.Bono;
import com.sk.amabono.bono.domain.model.BonoState;
import com.sk.amabono.bono.domain.model.MemMemberlevelType;
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
	public void PostBono(HttpServletRequest request, HttpServletResponse response) throws ParseException{
			
	
		/*
		 * name Desc address requestcount requiredlevel
		 */
    //getParameter는 중복되지 않고 유일하게 하나만 넘어올 떄 사용된다.
    //getParameter의 반환값은 String이다. 
    String name = request.getParameter("name");
    String Desc = request.getParameter("Desc");
    String addressd = request.getParameter("address");
    String zip = request.getParameter("zip");
    String requestcountd = request.getParameter("requestcount");
    String requiredleveld = request.getParameter("requiredlevel");

    String date = request.getParameter("day");
    
    Date DAY = new java.text.SimpleDateFormat("yyyyMMdd").parse(date);

    
    int zipcode = Integer.parseInt(zip);
    int requestcount = Integer.parseInt(requestcountd);

    MemMemberlevelType requiredlevel = MemMemberlevelType.valueOf(requiredleveld);
    BonoState bonostate = BonoState.valueOf("REGIST");
    
    Address address = new Address();
    
    address.setAddress(addressd);
    
    System.out.println(addressd);
    
    address.setZipCode(zipcode);
		 
    String uniqueKey = UUID.randomUUID().toString();
    
    //멤버객체에 회원정보를 저장한다.
    Bono bono=new Bono();
    
    bono.setBono_id(uniqueKey);
    bono.setName(name);
    bono.setDesc(Desc);
    bono.setAddress(address);
    bono.setRequestcount(requestcount);
    bono.setRequiredlevel(requiredlevel);
    bono.setState(bonostate);
    bono.setDate(DAY);
    
    System.out.println(bono.getName());
    System.out.println(bono.getDesc());
    System.out.println(bono.getAddress().getZipCode());
    
    bonoRepository.save(bono);

	}
	

	
}
