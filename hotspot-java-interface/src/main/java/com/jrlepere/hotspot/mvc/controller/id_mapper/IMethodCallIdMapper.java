package com.jrlepere.hotspot.mvc.controller.id_mapper;

import com.jrlepere.hotspot.mvc.model.MethodCall;

public interface IMethodCallIdMapper {
	
	public boolean contains(MethodCall m);
	public void add(MethodCall m);
	public String getId(MethodCall m);
	
}
