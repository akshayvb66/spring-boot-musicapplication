package com.stackroute.exceptions;

import org.springframework.http.ResponseEntity;

public class TrackAlreadyExistsException extends Exception {

    private String message;



    public TrackAlreadyExistsException() {
    }


    public TrackAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
