/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.valueannotation;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Nomad {

    private String name;

    private Integer age;

    public Nomad(@Value("${nomad.name}") String name, @Value("${nomad.age}") Integer age) {
        this.name = name;
        this.age = age;
    }

    @Value("Hello!!")
    private String greeting;

    @Value("${nomad.framework}")
    private String framework;

    @Value("${nomad.jdk}")
    private String jdk;

    @Value("${nomad.ide:IntelliJ IDEA}")
    private String ide;

    @Value("${nomad.workingDays}")
    private List<String> workingDays;

    @Value("#{${database.values}}")
    private Map<String, String> databaseValues;

    @Value("${bear.version}")
    private String bearVersion;

    @Value("${bear.name}")
    private String bearName;

    @Value("${bear.date}")
    private String bearDate;

    @Value("${docker.version}")
    private String dockerVersion;

    @Value("${docker.name}")
    private String dockerName;

    @Value("${docker.engine}")
    private String dockerEngine;

    public String nomadIdentity() {
        return name.concat(" ").concat(age.toString());
    }

    public String getGreeting() {
        return greeting;
    }

    public String output() {
        return "Spring Developer is building awesome software using: "
                .concat(jdk)
                .concat(" , ")
                .concat(framework)
                .concat(" and ")
                .concat(ide)
                .concat(bearVersion)
                .concat("\nNote Name & Version - ")
                .concat(bearName)
                .concat(bearDate)
                .concat(dockerVersion)
                .concat("\nContainer Name & Version - ")
                .concat(dockerName)
                .concat(dockerEngine);
    }

    public List<String> getWorkingDays() {
        return workingDays;
    }

    public Map<String, String> getDatabaseValues() {
        return databaseValues;
    }
}
