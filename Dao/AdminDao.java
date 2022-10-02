package com.masai.Dao;

import java.util.List;
import com.masai.bean.Batch;
import com.masai.bean.Course;
import com.masai.bean.CoursePlan;
import com.masai.bean.Faculty;
import com.masai.exseption.BatchException;
import com.masai.exseption.CoursPlanException;
import com.masai.exseption.CourseException;
import com.masai.exseption.FacultyException;

public interface AdminDao {
   
   public String AdminLogin(String username,int passwrod);
   
   public String ManageAdministator(String username,int passwrod);
   
   public String FacultyLogin(String username,int passwrod); 
   
   public String CreatCourse(int courseid, String courseName, int fee, String courseDescription);
	
   public List<Course> getAllCourseDetails()throws CourseException;
   
   public String Creatfaculty(int facultyid, String facultyname, String facultyaddress,
		   String mobile, String email, String username, int password);
   
   public List<Faculty> getAllFacultyDetails()throws FacultyException;
   
   public String CreatBatch(int batchId, int courseId, int facultyId,
		   int numberofStudents, String  dabatchstartDate,String duration);
   
   public List<Batch> getAllBatchDetails()throws BatchException;
   
   
   public String CreatCoursePlan(int planId, int batchId, int daynumber, String topic,String status);
   
   public List<CoursePlan> getAllCoursPlanDetails()throws CoursPlanException;
   
   public String UpadateFacultyPassword(String username,int passwrod);
}


