package com.jrlepere.hotspot;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;

public class MethodCallHandler {

	private static final Map<String, Integer> METHOD_SIG_ID_MAP = new HashMap<>();

	public void handleMethodCallStart(JoinPoint.StaticPart joinPointStaticPart,
			long callTime) {
		String sig = getMethodSignature(joinPointStaticPart);
		System.out.println(sig);
	}
	
	public void handleMethodCallEnd(JoinPoint.StaticPart joinPointStaticPart,
			long callTime) {
		String sig = getMethodSignature(joinPointStaticPart);
		System.out.println(sig);
	}
	
	private static String getMethodSignature(JoinPoint.StaticPart joinPointStaticPart) {
		return joinPointStaticPart.getSignature().toLongString();
	}
	
}
