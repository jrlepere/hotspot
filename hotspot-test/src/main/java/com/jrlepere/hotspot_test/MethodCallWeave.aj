package com.jrlepere.hotspot_test;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER = new HotspotMethodCallAspectInterface();
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCallStart(thisJoinPointStaticPart,
				System.currentTimeMillis());
	}
	
	after(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCallEnd(thisJoinPointStaticPart,
				System.currentTimeMillis());
	}
	
}
