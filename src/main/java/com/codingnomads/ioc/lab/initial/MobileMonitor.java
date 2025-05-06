package com.codingnomads.ioc.lab.initial;


import lombok.AllArgsConstructor; // lombok annotation
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class MobileMonitor {
    private String brand;
    private String model;
    private String resolution;
}
