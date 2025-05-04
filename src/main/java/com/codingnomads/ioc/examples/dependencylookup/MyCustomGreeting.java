package com.codingnomads.ioc.examples.dependencylookup;

public class MyCustomGreeting implements GreetingProvider {
    @Override
    public String getGreeting() {
        return "Hello MyCustomGreeting!";
    }
}
