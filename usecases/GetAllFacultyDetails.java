package com.masai.usecases;

import java.util.List;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.bean.Course;
import com.masai.bean.Faculty;
import com.masai.exseption.CourseException;
import com.masai.exseption.FacultyException;

public class GetAllFacultyDetails {
public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		List<Faculty> course= dao.getAllFacultyDetails();
		
		course.forEach(s ->{
			
			System.out.println("faculty id:"+s.getFacultyid());
			System.out.println("faculty name: "+s.getFacultyname());
			System.out.println("faculty address: "+s.getFacultyaddress());
			System.out.println("faculty mobile: "+s.getMobile());
			System.out.println("faculty email: "+s.getEmail());
			System.out.println("faculty user name: "+s.getUsername());
			System.out.println("faculty password: "+s.getPassword());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(FacultyException se) {
			System.out.println(se.getMessage());
		}
		
	}
}
