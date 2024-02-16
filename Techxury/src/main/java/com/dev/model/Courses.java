package com.dev.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cid;
	String Category;
	String Title;
	String Description;
	String Author;
	String no_of_lessons;
	String time;
	String year;
	String Language;
	String Image;
	int rating;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "course")
	Set<user> user=new HashSet<>();
	public Set<user> getUser() {
		return user;
	}
	public void setUser(Set<user> user) {
		this.user = user;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Courses(int cid, String category, String title, String description, String author, String no_of_lessons,
			String time, String year, String language, String image, int rating) {
		super();
		this.cid = cid;
		Category = category;
		Title = title;
		Description = description;
		Author = author;
		this.no_of_lessons = no_of_lessons;
		this.time = time;
		this.year = year;
		Language = language;
		Image = image;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Courses [cid=" + cid + ", Category=" + Category + ", Title=" + Title + ", Description=" + Description
				+ ", Author=" + Author + ", no_of_lessons=" + no_of_lessons + ", time=" + time + ", year=" + year
				+ ", Language=" + Language + ", Image=" + Image + ", rating=" + rating + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getNo_of_lessons() {
		return no_of_lessons;
	}
	public void setNo_of_lessons(String no_of_lessons) {
		this.no_of_lessons = no_of_lessons;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public Courses(int cid, String category, String title, String description, String author, String no_of_lessons,
			String time, String year, String language, String image) {
		super();
		this.cid = cid;
		Category = category;
		Title = title;
		Description = description;
		Author = author;
		this.no_of_lessons = no_of_lessons;
		this.time = time;
		this.year = year;
		Language = language;
		Image = image;
	}
	 
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
