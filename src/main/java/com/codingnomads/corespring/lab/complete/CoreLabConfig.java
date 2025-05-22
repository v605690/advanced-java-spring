/* CodingNomads (C)2024 */
package com.codingnomads.corespring.lab.complete;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ImportResource({"classpath*:xml-config/records.xml"})
public class CoreLabConfig {

    @Bean
    @Profile("apple")
    public Turntable turntable() {
        return new Turntable("Technics", "SL-1210M5G");
    }

    @Bean
    @Profile("PC")
    public Turntable turntable2() {
        return new Turntable("Sony", "SL-1210M5G");
    }
}
