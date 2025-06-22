/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForEntity;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import java.util.Objects;

import com.codingnomads.springweb.resttemplate.POST.models.User;
import com.codingnomads.springweb.resttemplate.POST.models.UserResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForEntityMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForEntityMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForEntity()")
                    .description("get comfortable using the RestTemplate postForEntity() method")
                    // be sure to use valid user id
                    .userId(13100)
                    .completed(false)
                    .build();

            ResponseEntity<ResponseObject> responseEntity = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            User user1 = User.builder()
                    .email("marialong@gmail.com")
                    .firstName("Maria")
                    .lastName("Long")
                    .build();

            User user2 = User.builder()
                    .email("jonpaul@gmail.com")
                    .firstName("Jon")
                    .lastName("Paul")
                    .build();

            ResponseEntity<UserResponseObject> responseEntity2 = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/users", user1, UserResponseObject.class);

            ResponseEntity<UserResponseObject> responseEntity3 = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/users", user2, UserResponseObject.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));

            } else if (responseEntity2.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity2.getBody()));

            } else if (responseEntity3.getStatusCode().equals(HttpStatus.CREATED)) {
                        System.out.println(Objects.requireNonNull(responseEntity3.getBody()));

                    } else {
                        System.out.println(
                                Objects.requireNonNull(responseEntity.getBody()).getError());
            }
        };
    }
}
