package com.origin.learn.spring.sdms;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.origin.learn.spring.sdms.Dao.StudentDao;
import com.origin.learn.spring.sdms.student.Student;

@Controller
@RequestMapping("/login")
public class StudentCtrl {

		@Autowired
		private StudentDao studentDao;

		@RequestMapping(value = "/fetch")
		public ModelAndView listStudent(ModelAndView model) throws IOException {

			List<Student> listStudent = studentDao.studentList();
			model.addObject("listStudent", listStudent);
			model.setViewName("index");

			return model;
		}
	
}
