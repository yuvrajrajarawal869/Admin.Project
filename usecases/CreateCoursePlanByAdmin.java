package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class CreateCoursePlanByAdmin {
public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter planId:");
		int planId= sc.nextInt();
		
		System.out.println("Enter batchId:");
		int batchId= sc.nextInt();
		
		System.out.println("Enter daynumber:");
		int daynumber= sc.nextInt();
		
		System.out.println("Enter sylabus topic:");
		String topic= sc.next();
		
		System.out.println("Enter topic status:");
		String status= sc.next();
		
		AdminDao dao=new AdminDaoImpl();
		
		//StudentDaoImpl dao = new StudentDaoImpl();
		
		String result= dao.CreatCoursePlan(planId,batchId,daynumber,topic,status);
		
		System.out.println(result);
	}
}
