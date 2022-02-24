package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;  
import com.javatpoint.model.Students;  

public interface StudentsRepository extends CrudRepository<Students, Integer>{
	
}
