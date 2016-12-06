package com.hnxyhcz.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.hnxyhcz.jdbc.dao.StudentDao;
import com.hnxyhcz.jdbc.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addStudent(Student student) {
		String INSERT_SQL = "insert into student values(null, ?, ?)";
		Object params[] = new Object[]{student.getName(), student.getAge()};
		int i = jdbcTemplate.update(INSERT_SQL, params);
		return i;
	}

	@Override
	public int updateStudent(Student student) {
		String UPDATE_SQL = "update student set name = ?, age = ? where id = ?";
		Object params[] = new Object[]{student.getName(), student.getAge(), student.getId()};
		return jdbcTemplate.update(UPDATE_SQL, params);
	}

	@Override
	public int deleteStudent(int id) {
		String DELETE_SQL = "delete from student where id = ?";
		Object params[] = new Object[]{id};
		return jdbcTemplate.update(DELETE_SQL, params);
	}

	@Override
	public List<Student> findStudent() {
		String FIND_SQL = "select * from student";
		final List<Student> list = new ArrayList<Student>();
		jdbcTemplate.query(FIND_SQL, new RowCallbackHandler(){

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
