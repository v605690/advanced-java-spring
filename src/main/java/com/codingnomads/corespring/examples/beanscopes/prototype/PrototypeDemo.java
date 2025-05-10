/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanscopes.prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(PrototypeDemoConfig.class);
        ctx.refresh();

        SpringBean springBean1 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean1.hashCode());

        SpringBean springBean2 = ctx.getBean(SpringBean.class);
        System.out.println("Hash code: " + springBean2.hashCode());

        SpringBeanTwo sb1 = ctx.getBean(SpringBeanTwo.class);
        System.out.println("Hash code: " + sb1.hashCode());

        SpringBeanTwo sb2 = ctx.getBean(SpringBeanTwo.class);
        System.out.println("Hash code: " + sb2.hashCode());

        ctx.close();
    }
}
