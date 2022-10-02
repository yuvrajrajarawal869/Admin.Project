package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class CreatCourseByAdmin {
public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter courseid:");
		int courseid= sc.nextInt();
		
		System.out.println("Enter course Name:");
		String courseName= sc.next();
		
		System.out.println("Enter course fee:");
		int fee= sc.nextInt();
		
		System.out.println("Enter course  Description:");
		String courseDescription= sc.next();
		
		
		AdminDao dao=new AdminDaoImpl();
		
		//StudentDaoImpl dao = new StudentDaoImpl();
		
		String result= dao.CreatCourse(courseid, courseName, fee, courseDescription);
		
		System.out.println(result);
	}
}
