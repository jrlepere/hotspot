# hotspot
Method call visualization tool.

## pom.xml dependency
```
<dependency>
  <groupId>com.jrlepere</groupId>
  <artifactId>hotspot</artifactId>
  <version>0.0.0-SNAPSHOT-jar-with-dependencies</version>
</dependency>
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjrt</artifactId>
  <version>1.9.2</version>
</dependency>
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.9.2</version>
</dependency>
```

## AspectJ
MethodCallWeave.aj
```
import com.jrlepere.hotspot.*;

public aspect MethodCallWeave {
	
	private static final IMethodCallAspectInterface METHOD_CALL_HANDLER =
			new HotspotMethodCallAspectInterface("project-id");
	
	pointcut traceMethods():
		execution(* *(..)) && !cflow(within(MethodCallWeave));
	
	before(): traceMethods() {
		METHOD_CALL_HANDLER.handleMethodCall(thisJoinPointStaticPart);
	}
	
}
```
