package com.gafur.test.avrios.utility;

import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, FeignException.class})
  protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
    return handleExceptionInternal(
        ex,
        "Inputs are incorrect, please try again using other inputs",
        new HttpHeaders(),
        HttpStatus.BAD_REQUEST,
        request
    );
  }

  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<Object> handleInternalServerError(Exception ex, WebRequest request) {
    return handleExceptionInternal(
        ex,
        "Can't process your request, please contact gafurov0ivan@gmail.com",
        new HttpHeaders(),
        HttpStatus.INTERNAL_SERVER_ERROR,
        request
    );
  }
}
