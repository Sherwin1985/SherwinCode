package com.coding.challenge.project.Service.ServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.springframework.stereotype.Component;

import com.coding.challenge.project.Constants.ProjectConstants;
import com.coding.challenge.project.Service.ProjectOperation;
import com.coding.challenge.project.Utility.ProjectUtility;
import com.coding.challenge.project.bean.MessageBean;
import com.coding.challenge.project.bean.UserBean;

import io.micrometer.core.instrument.util.StringUtils;

@Component
public class ProjectOperationImpl implements ProjectOperation{
	
	
	@Override
	public HashMap<String, UserBean> createUser(String userId,HashMap<String, UserBean> userMap) {
		
		if(StringUtils.isNotEmpty(userId)) {
			UserBean userBean = ProjectUtility.userBeanObject(userId,userMap);
			
			userMap.put(userId, userBean);
		}
		
		
		return userMap;
	}

	@Override
	public HashMap<String, UserBean> createMessage(String userId,String message, HashMap<String, UserBean> userMap) {
		
		if(StringUtils.isNotEmpty(userId)) {
			UserBean userBean = ProjectUtility.userBeanObject(userId,userMap);		
			
			MessageBean messageBean = null;
			
			List<MessageBean> messageBeans = userBean.getMessageBean();;
			
			
			Date data = new Date();
			
			if(!message.isEmpty()) {
				String messageWithLineBreak = message+ProjectConstants.LineBreakConstant;
				
				messageBean = new MessageBean(messageWithLineBreak,data);
				
				messageBeans.add(messageBean);
				
				userBean.setMessageBean(messageBeans);
			}
			userMap.put(userId, userBean);
		}
		
		
		return userMap;
	}
}
