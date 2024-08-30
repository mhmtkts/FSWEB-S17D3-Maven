package com.workintech.zoo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class ZooGlobalExceptionHandler {


    @ExceptionHandler
    private ResponseEntity<ZooErrorResponse> handleException(ZooException zooException) {
        log.error(zooException.getMessage());
        ZooErrorResponse errorResponse = new ZooErrorResponse(zooException.getHttpStatus().value(),zooException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, zooException.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<ZooErrorResponse> handleException(Exception zooException) {
        log.error(zooException.getMessage());
        ZooErrorResponse errorResponse = new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), zooException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
