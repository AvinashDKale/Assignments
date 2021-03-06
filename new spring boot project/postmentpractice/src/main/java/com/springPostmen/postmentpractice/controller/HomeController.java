package com.springPostmen.postmentpractice.controller;
import org.springframework.web.bind.annotation.RestController;

import com.springPostmen.postmentpractice.model.Student;
import com.springPostmen.postmentpractice.serviceimplementation.StudentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin("*")
public class HomeController {
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping(value = "saveStudent")
	public Student saveStudent(@RequestBody Student student) {
		studentServiceImpl.saveStudent(student);
		System.out.println("Student saved ");
		return student;
		
	}
	
	@GetMapping(value = "getAllStudent")
	public List<Student>findAllStudent(){
	return studentServiceImpl.findAllStudent();}
	
	@PutMapping("updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentServiceImpl.updateStudent(student);}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="deleteStudent/{id}")
	//@DeleteMapping(value="deleteStudent")
	public String deleteStudent(@PathVariable int id ){
	return"Student Deleted!!!";
	}

}

