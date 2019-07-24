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

    //Constructor
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving the track
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) {
        ResponseEntity responseEntity;
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
        return new ResponseEntity(muzixService.getAllMuzics(), HttpStatus.OK);
    }

    //Deleting the track
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) {

        return new ResponseEntity<Boolean>(muzixService.deleteMuzix(muzix.getId()), HttpStatus.OK);
    }

    //Updating the track
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        return new ResponseEntity<>(muzixService.updateMuzix(muzix), HttpStatus.OK);
    }
    //Retrieving data by name
    @GetMapping("trackByName")
    public ResponseEntity<?> trackByNames(@RequestBody Muzix muzix){
        return new ResponseEntity<>(muzixService.getTrackByName(muzix.getName()),HttpStatus.OK);
    }
}
