package com.stackroute.serivce;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    //Autowiring the muzix repository
    @Autowired
    MuzixRepository muzixRepository;

    //constructor
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    //creating the track
    @Override
    public Muzix saveMuzix(Muzix muzix) {

        return muzixRepository.save(muzix);
    }

    //retrieving all the tracks
    @Override
    public List<Muzix> getAllMuzics() {
        return muzixRepository.findAll();
    }

    //Deleting the track
    @Override
    public boolean deleteMuzix(int id) {
        muzixRepository.deleteById(id);
        return true;
    }

    //Updating the existing track
    @Override
    public Muzix updateMuzix(Muzix muzix) {
        Optional<Muzix> muzix1 = muzixRepository.findById(muzix.getId());

        if (muzix1.isPresent()) {
            Muzix newEntity = muzix1.get();
            newEntity.setId(muzix.getId());
            newEntity.setName(muzix.getName());
            newEntity.setTrack(muzix.getTrack());
            newEntity = muzixRepository.save(newEntity);
            return newEntity;
        } else {
            muzix = muzixRepository.save(muzix);

            return muzix;
        }
    }
    //Tracking the data by name
    @Override
    public List<Muzix> getTrackByName(String name) {
        Muzix muzix=new Muzix();
        muzix.setName(name);
        return muzixRepository.trackByName(muzix.getName());
    }
}

