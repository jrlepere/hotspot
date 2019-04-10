package com.jrlepere.hotspot.mvc.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.jrlepere.hotspot.mvc.controller.id_mapper.IMethodCallIdMapper;
import com.jrlepere.hotspot.mvc.controller.id_mapper.IncrementalMethodCallIdMapper;
import com.jrlepere.hotspot.mvc.model.MethodCall;
import com.jrlepere.hotspot.mvc.view.IMethodCallEventHandler;

public class MethodCallController {

	private MethodCall methodCall;
	private IMethodCallIdMapper methodCallIdMapper;
	private Map<MethodCallEvent, List<IMethodCallEventHandler>> methodCallEventHandlers;
	
	public MethodCallController() {
		methodCallIdMapper = new IncrementalMethodCallIdMapper();
		methodCallEventHandlers = new HashMap<>();
	}
	
	public void addListener(MethodCallEvent event, IMethodCallEventHandler handler) {
		if (!methodCallEventHandlers.containsKey(event)) {
			methodCallEventHandlers.put(event, new LinkedList<IMethodCallEventHandler>());
		}
		methodCallEventHandlers.get(event).add(handler);
	}
	
	public void setMethodCall(MethodCall m) {
		methodCall = m;
		if (isNewMethodCall(methodCall)) {
			methodCallIdMapper.add(methodCall);
			notifyListeners(MethodCallEvent.NEW_METHOD_CALL);
		}
		notifyListeners(MethodCallEvent.METHOD_CALL);
	}
	
	public MethodCall getMethodCall() {
		return methodCall;
	}
	
	public String getMethodCallId() {
		return methodCallIdMapper.getId(methodCall);
	}
	
	private boolean isNewMethodCall(MethodCall m) {
		return !methodCallIdMapper.contains(m);
	}
	
	private void notifyListeners(MethodCallEvent event) {
		if (methodCallEventHandlers.containsKey(event)) {
			for (IMethodCallEventHandler handler : methodCallEventHandlers.get(event)) {
				handler.alert();
			}
		}
	}
	
}
