package com.learn.crudspring.exception;

import lombok.Getter;

/*
 * 
 */
@Getter
public class GlobalException extends RuntimeException {

  private static final long serialVersionUID = 196321478L;

  private final int code;

  private final String message;


  public GlobalException(int code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }
}
