/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.configurationannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationDemo {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(ConfigurationDemoConfig.class);
        isBeanPresent("sampleClass", "anotherSampleClass", "configurationDemoConfig");
    }

    private static void isBeanPresent(String... beans) {
        for (String beanName : beans) {
            System.out.println(
                    "Is " + beanName + " in ApplicationContext: " + applicationContext.containsBean(beanName));
        }
    }
}
