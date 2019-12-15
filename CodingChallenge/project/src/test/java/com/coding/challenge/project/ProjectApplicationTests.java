package com.coding.challenge.project;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coding.challenge.project.Service.ProjectOperation;
import com.coding.challenge.project.bean.UserBean;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	ProjectOperation projectOperation;
	
	
	@Test
	public void testNullCreateUser() {
		String userId = "";
		HashMap<String, UserBean> userMap = new HashMap<String, UserBean>();
		
		
		userMap = projectOperation.createUser(userId, userMap);
		
		
		assertEquals(userMap.size(), 0);
		
		
	}
	
	@Test
	public void testCreateUser() {
		String userId = "sh306162";
		HashMap<String, UserBean> userMap = new HashMap<String, UserBean>();
		
		
		userMap = projectOperation.createUser(userId, userMap);
		
		System.out.println(userMap.size());
		
		assertEquals(userMap.size(), 1);
		
		
	}
	
	@Test
	public void nullCreateMessage() {
		String userId = "";
		String message = "";
		HashMap<String, UserBean> userMap = new HashMap<String, UserBean>();
		
		userMap = projectOperation.createMessage(userId, message, userMap);
		
		assertEquals(userMap.size(), 0);
		
		
	}
	
	@Test
	public void createMessage() {
		String userId = "sh306126";
		String message = "this is test message";
		HashMap<String, UserBean> userMap = new HashMap<String, UserBean>();
		
		userMap = projectOperation.createMessage(userId, message, userMap);
		
		assertNotEquals(userMap.size(), 0);
	}
	

}
