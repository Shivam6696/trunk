package com.origin.learn.spring.sdms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component
public class StudentDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<StudentAllDetails> getDetailsList(int rollnumber)
 {
		return jdbcTemplate.query("SELECT * FROM studentdetails WHERE rollnumber = ?", new Object[] { rollnumber },
				new RowMapper<StudentAllDetails>() {

					public StudentAllDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentAllDetails alldetail = new StudentAllDetails();
						alldetail.setRollNumber(rs.getInt(1));
						alldetail.setName(rs.getString(2));
						alldetail.setSubject(rs.getString(3));
						alldetail.setObtainedMarks(rs.getInt(4));
						alldetail.setMaxMarks(rs.getInt(5));
						int  obtainMarks = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
						alldetail.setObtainedMarks(obtainMarks);
						float percentage = (((alldetail.getObtainedMarks()) * 100) / (alldetail.getMaxMarks()));
						
						System.out.println(percentage);
					
						alldetail.setPercentage((int) percentage);
						return alldetail;
					}

				});
	}
	

/*public List<Student> getStudentList(int rollnumber) {
		return jdbcTemplate.query("SELECT * FROM studentdetails WHERE rollnumber = ?", new Object[] { rollnumber },
				new RowMapper<Student>() {

					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student();
						student.setRollnumber(rs.getInt(1));
						student.setName(rs.getString(2));
						student.setFatherName(rs.getString(3));
						student.setAddress(rs.getString(4));

						return student;
					}

				});
	}

	public List<StudentMarks> getStudentMarks(int rollnumber) {
		return jdbcTemplate.query("SELECT * FROM studentmarks WHERE RollNumber = ?", new Object[] { rollnumber },
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
						int  obtainMarks = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
						marks.setObtainedmarks(obtainMarks);
						float percentage = (((marks.getObtainedmarks()) * 100) / (marks.getMaxmarks()));
						
						System.out.println(percentage);
					
						marks.setPercentage(percentage);
						return marks;
					}
			});
	}*/

}