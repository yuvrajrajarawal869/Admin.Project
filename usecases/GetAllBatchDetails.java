package com.masai.usecases;

import java.util.List;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.bean.Batch;
import com.masai.exseption.BatchException;
public class GetAllBatchDetails {
public static void main(String[] args) {
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
		List<Batch> course= dao.getAllBatchDetails();
		
		course.forEach(s ->{
			
			System.out.println("Batch ID:"+s.getBatchId());
			System.out.println("Faculty name: "+s.getFacultyId());
			System.out.println("course ID: "+s.getCourseId());
			System.out.println("Batch Start Date: "+s.getBatchstartDate());
			System.out.println("total Number of Strudent: "+s.getNumberofStudents());
			System.out.println("course duration: "+s.getDuration());
			
			System.out.println("=======================");
		 });
	
		}catch(BatchException se) {
			System.out.println(se.getMessage());
		}
		
	}
}
