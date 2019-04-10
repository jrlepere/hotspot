package com.jrlepere.hotspot.mvc.view.http_handlers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.jrlepere.hotspot.mvc.controller.MethodCallController;
import com.jrlepere.hotspot.mvc.view.AMethodCallEventHandler;

public abstract class AHTTPMethodCallEventHandler extends AMethodCallEventHandler {

	protected String url;
	private static final HttpClient httpClient = HttpClientBuilder.create().build();
	private static final Gson gson = new Gson();
	
	public AHTTPMethodCallEventHandler(MethodCallController methodCallController, String url) {
		super(methodCallController);
		this.url = url;
	}

	protected void post(HttpPost post) {
		System.out.println(post);
		try {
			httpClient.execute(post);
			post.releaseConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	protected HttpPost getHttpPost(Object entity) {
		HttpPost post = new HttpPost(url);
		try {
			post.setEntity(new StringEntity(gson.toJson(entity)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		post.setHeader("Content-type", "application/json");
		return post;
	}
	
	protected HttpPost getHttpPost(String parameter) {
		return new HttpPost(url + parameter);
	}
}
