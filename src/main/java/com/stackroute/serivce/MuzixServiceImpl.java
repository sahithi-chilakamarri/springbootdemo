package com.stackroute.serivce;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import sun.tools.java.Environment;

import java.util.List;
import java.util.Optional;

@Service
@PropertySource("application.properties")
public class MuzixServiceImpl implements MuzixService, ApplicationListener<ContextRefreshedEvent>, CommandLineRunner {
    @Autowired
    private Environment environment;
    //Adding the default values to the database by using Application listener
    @Value("${muzix.1.id:default}")
    int id1;
    @Value("${muzix.1.name:default}")
    String name1;
    @Value("${muzix.1.track:default}")
    String track1;
    @Value("${muzix.2.id:default}")
    int id2;
    @Value("${muzix.2.name:default}")
    String name2;
    @Value("${muzix.2.track:default}")
    String track2;
    //Overriding the commandlinerunner method
    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line running before application starts");
    }
    //Overriding application context method
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Running ContextRefreshedEvent");
        muzixRepository.save(new Muzix(id1,name1,track1));
        muzixRepository.save(new Muzix(id2, name2, track2));
    }
    //Autowiring the muzix repository
    @Autowired
   private MuzixRepository muzixRepository;

    //constructor
    public MuzixServiceImpl(MuzixRepository muzixRepository) {
        this.muzixRepository = muzixRepository;
    }

    //creating the track
    @Override
    public Muzix saveMuzix(Muzix muzix) throws TrackAlreadyExistsException {

        if(muzixRepository.existsById(muzix.getId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return muzixRepository.save(muzix);
    }

    //retrieving all the tracks
    @Override
    public List<Muzix> getAllMuzics() {
        return muzixRepository.findAll();
    }

    //Deleting the track
    @Override
    public boolean deleteMuzix(int id) throws TrackNotFoundException {
        if(!muzixRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        return muzixRepository.deleteById(id);
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
}

