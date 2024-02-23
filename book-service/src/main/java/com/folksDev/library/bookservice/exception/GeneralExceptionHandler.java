package com.folksDev.library.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    //uygulama esnasında üretilen bir exceptionı bir Rest respnsuna çevirebilmek için kulklanırız.
    // yani hatanın ne oldugunu servis üzerinden anlayabileyim.

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> handle (BookNotFoundException exception)
    {
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
