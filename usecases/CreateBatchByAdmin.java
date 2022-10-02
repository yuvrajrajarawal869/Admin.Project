package com.masai.usecases;

import java.sql.Date;
import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class CreateBatchByAdmin {
    public static void main(String[] arg) {
    	
    	    Scanner scanner= new Scanner(System.in);
			
			System.out.println("Enter batchId Number:");
			int batchId= scanner.nextInt();
			
			System.out.println("Enter courseId:");
			int courseId= scanner.nextInt();
			
			System.out.println("Enter facultyId:");
			int facultyId= scanner.nextInt();
			
			System.out.println("Enter number of Students:");
			int numberofStudents= scanner.nextInt();
			
			System.out.println("Enter batch start Date in format YYY/MM/DD:");
			String batchstartDate= scanner.next();
			
			System.out.println("Enter duration:");
			String duration= scanner.next();
			
			AdminDao dao=new AdminDaoImpl();
			
			
			String result= dao.CreatBatch(batchId,courseId,facultyId,numberofStudents,batchstartDate,duration);
			
			System.out.println(result);

	}
}
