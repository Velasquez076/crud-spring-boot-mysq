package com.learn.crudspring.dto;

import com.learn.crudspring.persistence.model.UserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Setter
@Getter
public class Request {

	private Long id;
	
	private UserEntity user;
}
