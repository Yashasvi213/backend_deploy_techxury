package com.dev.service;

import org.springframework.stereotype.Service;

import com.dev.model.Courses;
import com.dev.model.user;


public interface user_service {
	
	public String saveuser(user users);
	public user get_user_by_id(int uid);
	public user get_user_by_email(String email);
	public String updateuser_by_courses(int uid,Courses c);
	

}
