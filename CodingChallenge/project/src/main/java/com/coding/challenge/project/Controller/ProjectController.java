package com.coding.challenge.project.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding.challenge.project.Constants.ProjectConstants;
import com.coding.challenge.project.Service.ProjectOperation;
import com.coding.challenge.project.Utility.ProjectUtility;
import com.coding.challenge.project.bean.MessageBean;
import com.coding.challenge.project.bean.UserBean;


/**
 * Controller file for the project
 * Created by Wipro
 */

@Controller

@RequestMapping("/socialNetwork")
public class ProjectController {

	HashMap<String, UserBean> userMap = new HashMap<String, UserBean>();
	
	private String currentUser = null;
	
	@Autowired
	private ProjectOperation projectOperation;
	
	
	@GetMapping(value="/login")
	public String getLoginPage() {		
		
		return "Login";
	}
	
	
	@PostMapping(value="/users/login")
	public String retrieveUserDetails(@ModelAttribute("userId")String userId,ModelMap model) {
		
		
		userMap = projectOperation.createUser(userId,userMap);
		
		currentUser = userId;
				
		model.addAttribute("userId", userId);
		
		return "UserWall";
	}
	
	@PostMapping(value="/user/page")
	public String addMessage(@RequestParam String message, @RequestParam String userId) {
		
		userMap = projectOperation.createMessage(userId,message, userMap);
		
		return "UserWall";
	}
	
	
	@GetMapping(value="/user/wall/data/{id}")
	@ResponseBody
	public List<String> retrieveUserWallData(@PathVariable String userId) {
		
		List<String> messages = new ArrayList<>();
		
		UserBean userBean =  ProjectUtility.userBeanObject(userId,userMap); 
		
		messages = userBean.getMessageBean().stream().sorted(Comparator.comparing(MessageBean::getMessageTime).reversed()).map(messageBean -> messageBean.getMessage()).collect(Collectors.toList());
		
		return messages;
	}
	
	@GetMapping(value="/user/follow")
	public String followPage() {
		
		return "follow";
	}
	
	@GetMapping(value="/fetch/users/all")
	@ResponseBody
	public List<String> fetchAllUsers(){
		
		List<String> allUsers = userMap.entrySet().stream().filter(s1->!s1.getKey().equalsIgnoreCase(currentUser)).map(userbean -> userbean.getKey()+ProjectConstants.LineBreakConstant).collect(Collectors.toList());
		
		return allUsers;
		
		
	}
	
	
	@PostMapping(value="/follow/user")
	@ResponseBody
	public String followUser(@RequestParam String followUserId) {
		
		UserBean userBean = ProjectUtility.userBeanObject(currentUser,userMap);
		
		UserBean followUserBean = ProjectUtility.userBeanObject(followUserId,userMap);
		
		List<UserBean> followedUsers = userBean.getFollowedUsers();
		
		followedUsers.add(followUserBean);
		
		userBean.setFollowedUsers(followedUsers);
		
		return "Success";
	}
	
	
	@GetMapping(value="/follow/user/wall")
	@ResponseBody
	public Map<String,List<String>> retrieveFollowUserWall(){
		
		UserBean userBean = ProjectUtility.userBeanObject(currentUser,userMap);
		
		Map<String, List<String>> followUserWallMap = new HashMap<>();
		
		List<String> followUserMessages = null;
		
		for(UserBean followedUserBean : userBean.getFollowedUsers()) {
			followUserMessages = followedUserBean.getMessageBean().stream().sorted(Comparator.comparing(MessageBean:: getMessageTime).reversed()).map(s1 -> s1.getMessage()).collect(Collectors.toList());
			followUserWallMap.put(followedUserBean.getUserId(), followUserMessages);
		}
		
		return followUserWallMap;
		
	}
	
	
	
	
}

