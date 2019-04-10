package com.jrlepere.hotspot;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.aspectj.lang.JoinPoint;

import com.jrlepere.hotspot.method_parser.IMethodParser;
import com.jrlepere.hotspot.method_parser.LongSignatureMethodParser;
import com.jrlepere.hotspot.requests.NotifyRequest;
import com.jrlepere.hotspot.requests.RegisterRequest;
import com.jrlepere.hotspot.requests.RequestException;
import com.jrlepere.hotspot_back_end_interface.Method;

public class HotspotMethodCallAspectInterface implements IMethodCallAspectInterface {

	private static final String URL = "http://localhost:8080/";
	private static final HttpClient httpClient = HttpClientBuilder.create().build();
	private IMethodParser methodParser;
	private Map<Method, String> methodIdMap = new HashMap<>();
	
	public HotspotMethodCallAspectInterface() {
		methodParser = new LongSignatureMethodParser();
	}

	public void handleMethodCall(JoinPoint.StaticPart joinPointStaticPart) {
		Method method = methodParser.parse(joinPointStaticPart);
		try {
			if (!methodIdMap.containsKey(method)) {
				methodIdMap.put(method, RegisterRequest.post(httpClient, URL, method));
			}
			NotifyRequest.post(httpClient, URL, methodIdMap.get(method));
		} catch (RequestException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
