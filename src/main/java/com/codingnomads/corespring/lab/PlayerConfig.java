package com.codingnomads.corespring.lab;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;

@Configuration
@ImportResource({"classpath*:xml-config/player.xml"})
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PlayerConfig {
    @Bean
    public ApplePlayer applePlayer() {
        return new ApplePlayer("iTunes", "medium", "music video", "playlist", true);
    }
}
