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

	/*--------------------add new subject addSubject page mapping------------------------------ */
	@RequestMapping(value = "addsubject", method = RequestMethod.GET)
	public String subjectForm() {
		return "addSubject";

	}

	/*--------------------add new subject in table mapping------------------------------ */
	@RequestMapping(value = "newsubject", method = RequestMethod.POST)
	public Boolean addNewSubject(@RequestParam String subjectName, @RequestParam int studentrollnumber,
			@RequestParam String studentname, float obtaindmarks, int maxmarks) {

		StudentMarks sm = new StudentMarks(studentrollnumber, subjectName, studentname, obtaindmarks, maxmarks);
		Boolean lakede = studentdetails.addSubject1(sm);
		return lakede;

	}

	@RequestMapping(value = "thankyou", method = RequestMethod.POST)
	public String thankuPage() {
		return "thanku";
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
		System.out.println(studentdata.getName());
		System.out.println(studentdata.getFatherName());
		System.out.println(studentdata.getAddress());
		System.out.println(studentdata.getSubject());
		System.out.println(studentdata.getMaxmarks());
		System.out.println(studentdata.getPercentage());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("finalResult");
		modelAndView.addObject("list", list2);
		modelAndView.addObject("aa", studentdata);

		return modelAndView;

	}

	/*-------------------------------data delete mapping ----------------------------------------------------
		@RequestMapping(value = "deletepage", method = RequestMethod.POST)
		public ModelAndView studentdataDelete(@RequestParam int rollnumber) throws Exception {
			List<StudentData> studentList = studentdetails.getStudentDataDelete(rollnumber);
			StudentData studentdata = studentList.get(0);
			System.out.println(studentdata.getName());
			System.out.println(studentdata.getFatherName());
			System.out.println(studentdata.getAddress());
			System.out.println(studentdata.getSubject());
			System.out.println(studentdata.getMaxmarks());
			System.out.println(studentdata.getPercentage());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("");
			modelAndView.addObject("slist", studentList);
			return modelAndView;
	
		}*/
	/*--------------select data tp addite by rollnumber and subject method mepping---------------------*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String saveEditedMarks(@RequestParam int rollnumber, @RequestParam String subjectName,
			@RequestParam float obtainedmarks, @RequestParam String subject, @RequestParam int maxmarks) {
		/*
		 * StudentData data =
		 * studentdetails.getStudentMarksBySubjectAndRollNo(rollnumber, subjectName);
		 * data.setSubject(subjectName); data.setMaxmarks(maxmarks);
		 * data.setObtainedmarks(obtaindmarks);
		 */
		int i = studentdetails.getStudedntDataUpdate(subjectName, obtainedmarks, maxmarks, rollnumber, subject);
		System.out.println(i);
		return "finalResult";
	}

	/*--------------------add new subject fetch data psge page mapping------------------------------*/
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ModelAndView editForm(@RequestParam int rollnumber, @RequestParam String subjectName) {
		StudentData marks = studentdetails.getStudentMarksBySubjectAndRollNo(rollnumber, subjectName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editSubject");
		modelAndView.addObject("marks", marks);
		return modelAndView;
	}

	/*---------------------------recordDelete method mepping-------------------------------------*/
	@RequestMapping(value = "recordDelete", method = RequestMethod.POST)
	public String studentDataDelete(@RequestParam String subjectName,	@RequestParam int rollnumber) {
		
		int dataDelete =studentdetails.recordDelete(rollnumber,subjectName);
				return "delete";
	}
/*------------------------------back to the home page mapping-----------------------------------------------*/
	@RequestMapping(value = "homepage", method = RequestMethod.POST)
	public String homePage() {
		return "login";

	}

	/*--------------------add new subject addSubject page mapping------------------------------ 
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String subjectEdit() {
		return "editSubject";
	
	}
	
	/*--------------------add new subject in table mapping------------------------------
	@RequestMapping(value = "enter", method = RequestMethod.POST)
	public Boolean getStudedntDataEdit(@RequestParam float obtaindmarks,@RequestParam int maxmarks,@RequestParam String subjectName) {
	
		StudentMarks sm = new StudentMarks(obtaindmarks,maxmarks ,subjectName);
		Boolean updatedat = studentdetails.getStudedntDataEdit(sm);
		return updatedat;
	
	}*/

	/*--------------------add new subject in table mapping------------------------------ 
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public Boolean addNewDetails(@RequestParam String subjectName,@RequestParam  int maxmarks,@RequestParam  float obtaindmarks) {
	
		StudentMarks sd = new StudentMarks( subjectName, maxmarks, obtaindmarks);
		Boolean sdata = studentdetails.addStudentData(sd);
		return sdata;
	
	}*/

	/*
	 * @RequestMapping(value = "studentdata", method = RequestMethod.POST) public
	 * ModelAndView studentdataDelete(@RequestParam int rollnumber) {
	 * List<StudentData> list2 = studentdetails.getStudentDataDelete(rollnumber);
	 * StudentData studentdata = list2.get(0);
	 * System.out.println(studentdata.getName());
	 * System.out.println(studentdata.getFatherName());
	 * System.out.println(studentdata.getAddress());
	 * System.out.println(studentdata.getSubject());
	 * System.out.println(studentdata.getMaxmarks());
	 * System.out.println(studentdata.getPercentage()); ModelAndView modelAndView =
	 * new ModelAndView(); modelAndView.setViewName("finalResult");
	 * modelAndView.addObject("list", list2);
	 * modelAndView.addObject("aa",studentdata);
	 * 
	 * 
	 * return modelAndView;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * /*---------------------------------------------------------------------------
	 * -----------------
	 * 
	 * @RequestMapping(value = "details", method = RequestMethod.POST) public
	 * ModelAndView getStudentResult(@RequestParam int rollnumber) {
	 * List<StudentData> list2 = studentdetails.getStudentDataInfo(rollnumber);
	 * StudentData sresult = list2.get(0); System.out.println(sresult.getName());
	 * System.out.println(sresult.getFatherName());
	 * System.out.println(sresult.getAddress());
	 * System.out.println(sresult.getSubject());
	 * System.out.println(sresult.getMaxmarks());
	 * System.out.println(sresult.getPercentage()); ModelAndView modelAndView = new
	 * ModelAndView(); modelAndView.setViewName("index");
	 * modelAndView.addObject("ss", sresult);
	 * 
	 * return modelAndView;
	 * 
	 * }
	 */
}
