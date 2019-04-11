package com.jrlepere.hotspot;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.aspectj.lang.JoinPoint;

import com.jrlepere.hotspot.method_parser.IMethodParser;
import com.jrlepere.hotspot.method_parser.LongSignatureMethodParser;
import com.jrlepere.hotspot.requests.NotifyRequest;
import com.jrlepere.hotspot.requests.RequestException;
import com.jrlepere.hotspot_back_end_interface.Method;
import com.jrlepere.hotspot_back_end_interface.MethodCallNotification;

public class HotspotMethodCallAspectInterface implements IMethodCallAspectInterface {

	private static final String URL = "http://localhost:8080/";
	private static final HttpClient httpClient = HttpClientBuilder.create().build();
	private String projectId;
	private IMethodParser methodParser;
	
	public HotspotMethodCallAspectInterface(String projectId) {
		this.projectId = projectId;
		methodParser = new LongSignatureMethodParser();
	}

	public void handleMethodCall(JoinPoint.StaticPart joinPointStaticPart) {
		Method method = methodParser.parse(joinPointStaticPart);
		try {
			NotifyRequest.post(httpClient, URL, new MethodCallNotification(projectId, method));
		} catch (RequestException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
