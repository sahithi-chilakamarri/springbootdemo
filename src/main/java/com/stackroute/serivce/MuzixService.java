package com.stackroute.serivce;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;
//Service interface
public interface MuzixService {
    //methods in the interface
    public Muzix saveMuzix(Muzix muzix) throws TrackAlreadyExistsException;

    public List<Muzix> getAllMuzics();

    public boolean deleteMuzix(int id) throws TrackNotFoundException;

    public Muzix updateMuzix(Muzix muzix);

}
