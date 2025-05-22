/* CodingNomads (C)2024 */
package com.codingnomads.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class CLA {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(PlayerConfig.class);

        ApplePlayer applePlayer = ctx.getBean(ApplePlayer.class);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("I am playing from my favorite " + applePlayer.getPlayer() + " "+ applePlayer.getPlayList());
        System.out.println("-----------------------------------------------------------------");
        String[] playLists = ctx.getBeanNamesForType(PlayerList.class);

        for (String playList : playLists) {
            System.out.printf("%s - %s.%n", ctx.getBean(playList, PlayerList.class).getGroup(), ctx.getBean(playList, PlayerList.class).getSong());
        }
    }
}
