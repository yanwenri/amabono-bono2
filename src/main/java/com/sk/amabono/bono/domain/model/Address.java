package com.sk.amabono.bono.domain.model;

import javax.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

@Data
@Embeddable
@Builder
public class Address implements ValueObject {
	private Integer zipCode;
	private String Address;
	
	public Address(Integer zipCode, String Address) {
		this.zipCode = zipCode;
		this.Address = Address;
	}
}
