package com.origin.learn.spring.sdms.Dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentCtrl {

	@Autowired
	StudentDaoImpl studentdetails;

	/**-------------------controller mapping for login page------------------------------ */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginpage() {
		return "login";
	}

	/**--------------------one student details by rollnumber mapping------------------------------ */
	
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

	/**--------------------add new subject addSubject page mapping------------------------------ */
	@RequestMapping(value = "addsubject", method = RequestMethod.GET)
	public String subjectForm() {
		return "addSubject";

	}

	/**--------------------add new subject in table mapping------------------------------ */
	@RequestMapping(value = "newsubject", method = RequestMethod.POST)
	public Boolean addNewSubject(@RequestParam String subjectName, @RequestParam int studentrollnumber,
			@RequestParam String studentname, float obtaindmarks, int maxmarks) {

		StudentMarks sm = new StudentMarks(studentrollnumber, subjectName, studentname, obtaindmarks, maxmarks);
		Boolean lakede = studentdetails.addSubject1(sm);
		return lakede;

	}
	
	/**-----------------------always return thank you page-mapping method-----------------------*/
	@RequestMapping(value = "thankyou", method = RequestMethod.POST)
	public String thankuPage() {
		return "thanku";
	}

	/**--------------------add new subject page mapping------------------------------ */
	@RequestMapping(value = "enter", method = RequestMethod.GET)
	public String infoPage() {

		return "rollPage";

	}

	/**-------------------student data mapping------------------------------ */
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

	
	/**--------------select data tp addite by rollnumber and subject method mepping---------------------*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String saveEditedMarks(@RequestParam int rollnumber, @RequestParam String subjectName,
			@RequestParam float obtainedmarks, @RequestParam String subject, @RequestParam int maxmarks) {
		
		int i = studentdetails.getStudedntDataUpdate(subjectName, obtainedmarks, maxmarks, rollnumber, subject);
		System.out.println(i);
		return "finalResult";
	}

	/**--------------------add new subject fetch data psge page mapping------------------------------*/
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ModelAndView editForm(@RequestParam int rollnumber, @RequestParam String subjectName) {
		StudentData marks = studentdetails.getStudentMarksBySubjectAndRollNo(rollnumber, subjectName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editSubject");
		modelAndView.addObject("marks", marks);
		return modelAndView;
	}

	/**--------------------------recordDelete method mepping-------------------------------------*/
	@RequestMapping(value = "recordDelete", method = RequestMethod.POST)
	public String studentDataDelete(@RequestParam String subjectName,	@RequestParam int rollnumber) {
		
		int dataDelete =studentdetails.recordDelete(rollnumber,subjectName);
				return "delete";
	}
/**------------------------back to the home page mapping-------------------------------------*/
	@RequestMapping(value = "homepage", method = RequestMethod.POST)
	public String homePage() {
		return "login";

	}
	/**------------------------------back to the home from thanku page---------------------------------*/
	@RequestMapping(value = "home", method = RequestMethod.POST)
	public String home() {
		return "login";

	}
	/**--------------------------click a insert excel button -----------------------------------------------------*/
	
	@RequestMapping(value = "uploadfile", method = RequestMethod.POST)
	public String filePage() {
		return "fileupload";

	}

	/**------------------------------insert a excel into database-----------------------------*/
	@RequestMapping(value = "loadExcel", method = RequestMethod.POST)
	public String uploadExcel(@RequestParam MultipartFile mf) {
		File file = new File("D:\\excel\\New", mf.getOriginalFilename());
		try {
			mf.transferTo(file);
			List<StudentData> list = studentdetails.readFile(file);
			int[] i =studentdetails.saveExcelToDatabase(list);
			System.out.println(i[0]);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "thanku";
	}

	/*-----------------------------printa data in  json form -method mapping--------------------------*/
	@RequestMapping(value = "json", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Student getRoll(@RequestParam int rollnumber) {
		System.out.println(rollnumber);
		List<Student> list = studentdetails.getStudentList(rollnumber);
		List<StudentMarks> list1 = studentdetails.getStudentMarks(rollnumber);
		Student studentDetails = list.get(0);
		System.out.println(studentDetails.getName());
		return studentDetails;
	}
	
/**------------------------------------------------------------------------------------------------
 * 
 *
	@RequestMapping(value = "rollpage", method = RequestMethod.GET) 
	public String rollnoPage()
	{   try {   
		details.getFileStream();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
			return "RollNoPage";
	}
	*/
}
