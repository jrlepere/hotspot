package com.jrlepere.hotspot_test;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER = new HotspotMethodCallAspectInterface();
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
