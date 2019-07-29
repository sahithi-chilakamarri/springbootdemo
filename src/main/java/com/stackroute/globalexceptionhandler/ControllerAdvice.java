package com.stackroute.globalexceptionhandler;

import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;
//This class is used to handle the exceptions with out writing them in the controller class
public class ControllerAdvice { 
    //Craeting response entity to display the message
    private ResponseEntity <VndErrors> error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
        //To display the exception message and information
        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
        return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
    }
    //Handling the tracknot found exception
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity < VndErrors > notFoundException(final TrackNotFoundException exception) {
        //To display the exception message and information and httpstatus
        return error(exception, HttpStatus.NOT_FOUND, exception.getMessage().toString());
    }
    //Handling the trackalreadyexists exception
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity < VndErrors > alreadyExistsException(final TrackAlreadyExistsException exception) {
        //To display the exception message and information and httpstatus
        return error(exception, HttpStatus.NOT_FOUND, exception.getMessage());
    }

}
