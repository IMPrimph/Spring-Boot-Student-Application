package com.javatpoint.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.javatpoint.model.Students;  
import com.javatpoint.service.StudentService;


@RestController
public class StudentsController {
	@Autowired
	StudentService studentService;
	
	// retrieve all students from database
	@GetMapping("/student")
	private List getAllStudents() {
		return studentService.getAllStudents();
	}
	
	// retrieve a specific student from database
	@GetMapping("/student/{studentId}")
	private ResponseEntity<?> getStudent(@PathVariable("studentId")int studentid) {
		Students s = null;
		
		try {
			s = studentService.getStudentById(studentid);
		} catch(Exception e){
			return new ResponseEntity<>("The requested student was not found!", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok().body(s);
	}
	
	// delete a student from database
	@DeleteMapping("/student/{studentId}")
	private ResponseEntity<?> deleteStudent(@PathVariable("studentId") int studentid) {
		try {
			studentService.delete(studentid);
			return new ResponseEntity<>("Student has been deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("The requested student was not found!", HttpStatus.NOT_FOUND);
		}
	}
	
	// add a student to the database
	@PostMapping("/students")
	private ResponseEntity<?> saveStudent(@RequestBody Students student) {
		studentService.saveOrUpdate(student);
//		return ResponseEntity.ok().body("Student created");
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}
	
	// update a student
	@PutMapping("/students")
	private Students update(@RequestBody Students student) {
		studentService.saveOrUpdate(student);
		return student;
	}
	
	
	
}
