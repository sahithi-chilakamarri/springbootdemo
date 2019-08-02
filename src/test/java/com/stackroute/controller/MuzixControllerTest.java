package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.controller.MuzixController;
import com.stackroute.domain.Muzix;
import com.stackroute.service.MuzixService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MuzixControllerTest {
    //creating the mockmvc object
    @Autowired
    private MockMvc mockMvc;
    //Mocking muzix service
    @Mock
    private MuzixService muzixService;
    //Injecting mock into muzix controller
    @InjectMocks
    private MuzixController muzixController;
   @Before
     public void setUp() {
       MockitoAnnotations.initMocks(this);
       mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();
   }
   //Test case for the save track
   @Test
    public void testSaveTrack() throws Exception {
        //creating muzix object
       Muzix muzix1=new Muzix(1,"Hello","Good");
       when(muzixService.saveTrack(any())).thenReturn(muzix1);
       mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/muzix")
               .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix1)))
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andDo(MockMvcResultHandlers.print());
   }
   //Test case for getting all the tracks
    @Test
    public void testGetAllTracks() throws Exception {
        Muzix muzix1=new Muzix(1,"Hello","Good");
        List<Muzix> list=new ArrayList<>();
        list.add(muzix1);
        when(muzixService.getAllTracks()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
    //Testcase for the delete track
    @Test
    public void testDeleteTrack() throws Exception {
        Muzix muzix1=new Muzix(1,"Hello","Good");
        Muzix muzix2=new Muzix(2,"Hello","Good");
        List<Muzix> list=new ArrayList<>();
        list.add(muzix1);
        when(muzixService.deleteTrack(muzix1.getTrackId())).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/muzix")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(muzix1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    //Testcase for the update track
    @Test
    public void testUpdateTrack() throws Exception {
        Muzix muzix1=new Muzix(1,"Hello","Good");
        Muzix muzix2=new Muzix(2,"Hello","Bad");
        when(muzixService.updateTrack(muzix1.getTrackId(),muzix2)).thenReturn(muzix2);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/muzix")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(muzix1)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    //JsonToString method
    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
