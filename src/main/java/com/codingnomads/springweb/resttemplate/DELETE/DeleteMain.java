/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.DELETE;

import com.codingnomads.springweb.resttemplate.DELETE.models.MyUser;
import com.codingnomads.springweb.resttemplate.DELETE.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.DELETE.models.Task;
import com.codingnomads.springweb.resttemplate.DELETE.models.UsrResObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {

        return args -> {
            Task newTask = Task.builder()
                    .name("should be deleted")
                    .description("used in a delete RestTemplate example. If you see this something went wrong. Oops")
                    // be sure to enter a valid user id
                    .userId(13177)
                    .completed(false)
                    .build();

            MyUser newUser = MyUser.builder()
                    .id(13160)
                    .firstName("John")
                    .lastName("Doe")
                    .email("johndoe@gmail.com")
                    .build();


            // POST new task to server
            ResponseObject responseObject = restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/", newTask, ResponseObject.class);

            UsrResObj usrResObj= restTemplate.postForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/", newUser, UsrResObj.class);

            // confirm data was returned & avoid NullPointerExceptions
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:"
                        + responseObject.getError().getMessage());
            } else {
                newTask = responseObject.getData();

            }if (usrResObj == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (usrResObj.getData() == null) {
                throw new Exception("The server encountered this error while creating the task:"
                        + usrResObj.getError().getMessage());
            } else {
                newUser = usrResObj.getData();
            }

            System.out.println("The task was successfully created");
            System.out.println(newTask);

            System.out.println(newUser);

            // delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId());
            System.out.println("The task was also successfully deleted");

            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser.getId());
            System.out.println("The user was also successfully deleted");

            // try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/users/" + newUser.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            // delete using exchange()
            HttpEntity<Task> httpEntity = new HttpEntity<>(newTask);
            try {
                restTemplate.exchange(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newTask.getId(),
                        HttpMethod.DELETE,
                        httpEntity,
                        ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            HttpEntity<MyUser> httpEntity2 = new HttpEntity<>(newUser);
            try {
                restTemplate.exchange(
                        "http://demo.codingnomads.co:8080/tasks_api/users" + newUser.getId(),
                        HttpMethod.DELETE,
                        httpEntity2,
                        ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
