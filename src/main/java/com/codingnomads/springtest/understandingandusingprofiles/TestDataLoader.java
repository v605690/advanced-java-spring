/* CodingNomads (C)2024 */
package com.codingnomads.springtest.understandingandusingprofiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class TestDataLoader implements CommandLineRunner {

    @Autowired
    CoffeePreferenceRepo repo;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @Profile("test2")
    public String coffee() {
        System.out.println("Americano now created");
        System.out.println("Espresso now created");
        return "Coffee beans initialized";
    }

    @Override
    public void run(String... args) throws Exception {

        repo.save(CoffeePreference.builder()
                .type("Americano")
                .iced(true)
                .size(CoffeePreference.Size.LARGE)
                .intensity(7)
                .sugar(false)
                .build());

        repo.save(CoffeePreference.builder()
                .type("Espresso")
                .iced(false)
                .size(CoffeePreference.Size.SMALL)
                .intensity(4)
                .sugar(true)
                .build());

        try {
            String coffeeBean = applicationContext.getBean("coffee", String.class);
            System.out.println("Coffee status: " + coffeeBean);
        } catch (Exception e) {
            System.out.println("Coffee not available (profile not active)");
        }
    }
}
