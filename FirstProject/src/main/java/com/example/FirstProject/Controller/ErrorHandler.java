package com.example.FirstProject.Controller;

import com.example.FirstProject.Exception.NotFoundException;
import com.example.FirstProject.Model.RestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public RestErrorResponse notFoundException(NotFoundException e)
    {return  new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()
    );
    }
}
