package com.origin.learn.spring.sdms;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.origin.learn.spring.sdms.Dao.StudentDaoImpl;
import com.origin.learn.spring.sdms.student.Student;
import com.origin.learn.spring.sdms.student.StudentMarks;

@Controller
public class StudentCtrl {

		@Autowired
		private StudentDaoImpl studentdetails;

		@RequestMapping(value = "login", method = RequestMethod.GET) 
		public String rollnoPage()
		{
				return "login";
		}
		@RequestMapping(value = "details", method = RequestMethod.POST)
		public ModelAndView studentDetailsPage(@RequestParam int rollnumber)
		{
		      List<Student> list = studentdetails.getStudentList(rollnumber);
		      List<StudentMarks> list1 = studentdetails.getStudentMarks(rollnumber);
		     
		      Student studentDetails =  list.get(0);
		      System.out.println(studentDetails.getName());
		      StudentMarks studentMarks = list1.get(0);
			  System.out.println(studentMarks);
			  System.out.println(studentMarks.getMaxmarks());
			  System.out.println(studentMarks.getObtainedmarks());
			  System.out.println(studentMarks.getPercentage());
			  ModelAndView modelAndView = new ModelAndView();
			  modelAndView.setViewName("DetailsMarksTable");
			  modelAndView.addObject("sd", studentDetails);
			  modelAndView.addObject("sm",studentMarks);
			  return modelAndView;
		}

		
}
