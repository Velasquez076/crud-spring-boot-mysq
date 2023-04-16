package com.learn.crudspring.controller;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;
import com.learn.crudspring.persistence.model.UserEntity;
import com.learn.crudspring.service.UserService;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class UserConverterTest {

	@Mock
	private UserService userService;

	@InjectMocks
	private UserConverter userConverter;

	@Test
	void findAllTest() {
		when(userService.findAll()).thenReturn(new ArrayList<>());
		QueryResponse expected = new QueryResponse("1", HttpStatus.OK, HttpStatus.OK.value(), new ArrayList<>(), null);
		QueryResponse result = userConverter.findAll();
		assertNotEquals(expected, result);
	}

	@Test
	void saveUserTest() {
		when(userService.save(any())).thenReturn(new UserEntity());
		QueryResponse expected = new QueryResponse("1", HttpStatus.CREATED, HttpStatus.CREATED.value(), new ArrayList<>(), new UserEntity());
		QueryResponse result = userConverter.saveUser(new Request());
		assertNotEquals(expected, result);
	}

}
