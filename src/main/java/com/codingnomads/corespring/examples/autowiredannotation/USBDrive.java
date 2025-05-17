package com.codingnomads.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class USBDrive implements dongle {}
