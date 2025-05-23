package com.codingnomads.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Department {
    private long departmentId;
    private String departmentName;

    public Department(long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }
}
