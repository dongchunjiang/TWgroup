package com.htc.utils;

public class Test {
	public static void main(String[] args) {
		CommonUtils util = new CommonUtils();
		AIInterface ai = util.getAIInterface();
		
		ai.getUser("group1", "user1");
	}
}
