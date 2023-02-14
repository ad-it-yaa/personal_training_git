package com.stackroute.newssource.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.stackroute.newssource.model.Newssource;
import com.stackroute.newssource.repository.NewssourceRepository;
import com.stackroute.newssource.service.NewssourceServiceImpl;
import com.stackroute.newssource.util.exception.NewssourceNotFoundException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class NewssourceServiceImplTest {

	@MockBean
    private Newssource newssource;
    @Mock
    private NewssourceRepository newssourceRepository;
    @InjectMocks
    private NewssourceServiceImpl newssourceServiceImpl;
    private List<Newssource> allNewssource = null;
    Optional<Newssource> options;

    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        newssource = new Newssource();

        newssource.setNewssourceId(1);
        newssource.setNewssourceName("Cricket-Category");
        newssource.setNewssourceDesc("All about Cricket");
        newssource.setNewssourceCreatedBy("Becky123");
        newssource.setNewssourceCreationDate();

        allNewssource = new ArrayList<>();
        allNewssource.add(newssource);
        options = Optional.of(newssource);
    }

    @Test
    public void createNewssourceTestSuccess() throws Exception {

        when(newssourceRepository.insert(newssource)).thenReturn(newssource);
        boolean savedNewssource = newssourceServiceImpl.addNewssource(newssource);
        assertThat(savedNewssource,is(true));


    }
    
    @Test
    public void createNewssourceTestFailure() throws Exception {

        when(newssourceRepository.insert(newssource)).thenReturn(null);
        boolean savedNewssource = newssourceServiceImpl.addNewssource(newssource);
        assertThat(savedNewssource, is(false));

    }

    @Test
    public void deleteNewssourceSuccess() throws Exception {
        when(newssourceRepository.findById(newssource.getNewssourceId())).thenReturn(options);
        when(newssourceRepository.save(newssource)).thenReturn(newssource);
        boolean flag = newssourceServiceImpl.deleteNewssource(1);
        assertThat(true, is(flag));
    }


    @Test
    public void deleteNewssourceFailure() throws Exception {
        when(newssourceRepository.findById(newssource.getNewssourceId())).thenReturn(null);
        when(newssourceRepository.save(newssource)).thenReturn(newssource);
        boolean flag = newssourceServiceImpl.deleteNewssource(newssource.getNewssourceId());
        assertThat(false, is(flag));
    }


    @Test
    public void updateNewssourceTestSuccess() throws NewssourceNotFoundException {
        when(newssourceRepository.findById(newssource.getNewssourceId())).thenReturn(options);
        newssource.setNewssourceDesc("All about cricket and other sports");
        Newssource fetchedNewssource = newssourceServiceImpl.updateNewssource(newssource, newssource.getNewssourceId());
        assertThat(fetchedNewssource, is(newssource));

    }

    @Test
    public void updateNewssourceTestFailure() throws NewssourceNotFoundException {
        when(newssourceRepository.findById(newssource.getNewssourceId())).thenReturn(options);
        newssource.setNewssourceDesc("All about cricket and other sports");
        Newssource fetchedNewssource = newssourceServiceImpl.updateNewssource(newssource, newssource.getNewssourceId());
        assertThat(fetchedNewssource, is(newssource));

    }


    @Test
    public void getNewssourceByIdTestSuccess() throws NewssourceNotFoundException {

        when(newssourceRepository.findAllNewssourceByNewssourceCreatedBy("Becky123")).thenReturn(allNewssource);
        Newssource fetchedNewssource = newssourceServiceImpl.getNewssourceById("Becky123",1);
        System.out.println("Orange "+allNewssource);
        assertNotNull(fetchedNewssource);

        
    }

    @Test
    public void getNewssourceByIdTestFailure() throws NewssourceNotFoundException {
    	when(newssourceRepository.findAllNewssourceByNewssourceCreatedBy("Becky123")).thenThrow(NoSuchElementException.class);
    	Newssource fetchedNewssource = newssourceServiceImpl.getNewssourceById(newssource.getNewssourceCreatedBy(),newssource.getNewssourceId());
        assertNull(fetchedNewssource);

    }


    @Test
    public void getAllNewssourceByUserIdTestSuccess() {
    	String createdBy = newssource.getNewssourceCreatedBy();
        when(newssourceRepository.findAllNewssourceByNewssourceCreatedBy(createdBy)).thenReturn(allNewssource);
        
        List<Newssource> fetchedNewssource = newssourceServiceImpl.getAllNewssourceByUserId("Becky123");
        assertThat(fetchedNewssource, is(allNewssource));

    }
}