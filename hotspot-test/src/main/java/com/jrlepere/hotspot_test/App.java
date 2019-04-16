package com.jrlepere.hotspot_test;

import java.util.Random;

public class App {
	
	public static String echo(String message) {
		return message;
	}
	
	public static String echo2(String message) {
		return message + message;
	}
	
	public static String echo3(String message) {
		return message + message + message;
	}
	
    public static void main(String[] args) throws InterruptedException {
        Random gen = new Random();
    	while (true) {
        	int x = gen.nextInt(3);
        	if (x == 0) {
        		echo("");
        	} else if (x == 1) {
        		echo2("");
        	} else {
        		echo3("");
        	}
        	Thread.sleep(100);
        }
    }
}
