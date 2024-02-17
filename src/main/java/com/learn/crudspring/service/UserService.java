package com.learn.crudspring.service;

import java.util.List;
import com.learn.crudspring.persistence.model.UserEntity;

/**
 * 
 * @author juveme88
 *
 */
public interface UserService {

  List<UserEntity> findAll();

  UserEntity findById(Long id);

  UserEntity save(UserEntity user);
}
