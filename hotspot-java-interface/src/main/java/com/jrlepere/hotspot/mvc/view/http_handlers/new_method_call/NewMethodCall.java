package com.jrlepere.hotspot.mvc.view.http_handlers.new_method_call;

import com.jrlepere.hotspot.mvc.model.MethodCall;

public class NewMethodCall {
	
	private String id;
	private MethodCall methodCall;
	
	public NewMethodCall(String id, MethodCall methodCall) {
		this.id = id;
		this.methodCall = methodCall;
	}
	
}
