package com.stackroute.exceptions;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import org.apache.tomcat.jni.Global;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalClassExceptionHandler{


    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity handleMyException(final TrackAlreadyExistsException exc) {

        return new ResponseEntity(exc.getMessage(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity handleException(final TrackNotFoundException ex) {

        return new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
    }
}