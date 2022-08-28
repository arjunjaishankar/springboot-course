package com.finzly.springboot.jdbc.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.finzly.springboot.jdbc.dao.StudentDao;
import com.finzly.springboot.jdbc.model.Student;

@Service
public class StudentService {
	
	private static StudentDao statement;

	public StudentService() throws SQLException {
	  statement = new StudentDao();
	}

	public Student createStudent(Student student) throws SQLException {
		statement.createStundent(student);
		return getStudent(student.getId());
	}

	public static void getAllStudent() throws SQLException {
		ArrayList<Student> students = statement.getAllStudent();
		for (Student s : students)
			System.out.println(s);
	}

	public Student getStudent(int id) throws SQLException {
		return statement.getStudent(id);
	}

	public Student updateStudent(int id, Student student) throws SQLException {
		Student stu = statement.getStudent(id);
		stu.setDepartment(student.getDepartment());
		statement.updateStudent(stu);
		getAllStudent();
		return getStudent(id);
	}

	public String deleteStudent(int id) throws SQLException {
		statement.deleteStundent(id);
		getAllStudent();
		return "Student data deleted";
	}

}
