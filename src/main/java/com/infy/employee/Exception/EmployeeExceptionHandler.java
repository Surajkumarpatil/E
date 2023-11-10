package com.infy.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorInfo> EmployeeNotFoundException(NotFoundException exception){
        String message=exception.getMessage();
        ErrorInfo errorInfo = new ErrorInfo(new Date(),message,false);
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorInfo> EmployeeAlreadyExistsException(AlreadyExistsException exception){
        String message=exception.getMessage();
        ErrorInfo errorInfo = new ErrorInfo(new Date(),message,false);
        return new ResponseEntity<>(errorInfo, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorInfo> EmployeeException(EmployeeException exception){
        String message=exception.getMessage();
        ErrorInfo errorInfo = new ErrorInfo(new Date(),message,false);
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
