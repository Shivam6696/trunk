package com.origin.learn.spring.sdms.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentCtrl {

	@Autowired
	StudentDaoImpl studentdetails;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginpage() {
		return "login";
	}

	/*
	 * @RequestMapping(value = "details", method = RequestMethod.POST) public
	 * ModelAndView studentDetailsPage(@RequestParam int rollnumber) { 
	 * List<Student>
	 * list = studentdetails.getStudentList(rollnumber); List<StudentMarks> list1 =
	 * studentdetails.getStudentMarks(rollnumber);
	 * 
	 * Student studentDetails = list.get(0);
	 * System.out.println(studentDetails.getName()); StudentMarks studentMarks =
	 * list1.get(0); System.out.println(studentMarks);
	 * System.out.println(studentMarks.getMaxmarks());
	 * System.out.println(studentMarks.getObtainedmarks());
	 * System.out.println(studentMarks.getPercentage()); ModelAndView modelAndView =
	 * new ModelAndView(); modelAndView.setViewName("index");
	 * modelAndView.addObject("sd", studentDetails); modelAndView.addObject("sm",
	 * studentMarks); return modelAndView;
	 */

	@RequestMapping(value = "alldetails", method = RequestMethod.POST)
	public ModelAndView studentDetailsPage(@RequestParam int rollnumber) {
		List<StudentAllDetails> list = studentdetails.getDetailsList(rollnumber);
	
		StudentAllDetails allDetails = list.get(1);
		System.out.println(allDetails);
		System.out.print(allDetails.getName());
		System.out.print(allDetails.getSubject());
		System.out.print(allDetails.getObtainedMarks());
		System.out.print(allDetails.getMaxMarks());
		System.out.println(allDetails.getPercentage());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("allDetails");
		modelAndView.addObject("st", allDetails);
				return modelAndView;

	}
}
