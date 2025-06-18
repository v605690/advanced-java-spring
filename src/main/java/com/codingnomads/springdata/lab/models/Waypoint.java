package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coordinates")
@Builder
@ToString
public class Waypoint implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double lat;
    private Double lon;

    @ManyToMany
    @JoinTable(
            name = "coords_route",
            joinColumns = @JoinColumn(name = "coords_id"))
    private List<Route> routes;

    public Waypoint(String name, Double lat, Double lon, List<Route> routes) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.routes = routes;
    }

    public void addRoutes(List<Route> routes) {
        if (routes != null) {
            routes.forEach(r -> r.addWaypoint(this));
        } else {
            this.routes = new  ArrayList<>();
        }
        if (this.routes == null) {
            this.routes = routes;
        } else {
            assert routes != null;
            routes.addAll(this.routes);
        }
    }
}
