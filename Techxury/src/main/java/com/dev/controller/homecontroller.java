package com.dev.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.emailservice;
import com.dev.model.Courses;
import com.dev.model.emailOTP;
import com.dev.model.user;
import com.dev.service.user_service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@RequestMapping("/otp")
public class homecontroller {
	int otpp;
	String email;

	user_service uservice;

	public homecontroller(user_service uservice) {
		super();
		this.uservice = uservice;
	}

	@Autowired
	private emailservice o;

	@PostMapping("/step1")
	public String OTPsender(@RequestBody emailOTP otp,HttpServletRequest request,HttpSession http) {
		System.out.println(otp);
		Random random = new Random();
		otpp = random.nextInt(9999);
//		otp.setOTP(otpp);
		email = otp.getemail().toLowerCase();
		String output = o.sendEmail(otp.getemail(), otpp);
		// otpp=1234;
		System.out.println(otpp);

		return "sent";

	}
	@GetMapping("/usersession")
	public user usersession(HttpServletRequest request,HttpSession http)
	{
		http=request.getSession();
		user u=new user();
		u.setEmail((String) http.getAttribute("useremail"));
		u.setUserid((String) http.getAttribute("userid"));
		u.setUid((int) http.getAttribute("uid"));
		return u;
	}

	@PostMapping("/step2")
	public String OTPChecker(@RequestBody emailOTP otpc,HttpServletRequest request,HttpSession http) {
		System.out.println(otpc);
		//com.dev.model.user user1 = new com.dev.model.user();
		
		if (otpp == otpc.getOTP()) {
			user u = uservice.get_user_by_email(email);
			if (u.getUid()==0) 
			{
				int a;
				Random rand = new Random();
				a = rand.nextInt(999);
				String b = "@techxury";
				String Userid = a + b;
				u.setUserid(Userid);
				u.setEmail(email);
				uservice.saveuser(u);
			}
			
			http=request.getSession();
			http.setAttribute("uid",u.getUid());
			http.setAttribute("userid",u.getUserid());
			http.setAttribute("useremail",u.getEmail());
			System.out.println(http.getAttribute("user")+"fghj");
				
			System.out.println(u);
			// user1.setUserid(userid);		
			return "1";
		} else {
			System.out.println("Wrong otp");
			return "0";
		}
	}

//	@GetMapping("try")
//	public String many_many()
//	{
//		user u=new user(1111,"sdsfdgf","adsfdgh","34567","sadsf");
//		Courses cs=new Courses(12345, "email", "email", "email", "email", "email", "email", "email", "email", "email");
//		Courses css=new Courses(123446666, "edsfmail", "egmail", "emgail", "emagil", "emagil", "egmail", "email", "email", "email");
//		u.getCourse().add(cs);
//		u.getCourse().add(css);
//		cs.getUser().add(u);
//		css.getUser().add(u);
//		uservice.saveuser(u);
//				
//		return "Succes";
//	}
}
