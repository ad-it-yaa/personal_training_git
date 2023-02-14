package com.natwest.natwestdb.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.natwest.natwestdb.model.Natwestdb;
import com.natwest.natwestdb.service.NatwestdbService;

@ExtendWith(MockitoExtension.class)
class NatwestdbControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NatwestdbService natwestdbService;

    @InjectMocks
    private NatwestdbController natwestdbController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(natwestdbController).build();
    }

    @Test
    void testGetuser() throws Exception {
        List<Natwestdb> natwestdbList = new ArrayList<>();
        natwestdbList.add(new Natwestdb("1", "matthew@gmail.com", "Matthew", "XXXXX", "9841558566", "9841558566", 0, 0));
        when(natwestdbService.getuser()).thenReturn(natwestdbList);
        mockMvc.perform(get("/api/natwestdb/get"))
                .andExpect(status().isOk());
    }
    @Test
    void testGetuser1() throws Exception {
        List<Natwestdb> natwestdbList = new ArrayList<>();
        natwestdbList.add(new Natwestdb("2", "jose@gmail.com", "jose", "XXXXX", "7941558566", "7941558566", 0, 0));
        when(natwestdbService.getuser()).thenReturn(natwestdbList);
        mockMvc.perform(get("/api/natwestdb/get"))
                .andExpect(status().isOk());
    }
}
