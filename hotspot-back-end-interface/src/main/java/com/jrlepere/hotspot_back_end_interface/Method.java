package com.jrlepere.hotspot_back_end_interface;

import java.util.Map;

public class Method {

	private Map<String, Object> info;

	public Method() {}

	public Method(Map<String, Object> info) {
		this.info = info;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

	public void addInfo(String key, Object value) {
		info.put(key, value);
	}

	public String toString() {
		return info.toString();
	}

	public boolean equals(Object o) {
		return (this == o) || ((o != null) && (getClass() == o.getClass()) && info.equals(((Method) o).info));
	}

	public int hashCode() {
		return info.hashCode();
	}

}
