package com.learn.crudspring.controller.constants;

import org.springframework.stereotype.Component;

/**
 * 
 * @author juveme88
 *
 */
@Component
public class ControllerConstants {
	
	private ControllerConstants() {
		
	}

	public static final String USER_RESOURCE = "api/users/";

	public static final String USERS = "/all";

	public static final String USER_BY_ID = "/id";
}
