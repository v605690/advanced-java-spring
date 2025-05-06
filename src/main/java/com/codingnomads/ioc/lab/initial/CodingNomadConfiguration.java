package com.codingnomads.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codingnomads.ioc.lab.initial")
public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("3.2").build();
    }

    @Bean
    public IDE ide() {
        return IDE.builder().name("IntelliJ IDEA").version("2023.5").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("17").build();
    }

    @Bean
    public Laptop laptop() {
        return Laptop.builder().brand("Apple").model("M3 Macbook Air").build();
    }

    @Bean
    public MobileMonitor mobileMonitor() {
        return MobileMonitor.builder().brand("Tern Setups").model("4k OLED 16 inch Monitor").build();
    }
}
