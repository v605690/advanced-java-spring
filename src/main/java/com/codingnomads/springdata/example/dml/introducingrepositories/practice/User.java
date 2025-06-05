package com.codingnomads.springdata.example.dml.introducingrepositories.practice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    long id;

    String firstName;
    String lastName;
    int age;
}
