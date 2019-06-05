package com.sk.amabono.bono.domain.model;

public class Hoge { 
	public String bono_id;
	public String name; 
	
	public String desc;
	public String requestcount;
	public String requiredlevel;
	
	@Override public String toString() 
	{ 
		return "Hoge  [bono_id=\" + bono_id + \", name=\" + name + \", desc=\"+desc+\", requestcount=\" + requestcount + \", requiredlevel=\" + requiredlevel +\"]"; 
	}
}

