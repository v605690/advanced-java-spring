package com.codingnomads.springdata.example.dml.introducingrepositories.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PracticeDemo {
    public static void main(String[] args) {
        SpringApplication.run(PracticeDemo.class);
    }

    @Bean
    public CommandLineRunner doingStuff(UserRepo userRepo) {
        return (args) -> {

            User user = new User();
            User user2 = new User();
            User user3 = new User();

            user.firstName = "Larry";
            user.lastName = "Mullin";
            user.age = 23;
            user2.firstName = "John";
            user2.lastName = "Smith";
            user2.age = 33;

            user3.firstName = "Lisa";
            user3.lastName = "Moon";
            user3.age = 19;

            userRepo.save(user);
            userRepo.save(user2);
            userRepo.save(user3);

            User test = userRepo.findByFirstName("Larry");
            System.out.println(test.firstName);

            User test2 = userRepo.findByFirstNameAndLastName("Larry", "Mullin");

            System.out.println(test2.firstName + " " + test2.lastName);
            List<User> test4 = userRepo.findAll();

            for (User allUsers : test4) {
                System.out.println(allUsers.firstName);
            }

            ArrayList<User> test3 = userRepo.findByAgeGreaterThan(21);

            System.out.println("Users Greater Than 21");
            for (User u : test3) {
                System.out.println(u.firstName);
            }
        };
    }
}
