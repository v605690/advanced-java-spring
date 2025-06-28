/* CodingNomads (C)2024 */
package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";

    }
    @RequestMapping(path = "/nfl", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting2()  {
        return "The NFL League" + "!";
    }

    @RequestMapping(path = "/nfl/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting3(@PathVariable(name = "name") String name) {
        return "The " + name + "!";
    }

    @RequestMapping("/team-stat/{id}")
    public TeamStat getTeamStat(@PathVariable(name = "id") int id) {
        if (id == 1) {
            return new TeamStat.TeamStatBuilder()
                    .id(1)
                    .firstDowns(307)
                    .rushingYards(1705)
                    .sacks(38)
                    .fieldGoals(40)
                    .touchDowns(33)
                    .build();
        }
        return new TeamStat.TeamStatBuilder().id(id).build();
    }


    @RequestMapping(path = "/team-roaster", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getNFLTeams() {
        List<NFLTeam> teams = new ArrayList<>();
        teams.add(new NFLTeam(1, "Texans"));
        teams.add(new NFLTeam(2, "Baltimore Ravens"));
        teams.add(new NFLTeam(3, "Buffalo Bills"));
        teams.add(new NFLTeam(4, "Cincinnati Bengals"));
        teams.add(new NFLTeam(5, "Cleveland Browns"));
        teams.add(new NFLTeam(6, "Denver Broncos"));
        teams.add(new NFLTeam(7, "Indianapolis Colts"));
        teams.add(new NFLTeam(8, "Jacksonville Jaguars"));
        teams.add(new NFLTeam(9, "Kansas City Chiefs"));
        teams.add(new NFLTeam(10, "Las Vegas Raiders"));

        return teams.stream()
                .map(NFLTeam::toString)
                .collect(Collectors.joining("\n"));
    }
}
