package com.learn.crudspring.dto;

import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class QueryResponse<T> {

  private String uuid;

  private HttpStatus status;

  @JsonProperty(value = "status_code")
  private int statusCode;

  @JsonProperty(value = "Response")
  private T response;
}
