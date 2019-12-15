package com.coding.challenge.project.bean;

import java.util.ArrayList;

/**
 * File created for storing User Data
 * Created by Wipro
 */

import java.util.List;

public class UserBean {

	private String userId;
	
	private String userName;
	
	private List<MessageBean> messageBean = new ArrayList<MessageBean>();
	
	private List<UserBean> followedUsers = new ArrayList<UserBean>();

	public UserBean() {
		
	}
	
	public UserBean(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	/**
	 * @return the messageBean
	 */
	public List<MessageBean> getMessageBean() {
		return messageBean;
	}

	/**
	 * @param messageBean the messageBean to set
	 */
	public void setMessageBean(List<MessageBean> messageBean) {
		this.messageBean = messageBean;
	}

	/**
	 * @return the followedUsers
	 */
	public List<UserBean> getFollowedUsers() {
		return followedUsers;
	}

	/**
	 * @param followedUsers the followedUsers to set
	 */
	public void setFollowedUsers(List<UserBean> followedUsers) {
		this.followedUsers = followedUsers;
	}
	
	
	
}
