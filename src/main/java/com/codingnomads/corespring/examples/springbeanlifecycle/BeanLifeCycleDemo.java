/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanLifeCycleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanLifeCycleConfig.class);
        ctx.refresh();
        final SpringBean springBean = ctx.getBean(SpringBean.class);
        //final SpringBean springBean2 = ctx.getBean(SpringBean.class);
        final MyCustomSpringBean myCustomSpringBean = ctx.getBean(MyCustomSpringBean.class);
        ctx.close();
    }
}
