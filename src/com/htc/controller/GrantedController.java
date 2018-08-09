package com.htc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/granted")
public class GrantedController extends BaseController{
	
	@RequestMapping("/add/oUserId/aUserId/note")
	@ResponseBody
	public String add(@PathVariable("oUserId") String oUserId,
			@PathVariable("aUserId") String aUserId,
			@PathVariable("note") String note){
		
		return null;
	}
}
