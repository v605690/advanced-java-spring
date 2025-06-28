package com.codingnomads.springweb.springrestcontrollers.simpledemo.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NFLTeam {
    private long id;
    private String teamName;
}
