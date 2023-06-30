package com.unica.fullstackbackend.exception;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Use with id "+id+ " Not exist");
    }
}
