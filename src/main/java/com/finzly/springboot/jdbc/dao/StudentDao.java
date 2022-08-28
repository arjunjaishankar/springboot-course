package com.finzly.springboot.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.finzly.springboot.jdbc.ConnectionProvider;
import com.finzly.springboot.jdbc.model.Student;

@Repository
public class StudentDao {

	private Connection con;
	private String query;
	private Statement st;

	public StudentDao() throws SQLException {
		con = ConnectionProvider.getConnection();
		st = con.createStatement();
	}

	// Add student data
	public void createStundent(Student stu) throws SQLException {
		query = "insert into student(id,name,department) values(" + stu.getId() + ",'" + stu.getName() + "','"
				+ stu.getDepartment() + "')";
		st.executeUpdate(query);
	}

	// delete student data
	public void deleteStundent(int id) throws SQLException {
		query = "delete from student where id = " + id;
		st.executeUpdate(query);
	}

	// update student data
	public void updateStudent(Student stu) throws SQLException {
		query = "update student set name ='" + stu.getName() + "', department = '" + stu.getDepartment()
				+ "' where id = " + stu.getId();
		st.executeUpdate(query);
	}

	// get single student data
	public Student getStudent(int id) throws SQLException {
		query = "select * from student where id = " + id;
		ResultSet rs = st.executeQuery(query);
		Student stu = new Student();
		if (rs != null) {
			while (rs.next()) {
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setDepartment(rs.getString("department"));
			}
			return stu;
		}
		return null;
	}

	// get all student data.
	public ArrayList<Student> getAllStudent() throws SQLException {
		query = "select * from student";
		ResultSet rs = st.executeQuery(query);
		ArrayList<Student> students = new ArrayList<>();
		if (rs != null) {
			while (rs.next()) {
				Student stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setDepartment(rs.getString("department"));
				students.add(stu);
			}
			return students;
		}
		return null;
	}

}
