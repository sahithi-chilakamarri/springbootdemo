package com.stackroute.controller;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
//Controller class
public class MuzixController {
    //Creating object for the muzix service
    private MuzixService muzixService;
     private ResponseEntity responseEntity;
    //Parameterized Constructor
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving the track 
    @PostMapping("muzix")
    //Handler method for savinvg the track
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        //Saving the track
        muzixService.saveTrack(muzix);
        //HttpStatus Code
        responseEntity = new ResponseEntity("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    //Retrieving all the tracks
    @GetMapping("muzix")
    //Handler method for getting the tracks
    public ResponseEntity<?> getAllMuzix(String url, Class<Muzix> muzixClass) {
        //To get all the tracks from the api and store it to the database.
        muzixService.getTopTracks();
        //HttpStatus code
        return new ResponseEntity(muzixService.getAllTracks(), HttpStatus.OK);
    }

    //Deleting the track
    @DeleteMapping("muzix")
    //Handler method for the delete tracks
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {
        //HttpStatusCode
        return new ResponseEntity(muzixService.deleteTrack(muzix.getTrackId()), HttpStatus.OK);
    }

    //Updating the track
    @PutMapping("muzix")
    //Handler method for the updating tracks
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        //HttpStatus Code
        return new ResponseEntity<>(muzixService.updateTrack(muzix.getTrackId(), muzix), HttpStatus.OK);
    }
    //Getting all the tracks matched by the name
    @GetMapping("trackByName")
    //Handler method for the track by name
    public ResponseEntity<?> getTrackByName(@RequestParam String name) throws TrackNotFoundException {
        //HttpStatus code
        return new ResponseEntity<List<Muzix>>(muzixService.getTracksByName(name), HttpStatus.OK);
    }
}


