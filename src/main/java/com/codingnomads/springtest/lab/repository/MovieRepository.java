/* CodingNomads (C)2024 */
package com.codingnomads.springtest.lab.repository;

import com.codingnomads.springtest.lab.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.rating >= :minRating")
    List<Movie> findMoviesByRatingGreaterThanEqual(@Param("minRating") Double minRating);

    @Query("SELECT m.rating FROM Movie m WHERE m.rating >= :minRating")
    List<Double> findRatingsByRatingGreaterThanEqual(@Param("minRating") Double minRating);


}
