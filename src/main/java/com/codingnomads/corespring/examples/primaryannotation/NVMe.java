package com.codingnomads.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NVMe implements SSD{
    public NVMe() {
        System.out.println("NVMe SSD is ready.");
    }
}
