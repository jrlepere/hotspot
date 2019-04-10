package com.jrlepere.hotspot;

import org.aspectj.lang.JoinPoint;

public interface IMethodCallAspectInterface {

	public void handleMethodCall(JoinPoint.StaticPart joinPointStaticPart);
	
}
