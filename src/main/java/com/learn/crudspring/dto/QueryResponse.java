package com.learn.crudspring.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.crudspring.persistence.model.UserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@Setter
public class QueryResponse {
	
	private String uuid;
	
	private HttpStatus status;
	
	@JsonProperty(value = "Users")
	private List<UserEntity> lstUsers;

}
