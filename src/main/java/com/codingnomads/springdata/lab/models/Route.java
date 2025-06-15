/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "routes")
@ToString
public class Route implements Serializable {

    private static final long serialVersionUID = -2624055642258734917L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "origin_area_id", nullable = false, foreignKey = @ForeignKey(name = "fk_routes_origin_area_id"))
    private Area origin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "destination_area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_routes_destination_area_id"))
    private Area destination;

    @ManyToMany(mappedBy = "routes")
    private List<Waypoint> waypoints;

    public String generateCode() {
        return origin.getCode() + "-" + destination.getCode();
    }

@Builder
    public Route(Area origin, Area destination) {
        this.origin = origin;
        this.destination = destination;
        this.code = generateCode();
    }

    public void addWaypoint(Waypoint waypoint) {
        if (this.waypoints == null) {
            this.waypoints = new ArrayList<>(Collections.singletonList(waypoint));
        } else  {
            this.waypoints.add(waypoint);
        }
    }
}
