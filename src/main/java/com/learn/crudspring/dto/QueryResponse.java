package com.learn.crudspring.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.learn.crudspring.persistence.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class QueryResponse {

	private String uuid;

	private HttpStatus status;

	@JsonProperty(value = "status_code")
	private int statusCode;

	@JsonInclude(value = Include.NON_EMPTY)
	@JsonProperty(value = "Users")
	private List<UserEntity> lstUsers;

	@JsonInclude(value = Include.NON_NULL)
	@JsonProperty(value = "User")
	private UserEntity user;

}
