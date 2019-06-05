package com.sk.amabono.bono.application.sp.web;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sk.amabono.bono.domain.model.Address;
import com.sk.amabono.bono.domain.model.Bono;
import com.sk.amabono.bono.domain.model.BonoState;
import com.sk.amabono.bono.domain.model.Hoge;

import com.sk.amabono.bono.domain.model.MemberlevelType;
import com.sk.amabono.bono.domain.repository.BonoRepository;



@Controller
public class BonoRestController {

	@Autowired
	private BonoRepository bonoRepository;
	
	


	
	@RequestMapping("/BonoReg")
	public String BonoReg() { 
		return "BonoReg"; 
	}
	

	@RequestMapping("/login")
	public String login() { 
		return "login"; 
	}

	
	  
	
	/*
	 * @GetMapping("/bonos") public List<Bono> getBonos(@RequestParam(value =
	 * "name", required = false) String name) { if (name != null) { return
	 * bonoRepository.findAllByNameContains(name); } return (List<Bono>)
	 * bonoRepository.findAll(); }
	 */

	
	
	
	@Controller @RequestMapping("/hello") public class SelectController 
	{ 
		@RequestMapping(method=RequestMethod.GET) public String select(Model model) 
		{ 
			
			
			System.out.println(" ))))))))))))))))     " + bonoRepository.findAll().toString() );
			
			List<Hoge> list = 
					Arrays.asList( 
					
							
			//for(int i=1; i =< ; i++)	{			
			new Hoge() {{

 
			bono_id ="12";
			name="22";
			desc="33";
			requestcount="44";
			requiredlevel="55";
			
				}}
			//}
			
			); 
			
			
			model.addAttribute("hogeList", list);

			return "hello"; 
		} 
	}
	
	
	
	@Controller @RequestMapping("/select") public class HelloController
	{ @RequestMapping(method=RequestMethod.GET) public String hello(Model model) 
		{ 
		Hoge hoge = new Hoge(); 
	
		long id=1;
		
		Bono bono = new Bono();
		
		System.out.println("333333333"+bono.toString());
		
		bono = bonoRepository.findOne(id);

		
		hoge.bono_id = bono.getBono_id();
		hoge.name=bono.getName();
		hoge.desc=bono.getDesc();
		hoge.requestcount=  Integer.toString(bono.getRequestcount());
		hoge.requiredlevel=bono.getRequiredlevel().toString();
		model.addAttribute("myData", hoge); 
		return "select"; 
		} 
	}

	
	
		
		
		
	

	
	@RequestMapping(value="/BonoReg", method=RequestMethod.POST)
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

    MemberlevelType requiredlevel = MemberlevelType.valueOf(requiredleveld);


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
