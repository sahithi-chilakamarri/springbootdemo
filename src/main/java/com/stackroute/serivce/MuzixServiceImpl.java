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
    private MuzixRepository muzixRepository;

    //constructor
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    //creating the track
    @Override
    public Muzix saveMuzix(Muzix muzix) {
    //Saving it to the database
        return muzixRepository.save(muzix);
    }

    //retrieving all the tracks from database
    @Override
    public List<Muzix> getAllMuzics() {
        return muzixRepository.findAll();
    }

    //Deleting the track
    @Override
    public Muzix deleteMuzix(int id) {
        return muzixRepository.deleteById(id);
    }

    //Updating the existing track
    @Override
    public Muzix updateMuzix(Muzix muzix) {
        Optional<Muzix> muzix1 = muzixRepository.findById(muzix.getId());
        //Updating the track in the database
        if (muzix1.isPresent()) {
            Muzix newEntity = muzix1.get();
            newEntity.setId(muzix.getId());
            newEntity.setName(muzix.getName());
            newEntity.setTrack(muzix.getTrack());
            newEntity = muzixRepository.save(newEntity);
            return newEntity;
        } else {
            muzix = muzixRepository.save(muzix);
        //Returining the updated database
            return muzix;
        }
    }
}

