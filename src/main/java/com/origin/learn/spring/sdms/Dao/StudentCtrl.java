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

	/*--------------------controller mapping for login page------------------------------ */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginpage() {
		return "login";
	}

	

	/*--------------------one student details by rollnumber mapping------------------------------ */
	@RequestMapping(value = "details", method = RequestMethod.POST)
	public ModelAndView studentDetailsPage(@RequestParam int rollnumber) {
		List<Student> list = studentdetails.getStudentList(rollnumber);
		List<StudentMarks> list1 = studentdetails.getStudentMarks(rollnumber);

		Student studentDetails = list.get(0);
		System.out.println(studentDetails.getName());
		StudentMarks studentMarks = list1.get(0);
		System.out.println(studentMarks);
		System.out.println(studentMarks.getMaxmarks());
		System.out.println(studentMarks.getObtainedmarks());
		System.out.println(studentMarks.getPercentage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("sd", studentDetails);
		modelAndView.addObject("sm", studentMarks);
		return modelAndView;

	}

	/*--------------------add new subject page mapping------------------------------ */
	@RequestMapping(value = "addsubject", method = RequestMethod.GET)
	public String subjectForm() {
		return "addSubject";

	}

	/*--------------------add new subject in table mapping------------------------------ */
	@RequestMapping(value = "newsubject", method = RequestMethod.POST)
	public String addNewSubject(@RequestParam String subjectName) {

		StudentMarks sm = new StudentMarks(subjectName);
		@SuppressWarnings("unused")
		Boolean lakede = studentdetails.addSubject1(sm);
		return subjectName;

	}

	/*--------------------add new subject page mapping------------------------------ */
	@RequestMapping(value = "enter", method = RequestMethod.GET)
	public String infoPage() {
	
		return "rollPage";

	}
	/*--------------------student data mapping------------------------------ */
	@RequestMapping(value = "studentdata", method = RequestMethod.POST)
	public ModelAndView studentdatapage(@RequestParam int rollnumber) {
		List<StudentData> list2 = studentdetails.getStudentDataInfo(rollnumber);
		StudentData studentdata = list2.get(0);
		System.out.println(studentdata.getRollnumber());
		System.out.println(studentdata.getName());
		System.out.println(studentdata.getFatherName());
		System.out.println(studentdata.getAddress());
		System.out.println(studentdata.getSubject());
		System.out.println(studentdata.getMaxmarks());
		System.out.println(studentdata.getPercentage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("finalResult");
		modelAndView.addObject("ss", studentdata);

		return modelAndView;

	}
	
	/*--------------------------------------------------------------------------------------------
	@RequestMapping(value = "details", method = RequestMethod.POST)
	public ModelAndView getStudentResult(@RequestParam int rollnumber) {
		List<StudentData> list2 = studentdetails.getStudentDataInfo(rollnumber);
		StudentData  sresult = list2.get(0);
		System.out.println(sresult.getName());
		System.out.println(sresult.getFatherName());
		System.out.println(sresult.getAddress());
		System.out.println(sresult.getSubject());
		System.out.println(sresult.getMaxmarks());
		System.out.println(sresult.getPercentage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("ss", sresult);

		return modelAndView;

}*/
}
