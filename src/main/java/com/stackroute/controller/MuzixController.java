package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.serivce.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
//Controller class
public class MuzixController {
    //Creating object for the muzix service
    MuzixService muzixService;

    //parameterized Constructor
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving the track
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) {
        ResponseEntity responseEntity;
        //calling the saveMuzix() in service
        try {
            muzixService.saveMuzix(muzix);
            responseEntity = new ResponseEntity("successfully created", HttpStatus.CREATED);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    //Retrieving all the tracks
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix() {
         //calling the getAllMuzix() in service
        return new ResponseEntity(muzixService.getAllMuzics(), HttpStatus.OK);
    }

    //Deleting the track
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) {
     //calling the deleteMuzix() in service
        return new ResponseEntity<Boolean>(muzixService.deleteMuzix(muzix.getId()), HttpStatus.OK);
    }

    //Updiatng the track
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
         //calling the updateMuzix() in service
        return new ResponseEntity<>(muzixService.updateMuzix(muzix), HttpStatus.OK);
    }
}
