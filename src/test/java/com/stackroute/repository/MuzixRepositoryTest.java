package com.stackroute.repository;

import com.stackroute.domain.Muzix;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MuzixRepositoryTest {
    @Autowired
    MuzixRepository muzixRepository;
    private Muzix muzix=new Muzix();
    @Before
    public void setUp() {
        muzix.setTrackId(1);
        muzix.setTrackName("Hello");
        muzix.setComments("Nice");
    }
    @Test
    public void testSaveTrack()
    {
        muzixRepository.save(muzix);
        Muzix muzix1 = muzixRepository.findById(muzix.getTrackId()).get();
        Assert.assertEquals(1,muzix1.getTrackId());
    }
    //test case for getting all the tracks
    @Test
    public void getAllTracks()
    {
        List<Muzix> tracks = new ArrayList<>();
        Muzix track1 = new Muzix(1,"Hello","Good");
        Muzix track2 = new Muzix(1,"Hello","Good");;
        tracks.add(track1);
        tracks.add(track2);
        List<Muzix> trackslist = muzixRepository.findAll();
        Assert.assertEquals(tracks,trackslist);
    }
}
