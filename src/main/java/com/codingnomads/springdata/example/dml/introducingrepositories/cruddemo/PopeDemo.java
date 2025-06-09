package com.codingnomads.springdata.example.dml.introducingrepositories.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class PopeDemo {
    public static void main(String[] args) {
        SpringApplication.run(PopeDemo.class);
    }

    @Bean
    public CommandLineRunner run(PopeRepo popeRepo) {
        return (args) -> {

            Pope pope123 = Pope.builder()
                .pontiffNumber(123)
                .popeName("Leo VI Leo Sextus")
                .pontificate("28 May\n" +
                        "928 –\n" +
                        "February 929")
                .build();

            Pope pope157 = Pope.builder()
                    .pontiffNumber(157)
                    .popeName("St Gregory VII GREGORIVS\n" +
                            "Septimus")
                    .pontificate("22 April\n" +
                            "1073 –\n" +
                            "25 May\n" +
                            "1085\n")
                    .build();

            Pope pope190 = Pope.builder()
                    .pontiffNumber(190)
                    .popeName("HonoriusIV\n" +
                            "HONORIVS\n" +
                            "Quartus")
                    .pontificate("2 April 1285 –\n" +
                            "3 April\n" +
                            "1287\n")
                    .build();

            Pope pope200 = Pope.builder()
                    .pontiffNumber(200)
                    .popeName("Bl. Urban V\n" +
                            "VRBANVS\n" +
                            "Quintus")
                    .pontificate("28\n" +
                            "September 1362 –\n" +
                            "19\n" +
                            "December")
                    .build();

            Pope pope240 = Pope.builder()
                    .pontiffNumber(240)
                    .popeName("Bl. Innocent XI INNOCENTIVS\n" +
                            "Undecimus")
                    .pontificate("21\n" +
                            "September 1676 –\n" +
                            "12 August\n" +
                            "1689")
                    .build();

            Pope pope267 = Pope.builder()
                    .pontiffNumber(267)
                    .popeName("Leo XIV LEO Quartus Decimus")
                    .pontificate("8 May 2025 – Present")
                    .build();

            popeRepo.save(pope123);
            popeRepo.save(pope157);
            popeRepo.save(pope190);
            popeRepo.save(pope200);
            popeRepo.save(pope240);
            popeRepo.save(pope267);

        };
    }
}
