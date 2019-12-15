package com.coding.challenge.project.Utility;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.coding.challenge.project.bean.UserBean;

@Component
public class ProjectUtility {

/**
 * method to create userbean or retrieve
 * existing userBean
 * @param userId
 * @return
 */
public static UserBean userBeanObject(String userId,HashMap<String, UserBean> userMap) {
		
		UserBean userBean = null;
		
		if(userMap.containsKey(userId)) {
			userBean = userMap.get(userId);
		}else {
			userBean = new UserBean(userId);
		}
		
		
		return userBean;
	}
}
