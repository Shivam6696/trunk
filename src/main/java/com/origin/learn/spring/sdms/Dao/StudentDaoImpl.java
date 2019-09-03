package com.origin.learn.spring.sdms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.origin.learn.spring.sdms.student.Student;
import com.origin.learn.spring.sdms.student.StudentMarks;

public class StudentDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> getStudentList(int rollnumber) {
		return jdbcTemplate.query("Select * from Students where rollnumber = ?", new Object[] { rollnumber },
				new RowMapper<Student>() {

					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						student.setRollnumber(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setFather_Name(rs.getString(3));
						student.setAddress(rs.getString(4));

						return student;
					}

				});
	}

	public List<StudentMarks> getStudentMarks(int rollnumber) {
		return jdbcTemplate.query("Select * from StudentMarks where StuRollNo = ?", new Object[] { rollnumber },
				new RowMapper<StudentMarks>() {

					@Override
					public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentMarks marks = new StudentMarks();
						marks.setRollnumber(rs.getInt(1));
						marks.setMaths(rs.getInt(2));
						marks.setEnglish(rs.getInt(3));
						marks.setHindi(rs.getInt(4));
						marks.setScience(rs.getInt(5));
						marks.setMaxmarks(rs.getInt(6));
						float obtainMarks = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5) + rs.getInt(6);
						marks.setObtainedmarks(obtainMarks);
						float percentage = (((marks.getObtainedmarks()) * 100) / (marks.getMaxmarks()));
						Float per = percentage;
						String s = per.toString();
						String s1 = s.substring(0, 5);
						Float pers = Float.parseFloat(s1);
						float percentage1 = pers.floatValue();
						marks.setPercentage(percentage1);
						return marks;
					}
			});
	}

}