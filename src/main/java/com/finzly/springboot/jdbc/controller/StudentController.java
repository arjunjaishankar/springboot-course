package com.finzly.springboot.jdbc.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.springboot.jdbc.model.Student;
import com.finzly.springboot.jdbc.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/stu/{id}")
	public Student fetch(@PathVariable(value = "id") int id ) throws SQLException {
		return service.getStudent(id);
	}
	
	@PostMapping("/stu")
	public Student addStudent(@RequestBody Student student) throws SQLException {
		return service.createStudent(student);
	}
	
	@PutMapping("/stu/{id}")
	public Student update(@PathVariable(value = "id") int id,@RequestBody Student student) throws SQLException {
		return service.updateStudent(id,student);
	}
	
	@DeleteMapping("/stu/{id}")
	public String remove(@PathVariable(value = "id") int id) throws SQLException {
		return service.deleteStudent(id);
	}
	

}
