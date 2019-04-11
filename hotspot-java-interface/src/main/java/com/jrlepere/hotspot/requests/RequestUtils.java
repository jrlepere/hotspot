package com.jrlepere.hotspot.requests;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.google.gson.Gson;

public class RequestUtils {

	private static final Gson gson = new Gson();
	
	public static HttpPost getPostWithBody(String url, String relativePath, Object o) throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url + relativePath);
		post.setEntity(new StringEntity(gson.toJson(o)));
		post.setHeader("Content-type", "application/json");
		return post;
	}
	
}
