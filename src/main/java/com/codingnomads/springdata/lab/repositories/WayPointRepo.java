package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WayPointRepo extends JpaRepository<Waypoint,Long> {

    List<Waypoint> findByLatAndLon(Double lat, Double lon);
    List<Waypoint> findByName(String name);

}