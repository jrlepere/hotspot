package com.jrlepere.hotspot_back_end;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class IdGenerator {

	private Map<String, Set<String>> methodIdsPerProject = new HashMap<>();
	
	public String generateUniqueProjectId() {
		String id;
		while (true) {
			id = UUID.randomUUID().toString();
			if (!methodIdsPerProject.containsKey(id)) {
				methodIdsPerProject.put(id, new HashSet<String>());
				break;
			}
		}
		return id;
	}
	
	public String generateUniqueMethodId(String projectId) {
		Set<String> methodIds = methodIdsPerProject.get(projectId);
		String id;
		while (true) {
			id = UUID.randomUUID().toString();
			if (!methodIds.contains(id)) {
				methodIds.add(id);
				break;
			}
		}
		return id;
	}

}
