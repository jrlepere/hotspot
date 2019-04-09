package com.jrlepere.hotspot.method_call_parser;

import org.aspectj.lang.JoinPoint;

import com.jrlepere.hotspot.mvc.model.MethodCall;

public interface IMethodCallParser {
	
	public MethodCall parse(JoinPoint.StaticPart joinPointStaticPart);
	
}
