package com.jrlepere.hotspot.requests;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import com.jrlepere.hotspot_back_end_interface.MethodCallNotification;

public class NotifyRequest {

	private static final String RELATIVE_PATH = "notify-method-call";
	
	public static void post(HttpClient httpClient, String url, MethodCallNotification methodCallNotification)
			throws RequestException {
		try {
			HttpPost post = RequestUtils.getPostWithBody(url, RELATIVE_PATH, methodCallNotification);
			httpClient.execute(post);
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RequestException(e.getMessage());
		}
	}
	
}
