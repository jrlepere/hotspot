package com.jrlepere.hotspot_back_end;

import java.util.HashMap;
import java.util.Map;

import com.jrlepere.hotspot_back_end_interface.Method;

public class IdMethodMap {

	private Map<Method, String> methodToIdMap;
	private Map<String, Method> idToMethodMap;
	
	public IdMethodMap() {
		this.methodToIdMap = new HashMap<>();
		this.idToMethodMap = new HashMap<>();
	}
	
	public Map<Method, String> getMethodToIdMap() {
		return methodToIdMap;
	}
	
	public Map<String, Method> getIdToMethodMap() {
		return idToMethodMap;
	}
	
	public boolean containsMethod(Method m) {
		return methodToIdMap.containsKey(m);
	}
	
	public String getId(Method m) {
		return methodToIdMap.get(m);
	}
	
	public void put(Method m, String id) {
		methodToIdMap.put(m, id);
		idToMethodMap.put(id, m);
	}
		
}
