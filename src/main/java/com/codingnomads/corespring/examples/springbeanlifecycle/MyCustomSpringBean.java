package com.codingnomads.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyCustomSpringBean implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Pravin's Custom Bean name provided, bean name set to: ".concat(name));
    }
}
