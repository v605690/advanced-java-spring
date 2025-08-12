package com.codingnomads.springtest.lab;

import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
class MovieServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private MovieService movieService;

    @Test
    void getAllMovies() {
       List<Movie> movies = movieService.getAllMovies();
        assertThat(movies).isNotEmpty();
        assertThat(movies).hasSize(2);
    }

    @Test
    void getMoviesByMinimumRating() {
        List<Movie> movies = movieService.getMoviesByMinimumRating(8.0);
        assertThat(movies).isNotNull();
    }

    @Test
    void getRatingsByMinimumRating() {
        List<Double> movies = movieService.getRatingsByMinimumRating(9.3);
        assertThat(movies).isNotEmpty();
    }
}