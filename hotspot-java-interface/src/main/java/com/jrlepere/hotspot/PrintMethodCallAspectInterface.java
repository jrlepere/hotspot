package com.jrlepere.hotspot;

import org.aspectj.lang.JoinPoint.StaticPart;

public class PrintMethodCallAspectInterface implements IMethodCallAspectInterface {

	public void handleMethodCall(StaticPart joinPointStaticPart) {
		System.out.println(joinPointStaticPart.getSignature().toLongString());
	}

}
