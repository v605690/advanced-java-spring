/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PUT;

import com.codingnomads.springweb.resttemplate.POST.models.User;
import com.codingnomads.springweb.resttemplate.PUT.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PUT.models.Task;
import com.codingnomads.springweb.resttemplate.PUT.models.UserResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // use a valid task id
           int taskId = 12485;

            // user email
            int userId = 13137;

            // request Task 5 from server
            ResponseObject responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);

            UserResponseObject userResponseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class);


            // confirm data was retrieved & avoid NullPointerExceptions
            Task userToUpdate;
            if (responseObject == null && userResponseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The task with ID " + taskId + " could not be found");
            } else {
                userToUpdate = responseObject.getData();

            }

            User updateUserInfo;
            if (userResponseObject == null) {
                throw new Exception("The server did not return anything. Not even a UserResponseObject!");
            } else if (userResponseObject.getData() == null) {
                throw new Exception("The user id " + userId + " could not be found");
            } else {
                updateUserInfo = userResponseObject.getData();
            }

            // update the task information
            userToUpdate.setName("updated using put() - video demo ");
            userToUpdate.setDescription("this task was updated using RestTemplate's put() method - video demo");
            userToUpdate.setCompleted(false);

            updateUserInfo.setEmail("timdavis@gmail.com");
            updateUserInfo.setFirstName("tim");
            updateUserInfo.setLastName("davis");

            // use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/tasks/" + userToUpdate.getId(), userToUpdate);

            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + updateUserInfo.getId(), updateUserInfo);
            // get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + taskId, ResponseObject.class);
            System.out.println(responseObject.toString());

            userResponseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userId, UserResponseObject.class);
            System.out.println(userResponseObject.toString());

           // userToUpdate.setName("updated using exchange() PUT - video demo 2");
           // userToUpdate.setDescription("this task was updated using RestTemplate's exchange() method - video demo 2");

            // create an HttpEntity wrapping the task to update
            HttpEntity<Task> httpEntity = new HttpEntity<>((userToUpdate));
            // use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<ResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + userToUpdate.getId(),
                    HttpMethod.PUT,
                    httpEntity,
                    ResponseObject.class);

            HttpEntity<User> httpEntity2 = new HttpEntity<>((updateUserInfo));
            ResponseEntity<ResponseObject> response2 = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + updateUserInfo.getId(),
                    HttpMethod.PUT,
                    httpEntity2,
                    ResponseObject.class);

            System.out.println(response.toString());
            System.out.println(response2.getStatusCode());
        };
    }
}
