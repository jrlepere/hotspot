package com.jrlepere.hotspot_back_end_interface;

import java.util.Map;

public class Method {

	private Map<String, Object> info;
	
	public Method() { }
	
	public Method(Map<String, Object> info) {
		this.info = info;
	}
	
	public Map<String, Object> getInfo() {
		return info;
	}
	
	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}
	
}
