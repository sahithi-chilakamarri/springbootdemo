package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

//Service interface
public interface MuzixService {
//We have to implement all the methods in the implementation class
    //To save the track
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException;
     //To get all the tracks
    public List<Muzix> getAllTracks();
     //To update the track
    public Muzix updateTrack(int trackId,Muzix muzix);
     //To delete the track
    public List<Muzix> deleteTrack(int trackId) throws TrackNotFoundException;
     //To get the toptracks in api
    public void getTopTracks();
    //To get the tracks by name
    public List<Muzix> getTracksByName(String name);


}
