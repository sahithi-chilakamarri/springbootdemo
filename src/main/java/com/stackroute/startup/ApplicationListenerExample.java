package com.stackroute.startup;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ApplicationListenerExample implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * This method is called during Spring's startup.
     *
     * Event raised when an ApplicationContext gets initialized or
     * refreshed.
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Handling context re-freshed event. ");
    }
}
