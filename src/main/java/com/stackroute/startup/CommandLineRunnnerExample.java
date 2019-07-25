package com.stackroute.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnnerExample implements CommandLineRunner {
    //When you want to execute some piece of code exactly before the application startup completes
    //we can use command line runnner interface and override the methods
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnnerExample.class);
    public void run(String... args) {
        String strArgs = Arrays.stream(args).collect(Collectors.joining("|"));
        logger.info("Application started with arguments:" + strArgs);
    }
}
