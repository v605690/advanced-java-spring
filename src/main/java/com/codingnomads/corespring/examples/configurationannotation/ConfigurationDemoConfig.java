/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.configurationannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ConfigurationDemoConfig {

    @Bean
    public SampleClass sampleClass() {
        return new SampleClass();
    }

    @Bean
    public AnotherSampleClass anotherSampleClass() {
        return new AnotherSampleClass();
    }
}
