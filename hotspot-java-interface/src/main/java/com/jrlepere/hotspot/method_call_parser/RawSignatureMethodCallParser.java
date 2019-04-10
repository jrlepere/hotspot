package com.jrlepere.hotspot.method_call_parser;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint.StaticPart;

import com.jrlepere.hotspot.mvc.model.MethodCall;

public class RawSignatureMethodCallParser implements IMethodCallParser {

	public MethodCall parse(StaticPart joinPointStaticPart) {
		Map<String, Object> methodCallInfo = new HashMap<>();
		methodCallInfo.put("RawSignature", joinPointStaticPart.getSignature().toLongString());
		return new MethodCall(methodCallInfo);
	}

}
