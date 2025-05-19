package com.codingnomads.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class Framework {
    public Framework() {
        System.out.println("Framework deployed.");
    }
}
