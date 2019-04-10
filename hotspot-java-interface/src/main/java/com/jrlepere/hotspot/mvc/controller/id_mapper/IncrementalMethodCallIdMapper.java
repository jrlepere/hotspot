package com.jrlepere.hotspot.mvc.controller.id_mapper;

import java.util.HashMap;
import java.util.Map;

import com.jrlepere.hotspot.mvc.model.MethodCall;

public class IncrementalMethodCallIdMapper implements IMethodCallIdMapper {

	private Map<MethodCall, String> methodCallIdMap;
	
	public IncrementalMethodCallIdMapper() {
		methodCallIdMap = new HashMap<>();
	}
	
	public boolean contains(MethodCall m) {
		return methodCallIdMap.containsKey(m);
	}

	public void add(MethodCall m) {
		if (!methodCallIdMap.containsKey(m)) {
			methodCallIdMap.put(m, ""+methodCallIdMap.size());
		}
	}

	public String getId(MethodCall m) {
		return methodCallIdMap.get(m);
	}

}
