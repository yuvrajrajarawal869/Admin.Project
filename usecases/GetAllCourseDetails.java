package com.masai.usecases;

import java.util.List;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.bean.Course;
import com.masai.exseption.CourseException;

public class GetAllCourseDetails {
public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		List<Course> course= dao.getAllCourseDetails();
		
		course.forEach(s ->{
			
			System.out.println("courseid:"+s.getCourseid());
			System.out.println("course name: "+s.getCourseName());
			System.out.println("course fee: "+s.getFee());
			System.out.println("course description: "+s.getCourseDescription());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(CourseException se) {
			System.out.println(se.getMessage());
		}
		
	}

}
