package com.dev.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.model.Courses;
import com.dev.model.emailOTP;
import com.dev.service.courses_service;
import com.dev.service.user_service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@CrossOrigin
@RestController
@RequestMapping("/course")
public class courses_controller {
	courses_service cres;
	user_service ures;
	
	
	public courses_controller(courses_service cres, user_service ures) {
		super();
		this.cres = cres;
		this.ures = ures;
	}
	@PostMapping("/search")
	public List<Courses> OTPsender(@RequestBody Courses cr) {
		System.out.println(cr.getCategory());
		List<Courses> cs=cres.get_data_by_category(cr.getCategory());
	
		return cs;
	}
	
	
	@GetMapping("/discat")
	public Map getdistinct()
	{
		Map<String, String> mp=cres.get_distinct_categories();
		
		return mp;
	}
	@GetMapping("/all")
	public List<Courses> get_all_data()
	{
		List<Courses> lt=cres.get_all_data();
		return lt;
	}
	@PostMapping("/id")
	public Courses get_single_data(@RequestBody Courses cr)
	{
		System.out.println(cr);
		Courses cs=cres.get_single_data(cr.getCid());
		return cs;
	
	}
	@PostMapping("/cat")
	public List<Courses> get_data_by_category(@RequestBody Courses cr)
	{
		List<Courses> lt=cres.get_data_by_category(cr.getCategory());
		return lt;
	
	}
	@PostMapping("/year")
	public List<Courses> get_data_by_year(@RequestBody Courses cr)
	{
		List<Courses> lt=cres.get_data_by_year(cr.getYear());
		return lt;
	
	}
	@PostMapping("/time")
	public List<Courses> get_data_by_(@RequestBody Courses cr)
	{
		List<Courses> lt=cres.get_data_by_(cr.getTime());
		return lt;
	
	}
	@GetMapping("/famous")
	public List<Courses> get_data_for_famouscourses()
	{
		List<Courses> lt=cres.get_data_for_famous_courses();
		return lt;
	
	}
	
	// Update coursess
	@PostMapping("/update_user_course")
	public String update_user_by_courses(@RequestBody Courses cr) {
		int id;
		id=2;
		Courses c=cres.get_single_data(cr.getCid());
		String msg=ures.updateuser_by_courses(id, c);
		return msg;
	}

}
