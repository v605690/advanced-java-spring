package com.codingnomads.springdata.example.dml.introducingrepositories.practice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepo extends JpaRepository<User, Long> {

    public User findByFirstName(String name);
    public User findByFirstNameAndLastName(String firstName, String lastName);

    public ArrayList<User> findByAgeGreaterThan(int age);

}
