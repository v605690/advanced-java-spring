/* CodingNomads (C)2024 */
package com.codingnomads.ioc.examples.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;
    private HardDrive hardDrive;
    private Memory memory;

    @Autowired
    private Adapter adapter;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place

    public Laptop(Processor processor, OS os, HardDrive hardDrive, Adapter adapter) {
        this.processor = processor;
        this.os = os;
        this.hardDrive = hardDrive;
        this.adapter = adapter;
    }

    @Autowired
    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() + "\nMemory: " + memory.getSize() + " GB" + "\nHardDrive: " + hardDrive.getName() + "\nAccessory: " + adapter.getName() + "\nOS: " + os.getName();
    }
}
