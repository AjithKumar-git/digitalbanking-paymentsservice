package com.capg.paymentservice;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
	private static Logger log = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
    	log.info("logger enabled entering main \n \n");
    	System.out.println("Entering Main");
    	SpringApplication.run(App.class, args);
    }
}
