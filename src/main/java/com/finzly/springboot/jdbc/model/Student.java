package com.finzly.springboot.jdbc.model;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private int Id;
	
	private String name;
	
	private String department;
}

