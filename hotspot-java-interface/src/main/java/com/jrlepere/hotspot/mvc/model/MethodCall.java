package com.jrlepere.hotspot.mvc.model;

import java.util.HashMap;
import java.util.Map;

public class MethodCall {

	private Map<String, Object> info;
	
	public MethodCall() {
		info = new HashMap<>();
	}
	
	public MethodCall(Map<String, Object> information) {
		info = information;
	}
	
	public void addInformation(String key, Object value) {
		info.put(key, value);
	}
	
}
