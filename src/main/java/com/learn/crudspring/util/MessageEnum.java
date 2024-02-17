package com.learn.crudspring.util;

import lombok.Getter;

/**
 * 
 * @author Julián Velásquez
 *
 */
public enum MessageEnum {

  NOT_FOUND(404, ".:: User not found, try again ::."), USER_EXIST(400,
      "User already exists with ID %s");

  @Getter
  private int code;

  @Getter
  private String message;

  private MessageEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

}
