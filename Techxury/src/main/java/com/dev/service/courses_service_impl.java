package com.dev.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.dev.model.Courses;
import com.dev.repository.courses_respository;
@Service
public class courses_service_impl implements courses_service {

     courses_respository cres;	
	public courses_service_impl(courses_respository cres) {
		super();
		this.cres = cres;
	}

	@Override
	public Map<String, String> get_distinct_categories() {
		List<Courses> lt=cres.findAll();
		List<String> lts=new ArrayList();
		//System.out.println(lt.get(1));
		//System.out.println(lt.size());
		HashMap m=new HashMap();
		for(int i=0;i<lt.size();i++)
		{
			Courses cs=lt.get(i);
			//System.out.println(cs.getCategory());
			if(lts.indexOf(cs.getCategory())==-1)
			{
				m.put(cs.getImage(), cs.getCategory());	
				System.out.println(m.values());
				System.out.println(m.keySet());
			}
			else
			{
			
			}
		}
		//System.out.println(lts);
		//lt.forEach(null);
		// TODO Auto-generated method stub
		return m;
	}

	@Override
	public List<Courses> get_all_data() {
		List<Courses> lt=cres.findAll();
		
// TODO Auto-generated method stub
		return lt;
	}

	@Override
	public Courses get_single_data(int id) {
		
		Courses cs= cres.findById(id).get();
		return cs;
	}

	@Override
	public List<Courses> get_data_by_category(String category) {
		//category.toLowerCase();
		System.out.println(category+"ss");
		List<Courses> lt=cres.findAll();
		List<Courses> lts=new ArrayList();
		//System.out.println(lt.get(1));
		//System.out.println(lt.size());
		//System.out.println(category.toLowerCase());
		for(int i=0;i<lt.size();i++)
		{
			Courses cs=lt.get(i);
			String cat=cs.getCategory().toLowerCase();
			//System.out.println(cat);
			//System.out.println(cs.getCategory());
			if(cat.contains(category.toLowerCase()))
			{
				lts.add(lt.get(i));	
			}
			
		}
		
		return lts;
	}

	@Override
	public List<Courses> get_data_by_year(String year) {
		List<Courses> lt=cres.findAll();
		List<Courses> lts=new ArrayList();
		//System.out.println(lt.get(1));
		//System.out.println(lt.size());
		for(int i=0;i<lt.size();i++)
		{
			Courses cs=lt.get(i);
		
			//System.out.println(cs.getCategory());
			if(cs.getYear().equals(year))
			{
				lts.add(lt.get(i));	
			}
			
		}
		
		return lts;}

	@Override
	public List<Courses> get_data_by_(String time) {
		List<Courses> lt=cres.findAll();
		List<Courses> lts=new ArrayList();
		//System.out.println(lt.get(1));
		//System.out.println(lt.size());
		for(int i=0;i<lt.size();i++)
		{
			Courses cs=lt.get(i);
		
			//System.out.println(cs.getCategory());
			if(cs.getTime().equals(time))
			{
				lts.add(lt.get(i));	
			}
			
		}
		
		return lts;}

	@Override
	public List<Courses> get_data_for_famous_courses() {
		List<Courses> lt=cres.findAll();
//		lt.sort(Comparator.comparing(Courses::getRating).reversed());
//		List<Courses> ltt=new ArrayList<>();
////System.out.println(lt);

//		ltt.add(lt.get(0));
//		ltt.add(lt.get(1));
//		//ltt.add(lt.get(2));
		//ltt.add(lt.get(3));
//		
//		for(int i=0;i<4;i++)
//		{
//			
//		ltt.add(lt.get(i));	
//		}
		
		
		
		
		
		// TODO Auto-generated method stub
		return lt;
	}

	@Override
	public int savecourse(Courses c) {
		System.out.println(cres.save(c));
		// TODO Auto-generated method stub
		return 0;
	}

}
