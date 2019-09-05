package com.origin.learn.spring.sdms.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
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

	/*
	 * public List<StudentAllDetails> getDetailsList(int rollnumber) { return
	 * jdbcTemplate.query("SELECT * FROM studentdetails WHERE rollnumber = ?", new
	 * Object[] { rollnumber }, new RowMapper<StudentAllDetails>() {
	 * 
	 * public StudentAllDetails mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { StudentAllDetails student = new StudentAllDetails();
	 * student.setRollNumber(rs.getInt(1)); student.setName(rs.getString(2));
	 * student.setSubject(rs.getString(3)); student.setObtainedMarks(rs.getInt(4));
	 * student.setMaxMarks(rs.getInt(5)); student.setPercentage(rs.getInt(6));
	 * 
	 * return student; }
	 * 
	 * }); }
	 * 
	 */

	/*---------------------------student data info in diff - diff- table method--------------------------------*/
	public List<StudentData> getStudentDataInfo(int rollnumber) {
		return jdbcTemplate.query("SELECT * FROM newstudent WHERE rollnumber = ?", new Object[] { rollnumber },
				new RowMapper<StudentData>() {

					@Override
					public StudentData mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentData result = new StudentData();
						result.setRollnumber(rs.getInt(2));
						result.setName(rs.getString(3));
						result.setFatherName(rs.getString(4));
						result.setAddress(rs.getString(5));
						result.setSubject(rs.getString(6));
						result.setObtainedmarks(rs.getInt(7));
						result.setMaxmarks(rs.getInt(8));
						/*int obtainMarks = rs.getInt(5) + rs.getInt(6) + rs.getInt(7);
						result.setObtainedmarks(obtainMarks);
						float percentage = (((result.getObtainedmarks()) * 100) / (result.getMaxmarks()));
*/   					result.setPercentage(rs.getInt(9));
						return result;
					}
				});
	}

	/*---------------------------student details method--------------------------------*/
	public List<Student> getStudentList(int rollnumber) {
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

	/*---------------------------student marks details method--------------------------------*/
	public List<StudentMarks> getStudentMarks(int rollnumber) {
		return jdbcTemplate.query("SELECT * FROM studentmarks WHERE RollNumber = ?", new Object[] { rollnumber },
				new RowMapper<StudentMarks>() {

					@Override
					public StudentMarks mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentMarks marks = new StudentMarks(null);
						marks.setRollnumber(rs.getInt(1));
						marks.setMaths(rs.getInt(2));
						marks.setEnglish(rs.getInt(3));
						marks.setHindi(rs.getInt(4));
						marks.setScience(rs.getInt(5));
						marks.setMaxmarks(rs.getInt(6));
						int obtainMarks = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
						marks.setObtainedmarks(obtainMarks);
						float percentage = (((marks.getObtainedmarks()) * 100) / (marks.getMaxmarks()));

						System.out.println(percentage);

						marks.setPercentage(percentage);
						return marks;
					}
				});
	}

	/*---------------------------student insert  new subject in table method --------------------------------*/
	public Boolean addSubject1(StudentMarks sub) {
		return jdbcTemplate.execute("INSERT INTO allstudentdetails(Subject) VALUES(?)",
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, sub.getSubject());
						return ps.execute();
					}

				});
	}
	/*-------------------------------------------------------------------------------------------------------*/
	public List<StudentData> getStudentResult(int rollnumber) {
		return jdbcTemplate.query("SELECT * FROM studentdetails WHERE rollnumber = ?", new Object[] { rollnumber },
				new RowMapper<StudentData>() {

					public StudentData mapRow(ResultSet rs, int rowNum) throws SQLException {
						StudentData st = new StudentData();
						st.setRollnumber(rs.getInt(1));
						st.setName(rs.getString(2));
						st.setFatherName(rs.getString(3));
						st.setAddress(rs.getString(4));
						st.setSubject(rs.getString(5));
						st.setMaxmarks(rs.getInt(6));
						st.setPercentage(rs.getInt(7));
						return st;
					}

				});
	}

}