package com.mti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FinalLegendApplication {

    public static void main(String[] args) {
        LoggerFactory.getLogger(FinalLegendApplication.class).trace("SOME TRACE");
        LoggerFactory.getLogger(FinalLegendApplication.class).warn("SOME WARNING");
        SpringApplication.run(FinalLegendApplication.class, args);
    }

}
