/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.propertysourceannotation;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Getter
    @Value("${app.name}")
    private String appName;

    @Getter
    @Value("${app.version}")
    private String appVersion;

    @Getter
    @Value("${bear.version}")
    private String bearVersion;

    @Getter
    @Value("bear.name")
    private String bearName;

    @Value("${bear.date}")
    private String bearDate;

}
