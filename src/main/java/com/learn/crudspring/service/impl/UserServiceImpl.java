package com.learn.crudspring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.crudspring.persistence.model.UserEntity;
import com.learn.crudspring.persistence.respository.UserRepository;
import com.learn.crudspring.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public List<UserEntity> findAll() {
		log.info(".:: Init find all ::.");
		List<UserEntity> lstUser = userRepository.findAll();
		if (!lstUser.isEmpty()) {
			return lstUser;
		}
		return new ArrayList<>();
	}

	@Override
	public UserEntity findById(Long id) {
		log.info(".:: Init find by id ::.");
		UserEntity userFound = userRepository.findById(id).orElse(null);
		if (userFound != null) {
			return userFound;
		}
		return new UserEntity();
	}

	@Override
	@Transactional
	public UserEntity save(UserEntity user) {
		UserEntity findUser = userRepository.findById(user.getId()).orElse(null);
		if (findUser != null) {
			log.info(".:: User already exist ::.");
			return findUser;
		}
		return userRepository.save(user);
	}

}
