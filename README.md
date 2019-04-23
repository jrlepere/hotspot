# hotspot
Method call visualization tool.

## pom.xml dependency
```
<dependency>
  <groupId>com.jrlepere</groupId>
  <artifactId>hotspot</artifactId>
  <version>0.0.0-SNAPSHOT-jar-with-dependencies</version>
</dependency>
```

## AspectJ
MethodCallWeave.java
```
package com.jrlepere.hotspot_test;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER =
			new HotspotMethodCallAspectInterface("888beb9d-36d8-468e-bef4-b3c8e11aa5b0");
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
```
