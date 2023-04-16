package com.learn.crudspring.persistence.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.crudspring.persistence.model.UserEntity;

/**
 * 
 * @author juveme88
 *
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
