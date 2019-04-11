package com.jrlepere.hotspot_back_end;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrlepere.hotspot_back_end_interface.Method;

@RestController
public class AppController {
	
	private Map<String, Method> idMethodMap = new HashMap<>();
	private List<String> methodCallLog = new LinkedList<>();
	private Map<String, Integer> methodCallCounter = new HashMap<>();
	private IdGenerator idGenerator = new IdGenerator();
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Method method) {
		System.out.println(method);
		String id = idGenerator.generateUniqueId();
		idMethodMap.put(id, method);
		methodCallCounter.put(id, 0);
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notify", method = RequestMethod.POST)
	public void notify(@RequestParam("id") String methodId) {
		System.out.println(methodId);
		methodCallLog.add(methodId);
		methodCallCounter.put(methodId, methodCallCounter.get(methodId) + 1);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/method-call-log", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getMethodCallLog() {
		return new ResponseEntity<List<String>>(methodCallLog, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/id-method-map", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Method>> getIdMethodMap() {
		return new ResponseEntity<Map<String, Method>>(idMethodMap, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/method-call-counter", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Integer>> getMethodCallCounter() {
		return new ResponseEntity<Map<String, Integer>>(methodCallCounter, HttpStatus.OK);
	}
	
}
