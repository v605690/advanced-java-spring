/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.GET.getForEntity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetForEntityDemo {

    private static final String URL = "https://today.zenquotes.io?api&month={month}&day={day}";

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);

    }

    @Bean
    public CommandLineRunner run() throws Exception {

    Map<String, String> map = new HashMap<>();
    map.put("month", "6");
    map.put("day", "21");

        return args -> {
            ResponseEntity<RandomQuote> responseEntity =
                    restTemplate.getForEntity(URL, RandomQuote.class, map);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                //RandomQuote quote = responseEntity.getBody();
                //System.out.println(Arrays.toString(quote));
                String response = restTemplate.getForEntity(URL, String.class, map).toString();
                System.out.println(response);
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }
}
