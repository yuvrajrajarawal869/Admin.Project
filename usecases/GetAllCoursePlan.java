package com.masai.usecases;

import java.util.List;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.bean.CoursePlan;
import com.masai.exseption.CoursPlanException;

public class GetAllCoursePlan {
public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		List<CoursePlan> course= dao.getAllCoursPlanDetails();
		
		course.forEach(s ->{
			
			System.out.println("Batch ID:"+s.getPlanId());
			System.out.println("Faculty name: "+s.getBatchId());
			System.out.println("course ID: "+s.getDaynumber());
			System.out.println("Batch Start Date: "+s.getTopic());
			System.out.println("total Number of Strudent: "+s.getStatus());
			
			System.out.println("=======================");
		 });
	
		}catch(CoursPlanException se) {
			System.out.println(se.getMessage());
		}
		
	}
}
