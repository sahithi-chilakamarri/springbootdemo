package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.serivce.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
//Controller class
public class MuzixController {
    //Creating object for the muzix service
   private MuzixService muzixService;
   private ResponseEntity responseEntity;
    //Constructor
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving the track
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix)  throws TrackAlreadyExistsException {
            muzixService.saveMuzix(muzix);
            responseEntity = new ResponseEntity("successfully created", HttpStatus.CREATED);
        return responseEntity;


    }
    //Retrieving all the tracks
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix() {
        return new ResponseEntity(muzixService.getAllMuzics(), HttpStatus.OK);
    }

    //Deleting the track
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {

        ResponseEntity responseEntity;

            responseEntity=new ResponseEntity<>(muzixService.deleteMuzix(muzix.getId()), HttpStatus.OK);
        return responseEntity;

    }

    //Updiatng the track
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        return new ResponseEntity<>(muzixService.updateMuzix(muzix), HttpStatus.OK);
    }
}
