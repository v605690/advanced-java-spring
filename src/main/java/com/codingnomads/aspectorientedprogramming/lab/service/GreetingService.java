/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.lab.service;

import com.codingnomads.aspectorientedprogramming.lab.aspect.Printable;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting() {
        return "Hello Spring Developer!";
    }

    @Printable
    public String greetByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return "Greetings, " + name + "!";
    }
}
