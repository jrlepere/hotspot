package com.jrlepere.hotspot_test;

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
	
    public static void main(String[] args) {
        echo2(echo(echo2(echo("Hello"))));
        echo3("");
    }
}
