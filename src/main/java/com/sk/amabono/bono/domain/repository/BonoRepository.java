package com.sk.amabono.bono.domain.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sk.amabono.bono.domain.model.Bono;

@RepositoryRestResource
public interface BonoRepository extends PagingAndSortingRepository<Bono, Long> {
}
