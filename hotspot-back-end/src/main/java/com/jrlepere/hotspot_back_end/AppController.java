package com.jrlepere.hotspot_back_end;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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

@CrossOrigin
@RestController
public class AppController {

	private Map<String, IdMethodMap> idMethodMapPerProject = new HashMap<>();
	private Map<String, Deque<String>> methodCallLogPerProject = new HashMap<>();
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
		methodCallLogPerProject.get(projectId).addFirst(idMethodMap.getId(method));
	}

	@RequestMapping(value = "/is-valid-project-id", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isValidProjectId(@RequestParam String projectId) {
		return new ResponseEntity<Boolean>(idMethodMapPerProject.containsKey(projectId), HttpStatus.OK);
	}

	@RequestMapping(value = "/method-call-log", method = RequestMethod.GET)
	public ResponseEntity<Queue<String>> getMethodCallLog(@RequestParam String projectId) {
		return new ResponseEntity<Queue<String>>(methodCallLogPerProject.get(projectId), HttpStatus.OK);
	}

	@RequestMapping(value = "/id-method-map", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Method>> getIdMethodMap(@RequestParam String projectId) {
		return new ResponseEntity<Map<String, Method>>(idMethodMapPerProject.get(projectId).getIdToMethodMap(),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/method-call-counts", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, String>>> getMethodCallCounts(@RequestParam String projectId) {
		Map<String, Integer> methodCounter = new HashMap<>();
		for (String methodId : methodCallLogPerProject.get(projectId)) {
			if (!methodCounter.containsKey(methodId)) methodCounter.put(methodId, 0);
			methodCounter.put(methodId, methodCounter.get(methodId) + 1);
		}
		Queue<Map<String, String>> pq = new PriorityQueue<>(new Comparator<Map<String, String>>() {
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				return Integer.parseInt(o2.get("frequency")) - Integer.parseInt(o1.get("frequency"));
			}
		});
		for (String methodId : methodCounter.keySet()) {
			pq.add(new HashMap<String, String>(){{
				put("methodId", methodId);
				put("frequency", ""+methodCounter.get(methodId));
			}});
		}
		List<Map<String, String>> res = new LinkedList<>();
		while (!pq.isEmpty()) {
			res.add(pq.remove());
		}
		return new ResponseEntity<List<Map<String, String>>>(res, HttpStatus.OK);
	}

}
