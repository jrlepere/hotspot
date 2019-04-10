package com.jrlepere.hotspot.mvc.view.http_handlers;

import com.jrlepere.hotspot.mvc.controller.MethodCallController;

public class HTTPMethodCallEventHandler extends AHTTPMethodCallEventHandler {

	public HTTPMethodCallEventHandler(MethodCallController methodCallController, String url) {
		super(methodCallController, url);
	}

	public void alert() {
		post(getHttpPost(controller.getMethodCallId()));
	}

}
