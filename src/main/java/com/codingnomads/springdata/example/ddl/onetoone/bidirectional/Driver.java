/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.onetoone.bidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @OneToOne(
            // a car will only be retrieved from the database when it is explicitly accessed
            fetch = FetchType.LAZY,
            // you must specify a Car before you save the Driver
            optional = false,
            // All save/persist actions will be propagated through to the Car.
            cascade = CascadeType.PERSIST)
    private Car car;

    @OneToOne
    private RaceTrack raceTrack;
}
