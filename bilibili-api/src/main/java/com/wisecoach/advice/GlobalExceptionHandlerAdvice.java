package com.wisecoach.advice;

import com.wisecoach.exception.ResponseException;
import com.wisecoach.response.CustomResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResponseException.class)
    public CustomResponseEntity handleResponseException(HttpServletRequest req, HttpServletResponse resp, ResponseException e){
        System.out.println(e);
        return new CustomResponseEntity(e.getCode(), e.getMsg(), null);
    }

}
