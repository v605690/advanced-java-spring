package com.codingnomads.springdata.example.ddl.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Mission {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int duration;

    // Many missions to a list of objects or employees
    // Identity the owner which is employee
    // Add mappedBy to mission
    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;
}
