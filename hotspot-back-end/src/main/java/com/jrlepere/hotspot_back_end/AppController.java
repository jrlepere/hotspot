package com.jrlepere.hotspot_back_end;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrlepere.hotspot_back_end_interface.Method;

@RestController
public class AppController {
	
	private static Map<String, Method> idMethodMap = new HashMap<>();
	private static List<String> methodCallLog = new LinkedList<>();
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Method method) {
		System.out.println(method);
		String id = getUniqueId();
		idMethodMap.put(id, method);
		return new ResponseEntity<String>(id, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notify", method = RequestMethod.POST)
	public void notify(@RequestParam("id") String methodId) {
		System.out.println(methodId);
		methodCallLog.add(methodId);
	}
	
	private String getUniqueId() {
		String id;
		while (true) {
			id = UUID.randomUUID().toString();
			if (!idMethodMap.containsKey(id)) {
				break;
			}
		}
		return id;
	}
	
}
