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
    private Double latitude;
    private Double longitude;

    @ManyToMany
    @JoinTable(
            name = "coords_route",
            joinColumns = @JoinColumn(name = "coords_id"))
    private List<Route> routes;

    public Waypoint(String name, Double longitude, Double latitude, Route route) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.routes = List.of(route);
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
