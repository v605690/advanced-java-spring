/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.commonproblems;

import com.codingnomads.springdata.example.dml.commonproblems.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonProblemsApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(CommonProblemsApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.idError();
        userService.persistAFewUsers();
        userService.querySomeData();
    }
}
