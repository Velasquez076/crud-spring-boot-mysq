package com.learn.crudspring.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;
import com.learn.crudspring.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Component
@RequiredArgsConstructor
public class UserConverter {

	private final UserService service;

	QueryResponse findAll() {
		return new QueryResponse(UUID.randomUUID().toString(), HttpStatus.OK, HttpStatus.OK.value(), service.findAll(),
				null);
	}

	QueryResponse saveUser(Request req) {
		return new QueryResponse(UUID.randomUUID().toString(), HttpStatus.CREATED, HttpStatus.CREATED.value(),
				new ArrayList<>(), service.save(req.getUser()));
	}

}
