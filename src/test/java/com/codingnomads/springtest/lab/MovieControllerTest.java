/* CodingNomads (C)2024 */
package com.codingnomads.springtest.lab;

import java.util.List;

import com.codingnomads.springtest.TestUtil;
import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private MovieService movieService;


    @Test
    public void testGetAllMoviesSuccess() throws Exception {

        mockMvc.perform(get("/all"))

                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].rating").value(9.3))
                .andExpect(jsonPath("$[1].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("The Pursuit of Happyness"))
                .andExpect(jsonPath("$[1].rating").value(8.0));
    }

    @Test
    public void testGetAllMovieByNumberRating() throws Exception {
        mockMvc.perform(get("/ratings-only?min=8.0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0]").value(9.3))
                .andExpect(jsonPath("$[1]").value(8.0));
    }

    @Test
    public void testGetAllMovieByRating() throws Exception {
        mockMvc.perform(get("/rating?min=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].rating").value(9.3))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[1].rating").value(8.0))
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"));
    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        mockMvc.perform(get("/all/3"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        Movie mockMovie = new Movie();
        mockMovie.setId(1L);
        mockMovie.setName("The Shawshank Redemption");
        mockMovie.setRating(9.3);

        when(movieService.getAllMovies())
                .thenReturn(List.of(mockMovie));

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                .andExpect(jsonPath("$[0].rating").value(9.3));
    }

    @Test
    public void testGetAllMovieSuccessObjectMapper() throws Exception {
        byte[] responseContent = mockMvc.perform(get("/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn()
                .getResponse()
                .getContentAsByteArray();

        Movie[] movies = TestUtil.convertJsonBytesToObject(responseContent, Movie[].class);

        assertThat(movies).hasSize(2);
        assertThat(movies[0].getId()).isEqualTo(1);
        assertThat(movies[0].getName()).isEqualTo("The Shawshank Redemption");
        assertThat(movies[0].getRating()).isEqualTo(9.3);
        assertThat(movies[1].getId()).isEqualTo(2);
        assertThat(movies[1].getName()).isEqualTo("The Pursuit of Happyness");
        assertThat(movies[1].getRating()).isEqualTo(8.0);
    }
}