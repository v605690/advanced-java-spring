/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportAnnotationConfig.class);
        ctx.refresh();
        final SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        final Framework framework = ctx.getBean(Framework.class);
        ctx.close();

        AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext();
        ctx2.register(CustomConfig.class);
        ctx2.refresh();
        final CustomConfig customConfig = ctx2.getBean(CustomConfig.class);
        ctx.close();
    }
}
