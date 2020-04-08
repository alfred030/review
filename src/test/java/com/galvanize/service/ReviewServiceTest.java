package com.galvanize.service;

import com.galvanize.entity.Review;
import com.galvanize.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceTest {

    @MockBean
    ReviewRepository reviewRepository;

    @Autowired
    ReviewService reviewService;

    @Test
    public void postReview(){
        Review review = new Review("xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone", 4, "hello");
        Review expected = new Review(1L, "xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone", 4, "hello");
        when(reviewRepository.save(any(Review.class))).thenReturn(expected);
        assertEquals(expected, reviewService.postReview(review));
    }

    @Test
    public void getAllReviews(){
        Review expected = new Review(1L, "xyz@xyz.com", "tt0241527", "Harry Potter and the Sorcerer's Stone", 4, "hello");
        ArrayList<Review> expectedReviews = new ArrayList<>();
        String url = "imdb.com";
        ArrayList<Object>
        expectedReviews.add(expected);
        when(reviewRepository.findAll()).thenReturn(expectedReviews);
        assertEquals(expectedReviews, reviewService.getAllReviews());
    }
}
