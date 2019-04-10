package com.jrlepere.hotspot.method_parser;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint.StaticPart;

import com.jrlepere.hotspot_back_end_interface.Method;

public class LongSignatureMethodParser implements IMethodParser {

	public Method parse(StaticPart joinPointStaticPart) {
		Map<String, Object> methodInfo = new HashMap<>();
		methodInfo.put("LongSignature", joinPointStaticPart.getSignature().toLongString());
		return new Method(methodInfo);
	}

}
