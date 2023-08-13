package com.gamelibrary.controller;

import com.gamelibrary.exception.CustomException;
import com.gamelibrary.model.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CustomException.class})
    public ResponseEntity<ErrorDTO> handlerCustomException(CustomException customException) {
        var error = new ErrorDTO();

        error.setMsg(customException.getMessage());
        error.setCode(404);
        error.setTimesTamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


}
