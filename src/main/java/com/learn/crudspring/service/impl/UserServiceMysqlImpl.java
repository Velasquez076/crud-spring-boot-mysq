package com.learn.crudspring.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.learn.crudspring.exception.GlobalException;
import com.learn.crudspring.persistence.model.UserEntity;
import com.learn.crudspring.persistence.repository.UserRepository;
import com.learn.crudspring.service.UserService;
import com.learn.crudspring.util.MessageEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julián Velásquez
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceMysqlImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<UserEntity> findAll() {
    log.info(".:: Init find all ::.");
    var lstUser = userRepository.findAll();
    if (!lstUser.isEmpty()) {
      return lstUser;
    }
    return new ArrayList<>();
  }

  @Override
  public UserEntity findById(Long id) {
    log.info(".:: Init find by id ::.");
    return userRepository.findById(id)
        .orElseThrow(() -> new GlobalException(MessageEnum.NOT_FOUND.getCode(),
            MessageEnum.NOT_FOUND.getMessage()));
  }

  @Override
  @Transactional
  public UserEntity save(UserEntity user) {

    if (user.getId() != null) {

      var findUser = userRepository.findById(user.getId())
          .orElseThrow(() -> new GlobalException(MessageEnum.NOT_FOUND.getCode(),
              MessageEnum.NOT_FOUND.getMessage()));

      log.info(".:: User already exist ::.");
      throw new GlobalException(MessageEnum.USER_EXIST.getCode(),
          String.format(MessageEnum.USER_EXIST.getMessage(), findUser.getId()));
    }
    return userRepository.save(user);
  }
}
