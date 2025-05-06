package com.codingnomads.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component // Spring annotation to indicate that this class is a Spring bean
@RequiredArgsConstructor // Lombok annotation to automatically generate constructors
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private final MobileMonitor mobileMonitor;

    // Field injection of the Laptop
    @Autowired // Spring annotation to indicate that this field is to be injected
    private final Laptop laptop;

    // Setter injection of the Mobile Monitor
    @Autowired // Spring annotation to indicate that this setter is to be injected
    public void setMobileMonitor() {
    }

    public String createAwesomeSoftware() {
        // MessageFormat is a utility class that formats strings using variables
        return MessageFormat.format (
                "This coding nomad is creating awesome software using, "
                        + "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}, Laptop: {6}:{7}, Mobile Monitor: {8}:{9})",
                (Object) ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion(),
                laptop.getBrand(),
                laptop.getModel(),
                mobileMonitor.getBrand(),
                mobileMonitor.getModel()
        );
    }
}
