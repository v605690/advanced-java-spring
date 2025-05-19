package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(CustomConfig.class)
public class SecondImportConfig {
    @Bean
    public CustomConfig customConfig() {
        return new CustomConfig();
    }
}
