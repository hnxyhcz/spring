package com.hnxyhcz.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hnxyhcz.jdbc.dao.StudentDao;
import com.hnxyhcz.jdbc.entity.Student;

@Repository
public class StudentDaoImpl3 implements StudentDao{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {
		String INSERT_SQL = "insert into student values(null, :name, :age)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", student.getName());
		params.addValue("age", student.getAge());
		int i = namedParameterJdbcTemplate.update(INSERT_SQL, params);
		return i;
	}

	@Override
	public int updateStudent(Student student) {
		String UPDATE_SQL = "update student set name=:name, age = :age where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", student.getId());
		params.addValue("name", student.getName());
		params.addValue("age", student.getAge());
		return namedParameterJdbcTemplate.update(UPDATE_SQL, params);
	}

	@Override
	public int deleteStudent(int id) {
		String DELETE_SQL = "delete from student where id = :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		return namedParameterJdbcTemplate.update(DELETE_SQL, params);
	}

	@Override
	public List<Student> findStudent() {
		String FIND_SQL = "select * from student";
		final List<Student> list = new ArrayList<Student>();
		namedParameterJdbcTemplate.query(FIND_SQL, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setAge(rs.getInt("age"));
				list.add(student);
			}
			
		});
		return list;
	}

}
