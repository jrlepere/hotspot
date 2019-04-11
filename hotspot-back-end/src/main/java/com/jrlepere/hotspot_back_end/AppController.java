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
import com.jrlepere.hotspot_back_end_interface.MethodCallNotification;

@RestController
public class AppController {
	
	private Map<String, IdMethodMap> idMethodMapPerProject = new HashMap<>();
	private Map<String, List<String>> methodCallLogPerProject = new HashMap<>();
	private IdGenerator idGenerator = new IdGenerator();
	
	@RequestMapping(value = "/register-project", method = RequestMethod.GET)
	public ResponseEntity<String> registerProject() {
		String projectId = idGenerator.generateUniqueProjectId();
		idMethodMapPerProject.put(projectId, new IdMethodMap());
		methodCallLogPerProject.put(projectId, new LinkedList<>());
		return new ResponseEntity<String>(projectId, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notify-method-call", method = RequestMethod.POST)
	public void notifyMethodCall(@RequestBody MethodCallNotification methodCallNotification) {
		Method method = methodCallNotification.getMethod();
		String projectId = methodCallNotification.getProjectId();
		IdMethodMap idMethodMap = idMethodMapPerProject.get(projectId);
		if (!idMethodMap.containsMethod(method)) {
			idMethodMap.put(method, idGenerator.generateUniqueMethodId(projectId));
		}
		methodCallLogPerProject.get(projectId).add(idMethodMap.getId(method));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/method-call-log", method = RequestMethod.GET)
	public ResponseEntity<List<String>> getMethodCallLog(@RequestParam String projectId) {
		return new ResponseEntity<List<String>>(methodCallLogPerProject.get(projectId), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/id-method-map", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Method>> getIdMethodMap(@RequestParam String projectId) {
		return new ResponseEntity<Map<String, Method>>(
				idMethodMapPerProject.get(projectId).getIdToMethodMap(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/method-call-counter", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Integer>> getMethodCallCounter(@RequestParam String projectId) {
		return new ResponseEntity<Map<String, Integer>>(new HashMap<>(), HttpStatus.OK);
	}
	
}
