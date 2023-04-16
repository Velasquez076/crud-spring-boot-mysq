package com.learn.crudspring.controller;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;
import com.learn.crudspring.persistence.model.UserEntity;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private UserConverter userConverter;

	@InjectMocks
	private UserController userController;

	@Test
	void findAllTest() {
		when(userConverter.findAll()).thenReturn(buildObject());
		ResponseEntity<QueryResponse> expected = new ResponseEntity<>(buildObject(), HttpStatus.OK);
		ResponseEntity<QueryResponse> result = userController.findAll();
		assertNotEquals(expected, result);
	}

	@Test
	void saveUserTest() {
		when(userConverter.saveUser(any())).thenReturn(buildSaveObject());
		ResponseEntity<QueryResponse> expected = new ResponseEntity<>(buildSaveObject(), HttpStatus.CREATED);
		ResponseEntity<QueryResponse> result = userController.saveUser(new Request());
		assertNotEquals(expected, result);

	}

	QueryResponse buildObject() {
		return new QueryResponse("1", HttpStatus.OK, HttpStatus.OK.value(), new ArrayList<>(), null);
	}

	QueryResponse buildSaveObject() {
		return new QueryResponse(UUID.randomUUID().toString(), HttpStatus.CREATED, HttpStatus.CREATED.value(),
				new ArrayList<>(), new UserEntity());
	}
}
