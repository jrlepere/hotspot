package com.jrlepere.hotspot.requests;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.jrlepere.hotspot_back_end_interface.Method;

public class RegisterRequest {

	private static final String RELATIVE_PATH = "%sregister";
	private static final Gson gson = new Gson();

	public static String post(HttpClient httpClient, String url, Method method) throws RequestException {
		HttpPost post = new HttpPost(String.format(RELATIVE_PATH, url));
		try {
			post.setEntity(new StringEntity(gson.toJson(method)));
			post.setHeader("Content-type", "application/json");
			HttpResponse response = httpClient.execute(post);
			String id = EntityUtils.toString(response.getEntity(), "UTF-8");
			post.releaseConnection();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RequestException(e.getMessage());
		}
	}

}
