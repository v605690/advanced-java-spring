/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.scopeannotaion;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeAnnotationDemoConfig {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ScopeBeanOne scopeBeanOne() {
        return new ScopeBeanOne();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ScopeBeanTwo scopeBeanTwo() {
        return new ScopeBeanTwo();
    }
}
