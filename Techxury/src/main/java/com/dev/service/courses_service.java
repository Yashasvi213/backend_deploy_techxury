package com.dev.service;

import java.util.List;
import java.util.Map;

import com.dev.model.Courses;

public interface courses_service {

	Map<String, String> get_distinct_categories();
	List<Courses> get_all_data();
	Courses get_single_data(int id);
	List<Courses> get_data_by_category(String category);
	List<Courses> get_data_by_year(String year);
	List<Courses> get_data_by_(String time);
	List<Courses> get_data_for_famous_courses();
	int savecourse(Courses c);
	
}

