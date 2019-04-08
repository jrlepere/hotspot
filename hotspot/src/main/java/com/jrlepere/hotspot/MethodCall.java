package com.jrlepere.hotspot;

public class MethodCall {

	private String sig;
	private long time;
	
	public MethodCall(String signature, long callTime) {
		sig = signature;
		time = callTime;
	}
	
}
