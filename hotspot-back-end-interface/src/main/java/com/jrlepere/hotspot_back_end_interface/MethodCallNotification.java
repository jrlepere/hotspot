package com.jrlepere.hotspot_back_end_interface;

public class MethodCallNotification {

	private String projectId;
	private Method method;
	
	public MethodCallNotification() {}
	
	public MethodCallNotification(String projectId, Method method) {
		this.setProjectId(projectId);
		this.setMethod(method);
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
	
}
