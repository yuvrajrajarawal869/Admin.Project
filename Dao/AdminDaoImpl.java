package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exseption.BatchException;
import com.masai.exseption.CoursPlanException;
import com.masai.exseption.CourseException;
import com.masai.exseption.FacultyException;
import com.masai.utility.DBUtil;



public class AdminDaoImpl implements AdminDao{

	@Override
	public String AdminLogin(String username, String passwrod) {
        
       String massageString = "wrong password or username";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
            PreparedStatement pStatement = conn.prepareStatement("select * from Admin where password =? And username =?");
			
			pStatement.setString(1, passwrod);
			pStatement.setString(2,username);
			
			ResultSet resultSet = pStatement.executeQuery();
			
			if(resultSet.next())
				massageString = "loged Sucessfully.. ";
		} catch (Exception e) {
			massageString = e.getMessage();
		}
		return massageString;
	}
	
	
	@Override
	public String ManageAdministator(String username, String passwrod) {
		String massageString = "Not Upadated....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
           PreparedStatement pStatement = conn.prepareStatement("UPDATE Admin SET password =? WHERE username =?");
			
			pStatement.setString(1, passwrod);
			pStatement.setString(2,username);
			
			int x = pStatement.executeUpdate();
			
			if(x > 0)
				massageString = "password Changed Sucessfully.. ";
 				
		} catch (Exception e) {
			massageString = e.getMessage();
		}
		return massageString;
	}


	@Override
	public String FacultyLogin(String username, String passwrod) {
		 String massageString = "wrong password or username";
			
			try(Connection conn = DBUtil.provideConnection()) {
				
				
	            PreparedStatement pStatement = conn.prepareStatement("select * from Admin where password =? And username =?");
				
				pStatement.setString(1, passwrod);
				pStatement.setString(2,username);
				
				ResultSet resultSet = pStatement.executeQuery();
				
				if(resultSet.next())
					massageString = "loged Sucessfully.. ";
			} catch (Exception e) {
				massageString = e.getMessage();
			}
			return massageString;
		
	}


	@Override
	public String CreatCourse(int courseid, String courseName, int fee, String courseDescription) {
		
			String message = "Not Inserted..";
			
			try(Connection conn= DBUtil.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement
						("insert into course(courseid,courseName,fee,courseDescription) values(?,?,?,?)");
				
				ps.setInt(1,courseid);
				ps.setString(2, courseName);
				ps.setInt(3, fee);
				ps.setString(4, courseDescription);
				
				int x= ps.executeUpdate();
				
				
				if(x > 0)
					message = "Student Registered Sucessfully !";
				
				
				
			} catch (SQLException e) {
				message = e.getMessage();
			}
			
			return message;
		}


	@Override
	public List<Course> getAllCourseDetails() throws CourseException {
       List<Course> courses= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Course");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("courseid");
				String n= rs.getString("courseName");
				int m= rs.getInt("fee");
				String e= rs.getString("courseDescription");
				
			Course course=new Course(r, n, m, e);	
				
			courses.add(course);
				
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		
		if(courses.size() == 0)
			throw new CourseException("No Student found..");
		
		return courses;
	}


	@Override
	public String Creatfaculty(int facultyid, String facultyname, String facultyaddress, 
			String mobile, String email,String username, int password) {
		
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
         PreparedStatement ps= conn.prepareStatement
					("insert into faculty(facultyid,facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?,?)");
            ps.setInt(1,facultyid);
			ps.setString(2,facultyname);
			ps.setString(3, facultyaddress);
			ps.setString(4, mobile);
			ps.setString(5, email);
			ps.setString(6, username);
			ps.setInt(7, password);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Faculty Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}


	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
        List<Faculty> Facultys= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Faculty");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("facultyid");
				String n= rs.getString("facultyname");
				String m= rs.getString("facultyaddress");
				String e= rs.getString("mobile");
				String f= rs.getString("email");
				String g= rs.getString("username");
				int h= rs.getInt("password");
				
			Faculty faculty=new Faculty(r, n, m, e, f, g, h);	
				
			Facultys.add(faculty);
				
			}
			
		} catch (SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		
		
		if(Facultys.size() == 0)
			throw new FacultyException("No Facultys found..");
		
		return Facultys;
	}


	@Override
	public String CreatBatch(int batchId, int courseId, int facultyId, 
			int numberofStudents, String batchstartDate,String duration) {
         String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
         PreparedStatement ps= conn.prepareStatement
					("insert into batch(batchId,courseId,facultyId,numberofStudents,"
							+ "batchstartDate,duration) values(?,?,?,?,?,?)");
            ps.setInt(1,batchId);
			ps.setInt(2,courseId);
			ps.setInt(3, facultyId);
			ps.setInt(4, numberofStudents);
			ps.setString(5, batchstartDate);
			ps.setString(6, duration);
			
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "batch upadated Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}


	@Override
	public List<Batch> getAllBatchDetails() throws BatchException {
		
           List<Batch> Batchs= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from Batch");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int r= rs.getInt("batchId");
				int n= rs.getInt("courseId");
				int m= rs.getInt("facultyId");
				int e= rs.getInt("numberofStudents");
				String f= rs.getString("batchstartDate");
				String g= rs.getString("duration");
				
				
			Batch batch=new Batch(r, n, m, e, f, g);	
				
			Batchs.add(batch);
				
			}
			
		} catch (SQLException e) {
			throw new BatchException(e.getMessage());
		}
		
		
		if(Batchs.size() == 0)
			throw new BatchException("No Batch found..");
		
		return Batchs;	
		
	}


	@Override
	public String CreatCoursePlan(int planId, int batchId, int daynumber, String topic, String status) {
		
		String message = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into CoursPlan(planId,batchId,daynumber,topic,status) values(?,?,?,?,?)");
			
			ps.setInt(1,planId);
			ps.setInt(2, batchId);
			ps.setInt(3, daynumber);
			ps.setString(4, topic);
			ps.setString(5, status);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Course Plan Created Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}


	@Override
	public List<CoursePlan> getAllCoursPlanDetails() throws CoursPlanException {
		  List<CoursePlan> Cp= new ArrayList<>();
			
			
			try(Connection conn= DBUtil.provideConnection()) {
				
				PreparedStatement ps= conn.prepareStatement("select * from coursplan");
				
				ResultSet rs= ps.executeQuery();
				
				while(rs.next()) {
					
					
					int r= rs.getInt("planId");
					int n= rs.getInt("batchId");
					int m= rs.getInt("daynumber");
					String e= rs.getString("topic");
					String f= rs.getString("status");
					
					
					
				CoursePlan b = new CoursePlan(r, n, m, e, f);	
					
				Cp.add(b);
					
				}
				
			} catch (SQLException e) {
				throw new CoursPlanException(e.getMessage());
			}
			
			
			if(Cp.size() == 0)
				throw new CoursPlanException("No plan found..");
			
			return Cp;
	}


	@Override
	public String UpadateFacultyPassword(String username, String passwrod) {
       
		String massageString = "Not Inserted....";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
           PreparedStatement pStatement = conn.prepareStatement("UPDATE faculty SET password =? WHERE username =?");
			
			pStatement.setString(1, passwrod);
			pStatement.setString(2,username);
			
			int x = pStatement.executeUpdate();
			
			if(x > 0)
				massageString = "password Changed Sucessfully.. ";
 				
		} catch (Exception e) {
			massageString = e.getMessage();
		}
		return massageString;
	

	}
		
	  

}
		
	

