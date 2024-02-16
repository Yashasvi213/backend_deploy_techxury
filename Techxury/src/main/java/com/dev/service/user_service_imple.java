package com.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.model.Courses;
import com.dev.model.user;
import com.dev.repository.user_repository;
@Service
public class user_service_imple implements user_service {

	user_repository ures;
	
	public user_service_imple(user_repository ures) {
		super();
		this.ures = ures;
	}

	@Override
	public String saveuser(user users) {
		ures.save(users);
		return "success";
		// TODO Auto-generated method s
	}

	@Override
	public String updateuser_by_courses(int uid,Courses c) {
		user u= get_user_by_id(uid);
		u.getCourse().add(c);
		saveuser(u);
		
		// TODO Auto-generated method stub
		return "Successs";
	}

	@Override
	public user get_user_by_id(int uid) {
		return ures.findById(uid).get();
	}

	@Override
	public user get_user_by_email(String email) {
		List<user> lt=ures.findAll();
		user u=new user();
		//user uu=new user();
		
		//System.out.println(lt);
		for(int i=0;i<lt.size();i++)
		{
			if(email.equals(lt.get(i).getEmail()))
			{
				u=lt.get(i);
				//System.out.println(u);
				break;
			}
			
			
		}
		return u;
		
		// TODO Auto-generated method stub
		
	}

}
