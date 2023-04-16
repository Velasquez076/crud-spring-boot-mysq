package com.learn.crudspring.dto;

import com.learn.crudspring.persistence.model.UserEntity;

import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
public class Request {

	private Long id;
	
	private UserEntity user;
}
