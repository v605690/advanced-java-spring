package com.codingnomads.springdata.example.ddl.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String birthDate;

    //@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String role;

    // Employee owner of OneToOne relationship
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    // Many Employees can work in one department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Many lists of objects or missions
    // From the owner side create join the table
    @ManyToMany
    @JoinTable(name = "employee_mission", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "mission_id"))
    private List<Mission> missions;

}
