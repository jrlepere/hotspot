package com.jrlepere.hotspot.mvc.view;

import com.jrlepere.hotspot.mvc.controller.MethodCallController;

public abstract class AMethodCallEventHandler implements IMethodCallEventHandler {
	
	protected MethodCallController controller;
	
	public AMethodCallEventHandler(MethodCallController methodCallController) {
		controller = methodCallController;
	}

}
