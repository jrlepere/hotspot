package com.jrlepere.hotspot_test;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER =
			new HotspotMethodCallAspectInterface("591d0874-2d69-4afe-a88a-7a34a4f7ec05");
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
