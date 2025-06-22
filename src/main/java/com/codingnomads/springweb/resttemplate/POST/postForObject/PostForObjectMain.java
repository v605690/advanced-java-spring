/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForObject;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import com.codingnomads.springweb.resttemplate.POST.models.User;
import com.codingnomads.springweb.resttemplate.POST.models.UserResponseObject;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForObject() - video demo")
                    .description("get comfortable using the RestTemplate postForObject() method")
                    // use a valid user id
                    .userId(13100)
                    .completed(false)
                    .build();

            ResponseObject taskReturnedByServerAfterPost = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            if (taskReturnedByServerAfterPost != null) {
                System.out.println(taskReturnedByServerAfterPost.toString());
            }

            User user = User.builder()
                    .email("johnsmith@gmail.com")
                    .firstName("John")
                    .lastName("Smith")
                    .build();

            UserResponseObject userReturnedByServerAfterPost = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users", user, UserResponseObject.class);

            if (userReturnedByServerAfterPost != null) {
                System.out.println(userReturnedByServerAfterPost.toString());
            }

        };
    }
}
