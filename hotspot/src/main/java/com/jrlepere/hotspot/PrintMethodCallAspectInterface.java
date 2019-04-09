package com.jrlepere.hotspot;

import org.aspectj.lang.JoinPoint.StaticPart;

public class PrintMethodCallAspectInterface implements IMethodCallAspectInterface {

	public void handleMethodCallStart(StaticPart joinPointStaticPart, long callTime) {
		System.out.println(joinPointStaticPart.getSignature().toLongString());
	}

	public void handleMethodCallEnd(StaticPart joinPointStaticPart, long callTime) {
		System.out.println(joinPointStaticPart.getSignature().toLongString());
	}

}
