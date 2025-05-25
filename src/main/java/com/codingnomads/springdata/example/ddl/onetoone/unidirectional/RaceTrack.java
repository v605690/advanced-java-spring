package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "racetrack")
@NoArgsConstructor
@Getter
@Setter
public class RaceTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;
    private String type;
    private String length;

    @OneToOne( mappedBy = "raceTrack")
    private Driver driver;
}
