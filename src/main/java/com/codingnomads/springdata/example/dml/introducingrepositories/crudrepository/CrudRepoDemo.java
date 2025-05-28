/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.introducingrepositories.crudrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CrudRepoDemo implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudRepoDemo.class);
    }

    // autowire the UserRepo into the class to gain access to the CRUD methods
    @Autowired
    UserRepo userRepo;

    @Override
    public void run(String... args) throws Exception {
        // create new user
        User user =
                User.builder().firstName("Bobby").lastName("Bobbert").age(56).build();
        User user2 =
                User.builder().firstName("Joanne").lastName("Joanna").age(36).build();
        User user3 =
                User.builder().firstName("David").lastName("Lane").age(33).build();
        User user4 =
                User.builder().firstName("Chris").lastName("Mills").age(25).build();
        User user5 =
                User.builder().firstName("Jason").lastName("Loup").age(44).build();
        User user6 =
                User.builder().firstName("Toby").lastName("Long").age(28).build();
        User user7 =
                User.builder().firstName("John").lastName("Short").age(38).build();

        List<User> users = List.of(user, user2, user3, user4, user5, user6, user7);

        Iterable<User> savedUsers = userRepo.saveAll(users);

        //System.out.println(savedUsers.toString());

        // save user and assign what is returned to the user variable.
//        user = userRepo.save(user);
//        user2 = userRepo.save(user2);

        Iterable<User> listOfUsers = userRepo.findAll();

        for (User u : listOfUsers) {
            System.out.println(u.toString());
        }
        // delete the user using the id of the inserted user object
        userRepo.deleteById(user.getId());
        userRepo.deleteById(user2.getId());
    }
}
