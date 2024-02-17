package com.learn.crudspring;

import java.util.ArrayList;
import java.util.List;

import com.learn.crudspring.persistence.model.UserEntity;

/**
 * 
 * @author juveme88
 *
 */
public class MocksUtil {

	private MocksUtil() {

	}

	public static List<UserEntity> buildResponse() {
		List<UserEntity> list = new ArrayList<>();
		list.add(buildObjectEntity());
		list.add(buildObjectEntity());
		return list;
	}

	public static UserEntity buildObjectEntity() {
		UserEntity model = new UserEntity();
		model.setId(1L);
		model.setNombre("Any");
		model.setApellido("Any");
		model.setEmail("Email");
		model.setTelefono("3125454");
		return model;
	}

}
