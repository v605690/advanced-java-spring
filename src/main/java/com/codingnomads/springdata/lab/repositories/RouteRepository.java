package com.codingnomads.springdata.lab.repositories;

import com.codingnomads.springdata.lab.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route,Long> {

    List<Route> findByOrigin_code(String code);

    Route findByCode(String code);

    List<Route> findByCodeContaining(String code);
}
