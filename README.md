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
MethodCallWeave.aj
```
package xxx.yyy.zzz;

import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER =
			new HotspotMethodCallAspectInterface("projec-id");
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
```
