package com.javatpoint.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import com.javatpoint.model.Students;  
import com.javatpoint.repository.StudentsRepository;

@Service
public class StudentService {
@Autowired
StudentsRepository studentsRepository;

// get all students
public List <Students> getAllStudents()
{
	List <Students> students = new ArrayList <Students>();
	studentsRepository.findAll().forEach(student -> students.add(student));
	return students;
}

// get specific student
public Students getStudentById(int id) throws Exception
{
	Students s = studentsRepository.findById(id).get();
	if(s == null) {
		throw new Exception("Element not found");
	}
	return s;
}

// save or update student
public void saveOrUpdate(Students student)
{
	studentsRepository.save(student);
}

// deleting a student
public void delete(int id) throws Exception
{
	Students s = studentsRepository.findById(id).get();
	if(s == null) {
		throw new Exception("Students already deleted");
	}
	studentsRepository.deleteById(id);
}

// update a student
public void update(Students student, int id)
{
	studentsRepository.save(student);
}


}
