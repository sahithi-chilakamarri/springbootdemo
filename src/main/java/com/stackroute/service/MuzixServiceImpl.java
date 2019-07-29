package com.stackroute.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.Track;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    //Autowiring the muzixrepository
    @Autowired
    MuzixRepository muzixRepository;
    //Parameterized constructor
    public MuzixServiceImpl(MuzixRepository muzixRepository)
    {

        this.muzixRepository = muzixRepository;
    }
    //Saving the track to the database
    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(muzix.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        return muzixRepository.save(muzix);
    }
    //Retrieving all the tracks from the database
    @Override
    public List<Muzix> getAllTracks() {

        return muzixRepository.findAll();
    }

    @Override
    //Updating  the track using id and comments
    public Muzix updateTrack(int trackId,Muzix muzix) {
        //If the id exists then set the comments to the given comments and saving the commenst
        muzix.setTrackId(trackId);
       if( muzixRepository.existsById(trackId)) {
          muzixRepository.save(muzix);
       }
        return muzix;
    }
    //Deleting the track using id
    @Override
    public List<Muzix> deleteTrack(int trackId) throws TrackNotFoundException {
        if(!muzixRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("Track not found");
        }
        muzixRepository.deleteById(trackId);
        return muzixRepository.findAll();
    }
    //Getting the track according to the name
    @Override
    public List<Muzix> getTracksByName(String name) {

        return muzixRepository.getTrackByName(name);

    }
    //Getting all the tracks from the service and converting into the java object and saving it into the database
    @Override
    public void getTopTracks() {
        RestTemplate restTemplate = new RestTemplate();
        //Url of the third party service
            String url="http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=spain&api_key=47f81c40cf8d8c31295d864414978071&format=json";
            //Getting all the tracks from the thirdparty api service(lastfm)
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            //Creating object for the object mapper
            ObjectMapper objectMapper = new ObjectMapper();
            //Making root node  as null
            JsonNode root = null;
        try {
            //Getting the data from the api to the root object
            root = (JsonNode) objectMapper.readTree(responseEntity.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayNode arraynode = (ArrayNode) root.path("tracks").path("track");
        //Saving the tracks to the object
            try {
                for (int i = 0; i <= arraynode.size(); i++) {
                    Muzix track = new Muzix();
                    track.setTrackId(i + 1);
                    track.setTrackName(arraynode.get(i).path("name").asText());
                    track.setComments(arraynode.get(i).path("artist").path("name").asText());
                    //Saving it to the database
                    muzixRepository.save(track);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}

