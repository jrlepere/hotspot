package com.jrlepere.hotspot.method_parser;

import org.aspectj.lang.JoinPoint;

import com.jrlepere.hotspot_back_end_interface.Method;

public interface IMethodParser {
	
	public Method parse(JoinPoint.StaticPart joinPointStaticPart);
	
}
