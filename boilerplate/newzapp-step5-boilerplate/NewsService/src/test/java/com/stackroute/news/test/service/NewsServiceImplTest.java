package com.stackroute.news.test.service;


import com.stackroute.news.util.exception.NewsNotFoundExeption;
import com.stackroute.news.model.Newssource;
import com.stackroute.news.model.News;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.model.Reminder;
import com.stackroute.news.repository.NewsRepository;
import com.stackroute.news.service.NewsServiceImpl;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class NewsServiceImplTest {


    private News news;
    private UserNews userNews;
    private Newssource newssource;
    private Reminder reminder;
    @Mock
    private NewsRepository newsRepository;
    @InjectMocks
    private NewsServiceImpl newsServiceImpl;
    private List<News> newsList = null;
    Optional<UserNews> options;


    @BeforeEach
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        newssource = new Newssource();
        
        newssource.setNewssourceId("1");
        newssource.setNewssourceName("Cricket-Category");
        newssource.setNewssourceDesc("All about IPL");
        newssource.setNewssourceCreatedBy("Becky123");
        newssource.setNewssourceCreationDate();
        
        reminder = new Reminder();
        reminder.setReminderId("5b0509731764e3096984eae6");
        reminder.setSchedule();

        news = new News();
        news.setNewsId(1);
        news.setTitle("IPLT20 Match - 01");
        news.setAuthor("Becky123");
        news.setDescription("Ipl match 01 - CSK Vs RCB");
        news.setPublishedAt();
        news.setContent("CSK vs RCB match scheduled for 4 PM");
        news.setUrl("//CSKVsRCB.html");
        news.setUrlToImage("//CSKVsRCB.png");
        news.setReminder(reminder);
        news.setNewssource(newssource);

        newsList = new ArrayList<>();
        newsList.add(news);

        userNews = new UserNews();

        userNews.setUserId("Becky123");
        userNews.setNewslist(newsList);

        options = Optional.of(userNews);
        
    }


    @Test
    public void addNewsSuccess() {
        when(newsRepository.insert((UserNews) any())).thenReturn(userNews);
        boolean status = newsServiceImpl.addNews(news);
        assertEquals(true, status);
    }

    @Test
    public void addNewsFailure() {

        when(newsRepository.insert(userNews)).thenReturn(null);
        boolean status = newsServiceImpl.addNews(news);
        assertEquals(false, status);
     }


    @Test
    public void deleteNewsSuccess() {
        when(newsRepository.findById(userNews.getUserId())).thenReturn(options);
        when(newsRepository.save(userNews)).thenReturn(userNews);
        boolean flag = newsServiceImpl.deleteNews("Becky123", news.getNewsId());
        assertEquals(true, flag);
    }

    @Test
    public void deleteNewsFailure() {
        when(newsRepository.findById(userNews.getUserId())).thenReturn(null);
        when(newsRepository.save(userNews)).thenReturn(userNews);
        
        assertThrows(
        		NullPointerException.class,
                    () -> { newsServiceImpl.deleteNews("Becky123", news.getNewsId()); });
    
    }


    @Test
    public void deleteAllNewsSuccess() throws NewsNotFoundExeption {

        when(newsRepository.findById("Becky123")).thenReturn(options);
        when(newsRepository.save(userNews)).thenReturn(userNews);
        boolean flag = newsServiceImpl.deleteAllNews("Becky123");
        assertEquals(true, flag);

    }

    

    @Test
    public void deleteAllNewsFailure() throws NewsNotFoundExeption {
        when(newsRepository.findById("Becky123")).thenThrow(NoSuchElementException.class);
        
        assertThrows(
        		NewsNotFoundExeption.class,
                    () -> { newsServiceImpl.deleteAllNews("Becky123"); });
       
    }

    @Test
    public void updateNewsSuccess() throws NewsNotFoundExeption {

        when(newsRepository.findById("Becky123")).thenReturn(options);
        news.setContent("Match cancelled");
        newsList.add(news);
        News fetchedNews = newsServiceImpl.updateNews(news, news.getNewsId(), news.getAuthor());
        assertEquals(news, fetchedNews);


    }

    @Test
    public void updateNewsFailure() throws NewsNotFoundExeption {

        when(newsRepository.findById("Becky123")).thenThrow(NoSuchElementException.class);
        news.setContent("Match cancelled");
        newsList.add(news);
        
        assertThrows(
        		NewsNotFoundExeption.class,
                    () -> { newsServiceImpl.updateNews(news, news.getNewsId(), news.getAuthor()); });

    }

    @Test
    public void getNewsByNewsIdSuccess() throws NewsNotFoundExeption {
        when(newsRepository.findById("Becky123")).thenReturn(options);
        News fetechedNews = newsServiceImpl.getNewsByNewsId("Becky123", news.getNewsId());
        assertEquals(news, fetechedNews);
    }

    @Test
    public void getNewsByNewsIdFailure() throws NewsNotFoundExeption {
        when(newsRepository.findById("Becky123")).thenThrow(NoSuchElementException.class);
        
        assertThrows(
        		NewsNotFoundExeption.class,
                    () -> { newsServiceImpl.getNewsByNewsId("Becky123", news.getNewsId()); });
       
    }

    @Test
    public void getAllNewsByUserId() {
        when(newsRepository.findById("Becky123")).thenReturn(options);
        List<News> newslist1 = newsServiceImpl.getAllNewsByUserId("Becky123");
        assertEquals(newsList, newslist1);
    }
}