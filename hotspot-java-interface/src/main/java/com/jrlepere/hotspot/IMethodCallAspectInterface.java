package com.jrlepere.hotspot;

import org.aspectj.lang.JoinPoint;

public interface IMethodCallAspectInterface {

	public void handleMethodCallStart(JoinPoint.StaticPart joinPointStaticPart, long callTime);
	public void handleMethodCallEnd(JoinPoint.StaticPart joinPointStaticPart, long callTime);
	
}
