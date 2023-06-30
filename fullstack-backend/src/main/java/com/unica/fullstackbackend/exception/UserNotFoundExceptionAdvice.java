package com.unica.fullstackbackend.exception;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundExceptionAdvice {

    @ResponseBody
    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus
    public Map<String, String> exceptionHandler(UserNotFoundException exception){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error message",exception.getMessage());
        return errorMap;
    }
}
