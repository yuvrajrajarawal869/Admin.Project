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
		String password = scanner.next();
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String resultString = dao.AdminLogin(username, password);
			System.out.println(resultString);
			Scanner scanner2 = new Scanner(System.in);
			System.out.println(1+".   enter for change password");
			System.out.println(2+".   enter for Creat new Course course");
			System.out.println(3+".   enter for Get All Course Details");
			System.out.println(4+".   enter for Create new Batch");
			System.out.println(5+".   enter for Get All Batch Details");
			System.out.println(6+".   enter for RegisterFaculty new faculty");
			System.out.println(7+".   enter for Get All Faculty Details");
			System.out.println(8+".   enter for Create new Course Plan");
			System.out.println(9+".   enter for see All Course Plan");
			System.out.println(10+".   enter for Upadate Faculty PassWord");
			int key = scanner2.nextInt();
	    	switch (key) {
			case 1:
				UpdatePasswprd.main(arg);
				break;
			case 2:
				CreatCourseByAdmin.main(arg);
				break;
			case 3: 	
			    GetAllCourseDetails.main(arg);
			    break;
			case 4: 	
			    CreateBatchByAdmin.main(arg);
			    break;
			   
			case 5: 	
			    GetAllBatchDetails.main(arg);
			    break;
			case 6: 	
			    RegisterFaculty.main(arg);
				   break;
			case 7: 	
				GetAllFacultyDetails.main(arg);
			    break; 
			case 8: 	
				CreateCoursePlanByAdmin.main(arg);
			    break;
            case 9: 	
				GetAllCoursePlan.main(arg);
			    break;
            case 10: 	
				UpadateFacultyPassWord.main(arg);
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