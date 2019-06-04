package com.sk.amabono.bono.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sk.amabono.bono.domain.model.AbstractEntity;
import com.sk.amabono.bono.domain.model.AggregateRoot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
public class Bono extends AbstractEntity implements AggregateRoot {
	
}

