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

    //Constructor
    public MuzixController(MuzixService muzixService) {
        this.muzixService = muzixService;
    }

    //Saving the track
    @PostMapping("muzix")
    public ResponseEntity<?> saveMuzix(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        //Saving the track
        muzixService.saveTrack(muzix);
        responseEntity = new ResponseEntity("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }

    //Retrieving all the tracks
    @GetMapping("muzix")
    public ResponseEntity<?> getAllMuzix(String url, Class<Muzix> muzixClass) {
        //To get all the tracks from the api and store it to the database.
        muzixService.getTopTracks();
        return new ResponseEntity(muzixService.getAllTracks(), HttpStatus.OK);
    }

    //Deleting the track
    @DeleteMapping("muzix")
    public ResponseEntity<?> deleteMuzix(@RequestBody Muzix muzix) throws TrackNotFoundException {
        return new ResponseEntity(muzixService.deleteTrack(muzix.getTrackId()), HttpStatus.OK);
    }

    //Updating the track
    @PutMapping("muzix")
    public ResponseEntity<?> updateMuzix(@RequestBody Muzix muzix) {
        return new ResponseEntity<>(muzixService.updateTrack(muzix.getTrackId(), muzix), HttpStatus.OK);
    }
    //Getting all the tracks matched by the name
    @GetMapping("trackByName")
    public ResponseEntity<?> getTrackByName(@RequestParam String name) throws TrackNotFoundException {
        return new ResponseEntity<List<Muzix>>(muzixService.getTracksByName(name), HttpStatus.OK);
    }
}


