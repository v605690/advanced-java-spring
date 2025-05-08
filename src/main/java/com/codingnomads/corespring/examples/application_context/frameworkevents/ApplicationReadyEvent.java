package com.codingnomads.corespring.examples.application_context.frameworkevents;

import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEvent implements ApplicationListener<org.springframework.boot.context.event.ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(@NonNull org.springframework.boot.context.event.ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Application is ready!!");
    }
}
