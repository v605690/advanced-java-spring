/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.PATCH;

import com.codingnomads.springweb.resttemplate.PATCH.models.NwUser;
import com.codingnomads.springweb.resttemplate.PATCH.models.ResponseObject;
import com.codingnomads.springweb.resttemplate.PATCH.models.Task;
import java.util.Objects;

import com.codingnomads.springweb.resttemplate.PATCH.models.UsrResObj;
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
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            // create an empty Task
            Task task = new Task();

            NwUser user = new NwUser();

            user.setId(13160);
            user.setId(13159);

            user.setFirstName("Pravin");
            user.setLastName("Patel");

            user.setFirstName("Larry");
            user.setLastName("Davis");

            // be sure to use a valid task id
            task.setId(12529);

            // set fields you want to change. All other fields are null and will not be updated
            task.setName("use patchForObject()");
            task.setDescription("this task was updated using patchForObject()");

            // send the PATCH request using the URL, the Task created above and the ResponseObject Class
            ResponseObject objectResponse = restTemplate.patchForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), task, ResponseObject.class);

            UsrResObj usrResObj = restTemplate.patchForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + user.getId(), task, UsrResObj.class);

            System.out.println(Objects.requireNonNull(objectResponse));
            System.out.println(Objects.requireNonNull(usrResObj));

            task.setName("PATCH using exchange()");
            task.setDescription("This task was updated using PATCH");

            HttpEntity<Task> httpEntity = new HttpEntity<>(task);
            ResponseEntity<ResponseObject> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(),
                    HttpMethod.PATCH,
                    httpEntity,
                    ResponseObject.class);

            System.out.println(Objects.requireNonNull(response));

            user.setFirstName("Tony");
            user.setLastName("Miller");

            user.setFirstName("Summer");
            user.setLastName("Davis");

            HttpEntity<NwUser> httpEntity2 = new HttpEntity<>(user);
            ResponseEntity<UsrResObj> response2 = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(),
                    HttpMethod.PATCH,
                    httpEntity2,
                    UsrResObj.class);
            System.out.println(Objects.requireNonNull(response2));
        };
    }
}
