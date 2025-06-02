/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.springdatajdbc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS departments (department_id BIGINT AUTO_INCREMENT PRIMARY KEY,"
                            + "department_name VARCHAR(255) NOT NULL);");

            // create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY,"
                    + "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");
        } catch (Exception e) {
            // nothing
        }

        List<String> departNames = Stream.of("marketing", "finance", "human resources", "IT", "sales", "engineering")
                .collect(Collectors.toList());

        for (String name : departNames) {
            jdbcTemplate.execute(
                    String.format("INSERT INTO departments(department_name) VALUES ('%s')", name));
        }

        jdbcTemplate.query("SELECT department_id, department_name FROM departments", (rs, rowNum) -> new Department(rs.getLong("department_id"), rs.getString("department_name")))
        .forEach(department -> System.out.println(department.toString()));

        jdbcTemplate.execute("TRUNCATE TABLE departments;");
        jdbcTemplate.execute("DROP TABLE departments");

        // create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(
                    String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        // query the database for Employees with first name Java
        jdbcTemplate
                .query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) ->
                                new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
                // idStatus each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));

        // truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        // delete the table
        jdbcTemplate.execute("DROP TABLE employees");
    }
}
