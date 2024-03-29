package com.origin.learn.spring.sdms.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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

	

	/**---------------------------student data info in diff - diff- table method-------------------*/
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
						/*
						 * int obtainMarks = rs.getInt(5) + rs.getInt(6) + rs.getInt(7);
						 * result.setObtainedmarks(obtainMarks); float percentage =
						 * (((result.getObtainedmarks()) * 100) / (result.getMaxmarks()));
						 */ result.setPercentage(rs.getInt(9));
						return result;
					}
				});
	}

	/**---------------------------student details method--------------------------------*/
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

	/**--------------------------student marks details method--------------------------------*/
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
						int obtainMarks = rs.getInt(2) + rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
						marks.setObtainedmarks(obtainMarks);
						float percentage = (((marks.getObtainedmarks()) * 100) / (marks.getMaxmarks()));

						System.out.println(percentage);

						marks.setPercentage(percentage);
						return marks;
					}
				});
	}

	/**--------------------------student insert  new subject in table method --------------------------------*/
	public Boolean addSubject1(StudentMarks sub) {
		return jdbcTemplate.execute(
				"INSERT INTO allstudentdetails(RollNumber,Name,Subject,ObtainedMarks,MaxMarks) VALUES(?,?,?,?,?)",
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setInt(1, sub.getRollnumber());
						ps.setString(2, sub.getName());
						ps.setString(3, sub.getSubject());
						ps.setFloat(4, sub.getObtainedmarks());
						ps.setInt(5, sub.getMaxmarks());

						return ps.execute();
					}

				});
	}

	/**--------------------------insert new details in studentdetails table method --------------------------------*/
	public Boolean addStudentData(StudentMarks stu) {
		return jdbcTemplate.execute("INSERT INTO newstudent(Subject,MaxMarks,ObtainedMarks) VALUES(?,?,?)",
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(3, stu.getSubject());
						ps.setInt(5, stu.getMaxmarks());
						ps.setFloat(4, stu.getObtainedmarks());

						return ps.execute();
					}

				});
	}

	/**----------------------------select a data to change the records----------------------------*/
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

	
/**-----------------------------Record delete method-----------------------------------------*/
	public int recordDelete(int rollnumber, String subject) {
		String query = "DELETE FROM newstudent WHERE rollnumber = ? AND subject = ?";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Integer>() {

			@Override
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, rollnumber);
				ps.setString(2, subject);
				return ps.executeUpdate();
			}

		});
	}
	
	/**--------------------------------------data update method--------------------------------------------------------------*/

	public int getStudedntDataUpdate(String subjectName,float obtainedmarks,int maxmarks,int rollnumber,String subject) {
		return jdbcTemplate.execute("UPDATE newstudent SET subject=?,maxmarks=?, obtainmarks=? WHERE rollnumber=? AND subject = ?",
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1,subjectName);
						ps.setInt(2,maxmarks);
						ps.setFloat(3,obtainedmarks);
						ps.setInt(4,rollnumber);
						ps.setString(5 ,subject);
						return ps.executeUpdate();
					}

				});
	}
	
	
	/**-----------------fetch a data form newstudent table and change the data -----------------*/

	public StudentData getStudentMarksBySubjectAndRollNo(int rollnumber,String subject) {
		return jdbcTemplate.queryForObject("SELECT * FROM newstudent WHERE rollnumber = ? AND subject=?",
				new Object[] { rollnumber, subject }, (rs, rowNum) ->
				new StudentData(
					rs.getInt("rollnumber"),
					rs.getString("name"),
					rs.getString("fathername"),
					rs.getString("address"),
					rs.getString("subject"),
					rs.getInt("maxmarks"), 
					rs.getFloat("obtainmarks")));
	}
	
	/**---------------------------Read file method------------------------------------------------*/
	public List<StudentData> readFile(File file) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<StudentData> list = new ArrayList<>();

		try {
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("Sheet1");
			int i = sheet.getLastRowNum();

			for (int j = 1; j <= i; j++) {

				Row row = sheet.getRow(j);
				int rollnumber = (int) (row.getCell(0).getNumericCellValue());
				String name = row.getCell(1).getStringCellValue();
				float obtainedMarks = (float) (row.getCell(2).getNumericCellValue());
				int maxmarks = (int) row.getCell(3).getNumericCellValue();
				String subject = row.getCell(4).getStringCellValue();

				StudentData data= new StudentData();
				data.setRollnumber(rollnumber);
				data.setName(name);
				data.setSubject(subject);
				data.setObtainedmarks(obtainedMarks);
				data.setMaxmarks(maxmarks);
				System.out.println(data);
				list.add(data);
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}


	/**------------------------------data save excel into database--------------------------------*/
	public int[] saveExcelToDatabase(List<StudentData> list) {
		return jdbcTemplate.batchUpdate("INSERT INTO studentdata VALUES(?,?,?,?,?)", new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, list.get(i).getRollnumber());
				ps.setString(2, list.get(i).getName());
				ps.setFloat(3, list.get(i).getObtainedmarks());
				ps.setInt(4, list.get(i).getMaxmarks());
				ps.setString(5, list.get(i).getSubject());
			}

			@Override
			public int getBatchSize() {

				return list.size();
			}
		});
	}
	
	/*-----------------------------------------------------------------------------------------
	public void getFileStream() throws IOException
	{
		  try {
			Connection con = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement preparedStatement = con.prepareStatement("Select udk, gfimage from instrumentimages");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				 String udk = rs.getString("udk");
				 byte[]  is =  rs.getBytes("gfimage");
				 File f = new File("D:\\excel\\New",udk+".jpg");
				 FileOutputStream fos = new FileOutputStream(f);
				 //byte[] buffer = new byte[is.available()];
				 System.out.println(is.length);
				
				 fos.write(is);
				 fos.flush();
				 fos.close();
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	*/
}