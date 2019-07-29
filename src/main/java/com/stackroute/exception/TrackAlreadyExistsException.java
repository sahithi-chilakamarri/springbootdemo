package com.stackroute.exception;

    //Custom exception
    public class TrackAlreadyExistsException extends Exception {
        //Display message
        private String message;
        //Default and parameterize constructors
        public TrackAlreadyExistsException() {
        }
        public TrackAlreadyExistsException(String message)
        {
            //Calling the super class constructor
            super(message);
            this.message=message;
        }
    }


