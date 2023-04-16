package com.learn.crudspring.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;
import com.learn.crudspring.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class UserConverter {

	private final UserService service;

	QueryResponse findAll() {
		QueryResponse response = new QueryResponse();
		response.setUuid(UUID.randomUUID().toString());
		response.setStatus(HttpStatus.OK);
		response.setStatusCode(HttpStatus.OK.value());
		response.setLstUsers(service.findAll());
		log.info(".:: Find all successfully ::.");
		return response;
	}

	QueryResponse saveUser(Request req) {
		QueryResponse response = new QueryResponse();
		response.setUuid(UUID.randomUUID().toString());
		response.setStatus(HttpStatus.CREATED);
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setUser(service.save(req.getUser()));
		log.info(".:: Save successfully ::.");
		return response;
	}

}
