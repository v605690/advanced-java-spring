/* CodingNomads (C)2024 */
package com.codingnomads.springtest.lab.controller;

import com.codingnomads.springtest.lab.entity.Movie;
import com.codingnomads.springtest.lab.service.MovieService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{name}")
    public String getMovie(@PathVariable(name = "name") String name) {
        return name;
    }

    @GetMapping("/rating")
    public List<Movie> getMoviesByMinimumRating(@RequestParam("min") Double minRating) {
        return movieService.getMoviesByMinimumRating(minRating);
    }

    @GetMapping("/ratings-only")
    public List<Double> getRatingsByMinimumRating(@RequestParam("min") Double minRating) {
        return movieService.getRatingsByMinimumRating(minRating);
    }
}
