package com.masai.usecases;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;

public class UpadateFacultyPassWord {
	public static void main(String[] arg) {
		   Scanner scanner = new Scanner(System.in);
		   
		   System.out.println("Enter your user name");
		   String username = scanner.next();
		   
		   System.out.println("enter new your password");
		   int passwrod = scanner.nextInt();
		   
		   AdminDao dao = new AdminDaoImpl();
		   
		  String result = dao.UpadateFacultyPassword(username,passwrod);
		  System.out.println(result);
	}
}
