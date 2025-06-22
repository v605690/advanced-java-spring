/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.POST.postForLocation;

import com.codingnomads.springweb.resttemplate.POST.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.POST.models.Task;
import java.net.URI;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForLocation()")
                    .description("get comfortable using the RestTemplate postForLocation() method")
                    // be sure to use a valid user id
                    .userId(13100)
                    .completed(false)
                    .build();

            URI returnedLocation = restTemplate.postForLocation(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(responseEntity.getHeaders().get("Location"));

           Task task2 = Task.builder()
                    .name("New Task")
                    .description("new task")
                    .userId(13099)
                    .completed(false)
                   .build();

           URI returnedLocation2 = restTemplate.postForLocation(
                   "http://demo.codingnomads.co:8080/tasks_api/tasks", task2, ResponseObject.class);
           System.out.println(Objects.requireNonNull(returnedLocation2));

           ResponseEntity<?> responseEntity2 = restTemplate.postForEntity(
                   "http://demo.codingnomads.co:8080/tasks_api/tasks", task2, ResponseObject.class);

            System.out.println(responseEntity2.getHeaders().get("Location"));


           Task task3 = Task.builder()
                    .name("New Task2")
                    .description("new task2")
                    .userId(13098)
                    .completed(true)
                   .build();

            URI returnedLocation3 = restTemplate.postForLocation(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", task3, ResponseObject.class);
            System.out.println(Objects.requireNonNull(returnedLocation3));

            ResponseEntity<?> responseEntity3 = restTemplate.postForEntity(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks", task3, ResponseObject.class);
            System.out.println(responseEntity3.getHeaders().get("Location"));

            // use postForLocation() to get the URL for the new resource
        };
    }
}
