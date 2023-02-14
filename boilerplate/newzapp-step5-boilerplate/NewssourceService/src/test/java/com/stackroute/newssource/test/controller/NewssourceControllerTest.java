package com.stackroute.newssource.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.newssource.controller.NewssourceController;
import com.stackroute.newssource.model.Newssource;

import com.stackroute.newssource.service.NewssourceService;
import com.stackroute.newssource.util.exception.NewssourceNotFoundException;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class NewssourceControllerTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private MockMvc mockMvc;
    private Newssource newssource;
    @MockBean
    private NewssourceService newssourceService;
    @InjectMocks
    private NewssourceController newssourceController;
    private List<Newssource> allNewssource = null;


    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(newssourceController).build();
        newssource = new Newssource();

        newssource.setNewssourceId(1);
        newssource.setNewssourceName("CNN");
        newssource.setNewssourceDesc("CNN - US");
        newssource.setNewssourceCreatedBy("Becky123");
        newssource.setNewssourceCreationDate();

        allNewssource = new ArrayList<>();
        allNewssource.add(newssource);


    }

    @Test
    public void createNewssourceSuccess() throws Exception {
        when(newssourceService.addNewssource(any())).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/newssource")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(newssource)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void createNewssourceFailure() throws Exception {

        when(newssourceService.addNewssource(any())).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/newssource")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(newssource)))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void deleteNewssourceSuccess() throws Exception {

        when(newssourceService.deleteNewssource(1)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/newssource/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void deleteNewssourceFailure() throws Exception {

        when(newssourceService.deleteNewssource(1)).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/newssource/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void updateNewssourceSuccess() throws Exception {

        when(newssourceService.updateNewssource(any(), eq(newssource.getNewssourceId()))).thenReturn(newssource);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/newssource/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(newssource)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateNewssourceFailure() throws Exception {

        when(newssourceService.updateNewssource(any(), eq(newssource.getNewssourceId()))).thenThrow(NewssourceNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/newssource/1")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(newssource)))
                .andExpect(MockMvcResultMatchers.status().isNotFound()).andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void getNewssourceByIdSuccess() throws Exception {
        when(newssourceService.getNewssourceById(newssource.getNewssourceCreatedBy(),newssource.getNewssourceId())).thenReturn(newssource);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/newssource/Becky123/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void getNewssourceByIdFailure() throws Exception {
    	int newssourceId = newssource.getNewssourceId();
        when(newssourceService.getNewssourceById(newssource.getNewssourceCreatedBy(),newssourceId)).thenThrow(NewssourceNotFoundException.class);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/newssource/Becky123/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}