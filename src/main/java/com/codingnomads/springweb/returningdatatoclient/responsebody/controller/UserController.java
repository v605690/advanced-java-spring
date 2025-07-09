/* CodingNomads (C)2024 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.controller;

import com.codingnomads.springweb.returningdatatoclient.responsebody.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class UserController {

     List<User> userList;

    public UserController() {
        userList = new ArrayList<>();

        User user = User.builder()
                .id(1000)
                .name("Spring Dev")
                .email("dev@codingnomads.com")
                .build();

        User user2 = User.builder()
                .id(1002)
                .name("Java 101")
                .email("java101@codingnomads.com")
                .build();

        User user3 = User.builder()
                .id(1003)
                .name("Java 201")
                .email("java201@codingnomads.com")
                .build();
        User user4 = User.builder()
                .id(1004)
                .name("Java 301")
                .email("java301@codingnomads.com")
                .build();

        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

    }
    // using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return userList.get(0);
    }

    // using ResponseEntity to return POJO
    @GetMapping("/response-entity/{id}")
    public ResponseEntity<User> userResponseEntity(@PathVariable int id) {
        if (id < 0) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (id >= userList.size()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList.get(id), HttpStatus.OK);
    }

    // returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user/{id}")
    public User user(@PathVariable int id) {
        return userList.get(id);
    }

    @ResponseBody
    @GetMapping("/user-list")
    public List<User> fetchUserList() {

       return userList;
    }
}
