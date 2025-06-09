package com.codingnomads.springdata.example.dml.introducingrepositories.cruddemo;

import org.springframework.data.repository.CrudRepository;

public interface PopeRepo extends CrudRepository<Pope, Long> {

}
