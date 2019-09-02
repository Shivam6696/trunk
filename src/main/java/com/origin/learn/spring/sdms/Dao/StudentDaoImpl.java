package com.origin.learn.spring.sdms.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.origin.learn.spring.sdms.student.*;

public class StudentDaoImpl implements StudentDao {

					protected static final int id = 0;
					private JdbcTemplate jdbcTemp;

		public StudentDaoImpl(DataSource dataSource) {
			jdbcTemp = new JdbcTemplate(dataSource);
		}

		@Override
		public List<Student> studentList() {
			List<Student> list = jdbcTemp.query("SELECT * FROM student", new RowMapper<Student>() {

				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
					Student emp = new Student();
					emp.setId(id);
					emp.setName(rs.getString("Name"));
					emp.setFather_Name(rs.getString("Father_Name"));
					emp.setAddress(rs.getString("Address"));
					

					return emp;
				}

			});

			return list;
		}

	}

