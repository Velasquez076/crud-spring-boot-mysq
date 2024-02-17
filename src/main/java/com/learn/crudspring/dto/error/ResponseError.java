package com.learn.crudspring.dto.error;

import lombok.Builder;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@Builder
public class ResponseError {

  private String uuid;
  
  private int code;
  
  private String httpStatus;

  private String message;
}
