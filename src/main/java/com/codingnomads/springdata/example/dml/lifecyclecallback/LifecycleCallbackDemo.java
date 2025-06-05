/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LifecycleCallbackDemo {

    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here
            PrintEntity printEn = new PrintEntity();
            printEn.setId(2L);
            printEntityRepository.save(printEn);

            printEntityRepository.findAll();

            printEntityRepository.findById(Long.valueOf(1L));

            List<Long> ids = List.of(1L, 2L, 3L);
            for (PrintEntity printEntity : printEntityRepository.findAllById(ids)) {
                System.out.println(printEntity);
                System.out.println("***********");
            }


        };
    }
}