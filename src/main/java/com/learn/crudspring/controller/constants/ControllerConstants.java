package com.learn.crudspring.controller.constants;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ControllerConstants {

  public static final String USER_RESOURCE = "api/users/";

  public static final String USERS = "/all";

  public static final String USER_BY_ID = "/id";
}
