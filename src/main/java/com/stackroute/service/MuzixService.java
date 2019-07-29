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
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException;

    public List<Muzix> getAllTracks();

    public Muzix updateTrack(int trackId,Muzix muzix);

    public List<Muzix> deleteTrack(int trackId) throws TrackNotFoundException;

    public void getTopTracks();

    public List<Muzix> getTracksByName(String name);


}
