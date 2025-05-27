package com.codingnomads.springdata.example.ddl.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    // One department to a list of objects or many employees
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
