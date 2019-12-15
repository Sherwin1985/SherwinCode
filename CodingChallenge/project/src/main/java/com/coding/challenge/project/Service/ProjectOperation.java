package com.coding.challenge.project.Service;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.coding.challenge.project.bean.UserBean;


@Component
public interface ProjectOperation {
	
	public HashMap<String, UserBean> createUser(String userId,HashMap<String, UserBean> userMap);
	
	public HashMap<String, UserBean> createMessage(String userId,String message,HashMap<String, UserBean> userMap);

}
