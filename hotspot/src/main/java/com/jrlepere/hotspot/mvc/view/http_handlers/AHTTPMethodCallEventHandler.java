package com.jrlepere.hotspot.mvc.view.http_handlers;

import com.jrlepere.hotspot.mvc.controller.MethodCallController;
import com.jrlepere.hotspot.mvc.view.AMethodCallEventHandler;

public abstract class AHTTPMethodCallEventHandler extends AMethodCallEventHandler {

	protected String url;
	
	public AHTTPMethodCallEventHandler(MethodCallController methodCallController,
			String rootUrl, String parameter) {
		super(methodCallController);
		url = rootUrl + parameter;
	}

}
