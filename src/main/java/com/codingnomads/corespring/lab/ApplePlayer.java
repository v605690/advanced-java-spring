package com.codingnomads.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

@Getter
@Setter
@AllArgsConstructor
@Profile("apple")
public class ApplePlayer {

    private String player;
    private String sound;
    private String videos;
    private String playList;
    private Boolean isAppleIntegrated;
}
