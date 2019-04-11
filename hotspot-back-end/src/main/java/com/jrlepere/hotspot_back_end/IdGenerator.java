package com.jrlepere.hotspot_back_end;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class IdGenerator {

	private Set<String> ids = new HashSet<>();
	
	public String generateUniqueId() {
		String id;
		while (true) {
			id = UUID.randomUUID().toString();
			if (!ids.contains(id)) {
				ids.add(id);
				break;
			}
		}
		return id;
	}

}
