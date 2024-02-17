package com.learn.crudspring.controller;

import static com.learn.crudspring.controller.constants.ControllerConstants.USERS;
import static com.learn.crudspring.controller.constants.ControllerConstants.USER_RESOURCE;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.crudspring.dto.QueryResponse;
import com.learn.crudspring.dto.Request;
import com.learn.crudspring.persistence.model.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Julian Velasquez
 *
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = USER_RESOURCE)
class UserController {

  private final UserConverter userConverter;

  @GetMapping(path = USERS, produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<QueryResponse<List<UserEntity>>> findAll() {
    log.info(".:: Controller user find all ::.");
    return new ResponseEntity<>(userConverter.findAll(), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<QueryResponse<UserEntity>> saveUser(@RequestBody Request request) {
    log.info(".:: Controller save user ::.");
    return new ResponseEntity<>(userConverter.saveUser(request), HttpStatus.CREATED);
  }
}
