package com.jrlepere.hotspot.requests;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

public class NotifyRequest {

	private static final String RELATIVE_PATH = "%snotify?id=%s";
	
	public static void post(HttpClient httpClient, String url, String methodId) throws RequestException {
		HttpPost post = new HttpPost(String.format(RELATIVE_PATH, url, methodId));
		try {
			httpClient.execute(post);
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RequestException(e.getMessage());
		}
	}
	
}
