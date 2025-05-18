/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.scopeannotaion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ScopeAnnotationDemoConfig.class);
        ctx.refresh();
        SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);

        System.out.println("-----Hashcode of SingletonBean-----");
        System.out.println(singletonBean1.hashCode());
        System.out.println(singletonBean2.hashCode());

        final PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
        final PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);

        System.out.println("-----Hashcode of PrototypeBean-----");
        System.out.println(prototypeBean1.hashCode());
        System.out.println(prototypeBean2.hashCode());
        System.out.println();

        ScopeBeanOne scopeBeanOne = ctx.getBean(ScopeBeanOne.class);
        ScopeBeanOne scopeBeanTwo = ctx.getBean(ScopeBeanOne.class);

        System.out.println("-----Hashcode of ScopeBeanOne-----");
        System.out.println(scopeBeanOne.hashCode());
        System.out.println(scopeBeanTwo.hashCode());

        final ScopeBeanTwo scopeBeanThree = ctx.getBean(ScopeBeanTwo.class);
        final ScopeBeanTwo scopeBeanFour = ctx.getBean(ScopeBeanTwo.class);

        System.out.println("-----Hashcode of ScopeBeanTwo-----");
        System.out.println(scopeBeanThree.hashCode());
        System.out.println(scopeBeanFour.hashCode());

        ctx.close();
    }
}
