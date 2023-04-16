package com.learn.crudspring.controller;

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
		QueryResponse response = new QueryResponse();
		response.setUuid(UUID.randomUUID().toString());
		response.setStatus(HttpStatus.OK);
		response.setLstUsers(service.findAll());
		return response;
	}

	QueryResponse saveUser(Request req) {
		QueryResponse response = new QueryResponse();
		response.setUuid(UUID.randomUUID().toString());
		response.setStatus(HttpStatus.CREATED);
		response.setUser(service.save(req.getUser()));
		return response;
	}

}
