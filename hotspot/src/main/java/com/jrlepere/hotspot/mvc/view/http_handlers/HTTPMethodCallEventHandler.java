package com.jrlepere.hotspot.mvc.view.http_handlers;

import com.jrlepere.hotspot.mvc.controller.MethodCallController;
import com.jrlepere.hotspot.mvc.model.MethodCall;

public class HTTPMethodCallEventHandler extends AHTTPMethodCallEventHandler {

	public HTTPMethodCallEventHandler(MethodCallController methodCallController,
			String rootUrl, String parameter) {
		super(methodCallController, rootUrl, parameter);
	}

	public void alert() {
		MethodCall methodCall = controller.getMethodCall();
	}

}
