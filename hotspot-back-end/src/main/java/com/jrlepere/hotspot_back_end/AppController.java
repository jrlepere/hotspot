package com.jrlepere.hotspot_back_end;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrlepere.hotspot_back_end_interface.Method;

@RestController
public class AppController {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestBody Method method) {
		System.out.println(method);
		return "Temp";
	}
	
	@RequestMapping(value = "/notify", method = RequestMethod.POST)
	public void notify(@RequestParam("id") String methodId) {
		System.out.println(methodId);
	}
	
}
