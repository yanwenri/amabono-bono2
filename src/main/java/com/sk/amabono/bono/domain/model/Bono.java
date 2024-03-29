package com.sk.amabono.bono.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Bono extends AbstractEntity implements AggregateRoot {
	
	private String bono_id;
	private String name;
	private String desc;

	private Date date;
	private Address address;
	private int requestcount;
	
	@Enumerated(EnumType.STRING)
	private MemberlevelType requiredlevel;
	
	@Enumerated(EnumType.STRING)
	private BonoState state;
	
	public Bono() {
		
	}
	

	public Bono( String name,String desc,MemberlevelType requiredlevel, Date date, Address address,int requestcount ) {
		
		this.name = name;
		this.desc = desc;
		this.requiredlevel = requiredlevel;	
		this.address = address;
		this.date = date;
		this.requestcount = requestcount;
	}

	

	public String toString() 
	{ 
		return "Bono [bono_id=" + bono_id + ", name=" + name + ", desc="+desc+", requestcount=" + requestcount + ", requiredlevel=" + requiredlevel +"]"; 
	}

	
}

