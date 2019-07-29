package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.repository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
public class MuzixServiceTest {
    //Mocking the muzixrepository
    @Mock
    MuzixRepository muzixRepository;
    //Injecting mock into muzixservice
    @InjectMocks
    MuzixServiceImpl muzixService;
    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }
    //Testing saving the track
    @Test
    public void testSaveTrack() throws TrackAlreadyExistsException {
    Muzix muzix=new Muzix(1,"Hello","Good");
    when(muzixRepository.save((Muzix)any())).thenReturn(muzix);
    Muzix muzix2 = muzixService.saveTrack(muzix);
    Assert.assertEquals(muzix,muzix2);
    verify(muzixRepository,times(1)).save(muzix);
    }
    //Testing to get all the tracks
    @Test
    public void getAllTracks()
    {
        Muzix muzix=new Muzix(1,"Hello","Good");
        List<Muzix> list=new ArrayList<>();
        list.add(muzix);
        muzixRepository.save(muzix);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Muzix> muzixlist =muzixService.getAllTracks();
        Assert.assertEquals(list,muzixlist);
    }
    //Testing for deleting the track
    @Test
    public void testDeleteTrack() throws Exception {
        Muzix muzix1=new Muzix(1,"Hello","Good");
        Muzix muzix2=new Muzix(2,"Hello","Good");
        List<Muzix> list=new ArrayList<>();
        list.add(muzix1);
       muzixRepository.delete(muzix2);
    }
    //Test case for the update track
    @Test
    public void updateTrack()
    {
        Muzix muzix1=new Muzix(1,"Hello","Good");
        Muzix muzix2=new Muzix(2,"Hello","Bad");
        when(muzixRepository.save(muzix1)).thenReturn(muzix2);
        Muzix muzix=muzixService.updateTrack(muzix1.getTrackId(),muzix2);
        Assert.assertEquals(muzix2,muzix);
    }
}
