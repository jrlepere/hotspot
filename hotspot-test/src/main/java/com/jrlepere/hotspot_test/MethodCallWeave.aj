package com.jrlepere.hotspot_test;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER =
			new HotspotMethodCallAspectInterface("c59ab23b-7380-4ad2-a69e-c77acdc56f7a");
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
