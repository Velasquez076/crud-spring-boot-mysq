package com.learn.crudspring.exception.handler;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.learn.crudspring.dto.error.ResponseError;
import com.learn.crudspring.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@RestControllerAdvice
class HandlerGlobalError {

  @ExceptionHandler(value = {GlobalException.class})
  ResponseEntity<ResponseError> handlerNotFound(GlobalException ex) {

    log.error(ex.getMessage(), ex);

    var err = ResponseError.builder().uuid(UUID.randomUUID().toString()).code(ex.getCode())
        .message(ex.getMessage()).httpStatus(buildStatus(ex.getCode()).name()).build();

    return new ResponseEntity<>(err, buildStatus(ex.getCode()));
  }

  /*
   */
  private static HttpStatus buildStatus(int code) {
    return HttpStatus.valueOf(code);
  }
}
