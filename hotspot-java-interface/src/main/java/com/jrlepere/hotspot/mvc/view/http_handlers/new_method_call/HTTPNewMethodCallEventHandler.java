package com.jrlepere.hotspot.mvc.view.http_handlers.new_method_call;

import com.jrlepere.hotspot.mvc.controller.MethodCallController;
import com.jrlepere.hotspot.mvc.view.http_handlers.AHTTPMethodCallEventHandler;

public class HTTPNewMethodCallEventHandler extends AHTTPMethodCallEventHandler {

	public HTTPNewMethodCallEventHandler(MethodCallController methodCallController, String url) {
		super(methodCallController, url);
	}

	public void alert() {
		post(getHttpPost(new NewMethodCall(controller.getMethodCallId(), controller.getMethodCall())));
	}

}
