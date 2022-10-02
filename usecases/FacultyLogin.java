package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class FacultyLogin {
	public static void main(String[] arg) {
		   Scanner scanner = new Scanner(System.in);
		   System.out.println("FACULTY");
		   System.out.println("Enter your user name");
		   String username = scanner.next();
		   
		   System.out.println("enter new your password");
		   int passwrod = scanner.nextInt();
		  
		   AdminDao dao = new AdminDaoImpl();
		   try {
			   String result = dao.FacultyLogin(username,passwrod);	
			   System.out.println(result);
			   GetAllCoursePlan.main(arg);
			   CreateCoursePlanByAdmin.main(arg);
			   UpadateFacultyPassWord.main(arg);
		} catch (Exception e) {
		  System.out.println(e.getMessage());	
		}
		 
	
	}
   
}
