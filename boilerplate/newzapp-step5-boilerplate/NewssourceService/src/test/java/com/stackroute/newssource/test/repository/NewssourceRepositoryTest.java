package com.stackroute.newssource.test.repository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.stackroute.newssource.model.Newssource;
import com.stackroute.newssource.repository.NewssourceRepository;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class NewssourceRepositoryTest {

    @Autowired
    private NewssourceRepository newssourceRepository;
    private Newssource newssource;

    @BeforeEach
    public void setUp() throws Exception {
    	newssource = new Newssource();
    	newssource.setNewssourceId(1);
    	newssource.setNewssourceName("Cricket-Category");
    	newssource.setNewssourceDesc("All about Cricket");
    	newssource.setNewssourceCreatedBy("Jhon123");
    	newssource.setNewssourceCreationDate();
    }

    @AfterEach
    public void tearDown() throws Exception {

    	newssourceRepository.deleteAll();
    }

    @Test
    public void createNewssourceTest() {

    	newssourceRepository.insert(newssource);
    	Newssource fetchedNewssource = newssourceRepository.findById(newssource.getNewssourceId()).get();
        assertThat(1, is(fetchedNewssource.getNewssourceId()));

    }

    @Test
    public void deleteNewssourcetest() {

    	newssourceRepository.insert(newssource);
    	Newssource fetchedNewssource = newssourceRepository.findById(newssource.getNewssourceId()).get();
        assertThat(1, is(fetchedNewssource.getNewssourceId()));
        newssourceRepository.delete(fetchedNewssource);

    }

    @Test
    public void updateNewssourceTest() {

    	newssourceRepository.insert(newssource);
    	Newssource fetchedNewssource = newssourceRepository.findById(newssource.getNewssourceId()).get();
        assertThat(1, is(fetchedNewssource.getNewssourceId()));
        fetchedNewssource.setNewssourceDesc("All about T-20");
        newssourceRepository.save(fetchedNewssource);
        fetchedNewssource = newssourceRepository.findById(newssource.getNewssourceId()).get();
        assertThat("All about T-20", is(fetchedNewssource.getNewssourceDesc()));


    }

    @Test
    public void getNewssourceByIdTest() {

    	newssourceRepository.insert(newssource);
    	Newssource fetchedNewssource = newssourceRepository.findById(newssource.getNewssourceId()).get();
        assertThat(1, is(fetchedNewssource.getNewssourceId()));
    }

    @Test
    public void getAllNewssourceByUserId() {

    	newssourceRepository.insert(newssource);

    	newssource.setNewssourceId(2);
    	newssource.setNewssourceName("Badminton-Category");
    	newssource.setNewssourceDesc("All about Badminton");
    	newssource.setNewssourceCreatedBy("Jhon123");
    	newssource.setNewssourceCreationDate();

    	newssourceRepository.insert(newssource);

        List<Newssource> newssources = newssourceRepository.findAllNewssourceByNewssourceCreatedBy("Jhon123");
        assertThat(newssources.size(), is(2));


    }

}
