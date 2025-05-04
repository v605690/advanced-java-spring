/* CodingNomads (C)2024 */
package com.codingnomads.ioc.examples.constructorinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codingnomads.ioc.examples.constructorinjection")
public class LaptopConfiguration {

    @Bean
    public Processor processor() {
        return new Processor(8, "i9");
    }

    @Bean
    public OS os() {
        return new OS("ubuntu");
    }

    @Bean
    public HardDrive hardDrive() {
        return new HardDrive("seagate");
    }

    @Bean
    public Memory Memory() {
        return new Memory(128);
    }
}
