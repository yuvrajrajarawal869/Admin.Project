package com.masai.usecases;
import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
public class RegisterFaculty {
		public static void main(String[] arg) {
			// TODO Auto-generated method stub
        Scanner scanner= new Scanner(System.in);
			
			System.out.println("Enter faculty id Number:");
			int facultyid= scanner.nextInt();
			
			System.out.println("Enter faculty name:");
			String facultyname= scanner.next();
			
			System.out.println("Enter faculty address:");
			String facultyaddress= scanner.next();
			
			System.out.println("Enter faculty mobile Number:");
			String mobile= scanner.next();
			
			System.out.println("Enter faculty emai id:");
			String email= scanner.next();
			
			System.out.println("Enter faculty  username:");
			String username= scanner.next();
			
			System.out.println("Enter faculty  password:");
			int password= scanner.nextInt();
			
			AdminDao dao=new AdminDaoImpl();
			
			
			String result= dao.Creatfaculty(facultyid,facultyname,facultyaddress,mobile,email,username,password);
			
			System.out.println(result);

		}

	}

