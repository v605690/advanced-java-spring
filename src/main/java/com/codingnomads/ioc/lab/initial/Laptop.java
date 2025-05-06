package com.codingnomads.ioc.lab.initial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Laptop {
    private String brand;
    private String model;
}


