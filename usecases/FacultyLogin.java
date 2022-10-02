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
		   String passwrod = scanner.next();
		  
		   AdminDao dao = new AdminDaoImpl();
		   try {
			   String result = dao.FacultyLogin(username,passwrod);	
			   System.out.println(result);
			   System.out.println(1+".  enter for see the course datails");
			   System.out.println(2+".  enter for Fill up the day wise planne");
			   System.out.println(3+".  enter for change password");
			   int key = scanner.nextInt();
		    	switch (key) {
				case 1:
					GetAllCoursePlan.main(arg);
					break;
                case 2:
					CreateCoursePlanByAdmin.main(arg);
					break;
                case 3:
					UpadateFacultyPassWord.main(arg);
					break;
				default:
					System.out.println("Please inter the write option");
					break;
				}
		} catch (Exception e) {
		  System.out.println(e.getMessage());	
		}
		 
	
	}
   
}
