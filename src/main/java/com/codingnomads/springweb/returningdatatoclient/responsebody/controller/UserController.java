/* CodingNomads (C)2024 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.controller;

import com.codingnomads.springweb.returningdatatoclient.responsebody.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

     List<User> userList;

    public UserController() {
        userList = new ArrayList<>();
    }


    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.com")
            .build();

    public User user2 = User.builder()
            .id(1002)
            .name("Java 101")
            .email("java101@codingnomads.com")
            .build();

    public User user3 = User.builder()
            .id(1003)
            .name("Java 201")
            .email("java201@codingnomads.com")
            .build();
    public User user4 = User.builder()
            .id(1004)
            .name("Java 301")
            .email("java301@codingnomads.com")
            .build();

    // using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    // using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user")
    public User user() {
        return user;
    }

    @ResponseBody
    @GetMapping("/user-list")
    public <userList> userList fetchUserList() {
       userList.add(user);
       userList.add(user2);
       userList.add(user3);
       userList.add(user4);

       return (userList) userList;
    }
}
