package com.learn.crudspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.crudspring.controller.constants.ControllerConstants;
import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = ControllerConstants.USER_RESOURCE)
public class UserController {

	private final UserConverter userConverter;

	@GetMapping(path = ControllerConstants.USERS, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<QueryResponse> findAll() {
		log.info(".:: Controller user find all ::.");
		return new ResponseEntity<>(userConverter.findAll(), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<QueryResponse> saveUser(@RequestBody Request request) {
		log.info(".:: Controller save user ::.");
		return new ResponseEntity<>(userConverter.saveUser(request), HttpStatus.CREATED);
	}

}
