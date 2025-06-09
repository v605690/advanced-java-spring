package com.codingnomads.springdata.example.dml.introducingrepositories.cruddemo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Pope {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Pontiff Number")
    private int pontiffNumber;
    @Column(name = "Pope Name")
    private String popeName;
    @Column(name = "Pontificate")
    private String pontificate = "yyyy-MM-dd";

}
