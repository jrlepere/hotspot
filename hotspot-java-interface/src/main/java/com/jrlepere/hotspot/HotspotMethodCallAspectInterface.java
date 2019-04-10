package com.jrlepere.hotspot;

import org.aspectj.lang.JoinPoint;

import com.jrlepere.hotspot.method_call_parser.IMethodCallParser;
import com.jrlepere.hotspot.method_call_parser.RawSignatureMethodCallParser;
import com.jrlepere.hotspot.mvc.controller.MethodCallController;
import com.jrlepere.hotspot.mvc.controller.MethodCallEvent;
import com.jrlepere.hotspot.mvc.model.MethodCall;
import com.jrlepere.hotspot.mvc.view.http_handlers.HTTPMethodCallEventHandler;
import com.jrlepere.hotspot.mvc.view.http_handlers.new_method_call.HTTPNewMethodCallEventHandler;

public class HotspotMethodCallAspectInterface implements IMethodCallAspectInterface {

	private static final String ROOT_URL = "com.jrlepere.test/";
	private static final String METHOD_CALL_RELATIVE_PATH = "called?id=";
	private static final String NEW_METHOD_CALL_RELATIVE_PATH = "register/";
	private static final String START_TIME = "StartTime";
	private static final String END_TIME = "EndTime";
	private IMethodCallParser methodCallParser;
	private MethodCallController methodCallController;

	public HotspotMethodCallAspectInterface() {
		methodCallParser = new RawSignatureMethodCallParser();
		methodCallController = new MethodCallController();
		methodCallController.addListener(MethodCallEvent.METHOD_CALL,
				new HTTPMethodCallEventHandler(methodCallController, ROOT_URL + METHOD_CALL_RELATIVE_PATH));
		methodCallController.addListener(MethodCallEvent.NEW_METHOD_CALL,
				new HTTPNewMethodCallEventHandler(methodCallController, ROOT_URL + NEW_METHOD_CALL_RELATIVE_PATH));
		
	}

	public void handleMethodCallStart(JoinPoint.StaticPart joinPointStaticPart, long callTime) {
		MethodCall methodCall = methodCallParser.parse(joinPointStaticPart);
		methodCall.addInformation(START_TIME, callTime);
		methodCallController.setMethodCall(methodCall);
	}

	public void handleMethodCallEnd(JoinPoint.StaticPart joinPointStaticPart, long callTime) {
		MethodCall methodCall = methodCallParser.parse(joinPointStaticPart);
		methodCall.addInformation(END_TIME, callTime);
		methodCallController.setMethodCall(methodCall);
	}
	
}
