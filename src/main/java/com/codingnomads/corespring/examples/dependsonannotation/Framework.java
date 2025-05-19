package com.codingnomads.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Framework {
    @Autowired
    private JDK jdk;
    public Framework() {
        System.out.println("Framework is ready.");
    }
}
