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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int uid;
	String name;
	String email;
	String mob;
	String userid;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	@JoinTable(name = "user_courses", joinColumns = {@JoinColumn()}, inverseJoinColumns = {@JoinColumn()})
	Set<Courses> course=new HashSet<Courses>();
	
	public Set<Courses> getCourse() {
		return course;
	}
	public void setCourse(Set<Courses> course) {
		this.course = course;
	}
	public user(int uid, String name, String email, String mob, String userid) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.mob = mob;
		this.userid = userid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "user [uid=" + uid + ", name=" + name + ", email=" + email + ", mob=" + mob + ", userid=" + userid + "]";
	}
	public user(int uid, String name, String email, String mob) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.mob = mob;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

}
