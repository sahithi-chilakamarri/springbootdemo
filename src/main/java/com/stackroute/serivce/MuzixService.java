package com.stackroute.serivce;

import com.stackroute.domain.Muzix;

import java.util.List;
//Service interface
public interface MuzixService {
    //methods in the interface
    public Muzix saveMuzix(Muzix muzix);

    public List<Muzix> getAllMuzics();

    public Muzix deleteMuzix(int id);

    public Muzix updateMuzix(Muzix muzix);

}
