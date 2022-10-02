package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
public class AdminLogin {
	public static void main(String[] arg) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("ADMIN");
		System.out.println("Enter your user name");
		String username = scanner.next();
		
		System.out.println("enter your password");
		int password = scanner.nextInt();
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String resultString = dao.AdminLogin(username, password);
			System.out.println(resultString);
			Scanner scanner2 = new Scanner(System.in);
			System.out.println(2+".   enter for change password");
			System.out.println(3+".   enter for enroll new course");
			System.out.println(4+".   enter for registerd new faculty");
			System.out.println(5+".   enter for get all course details");
			int key = scanner2.nextInt();
	    	switch (key) {
			case 2:
				UpdatePasswprd.main(arg);
				break;
			case 3: 	
				CreatCourseByAdmin.main(arg);
			    break;
			case 4: 	
				RegisterFaculty.main(arg);
			    break;
			case 5: 	
				GetAllCourseDetails.main(arg);
			    break;
			case 6: 	
				GetAllFacultyDetails.main(arg);
			    break; 
			case 7: 	
				CreateBatchByAdmin.main(arg);
			    break; 
			default:
				System.out.println("Please inter the write option");
				break;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
	   }
	}

}