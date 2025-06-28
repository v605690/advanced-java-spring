package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamStat {
    private long id;
    private int firstDowns;
    private int rushingYards;
    private int sacks;
    private int fieldGoals;
    private int touchDowns;

    public TeamStat() {

    }

    public TeamStat(long id, int firstDowns, int rushingYards, int sacks, int fieldGoals, int touchDowns) {
        this.id = id;
        this.firstDowns = firstDowns;
        this.rushingYards = rushingYards;
        this.sacks = sacks;
        this.fieldGoals = fieldGoals;
        this.touchDowns = touchDowns;
    }
}

