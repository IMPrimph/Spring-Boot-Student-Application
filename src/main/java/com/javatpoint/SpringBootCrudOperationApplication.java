package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javatpoint.controller.StudentsController;
import com.javatpoint.model.Students;
import com.javatpoint.repository.StudentsRepository;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = StudentsController.class)

public class SpringBootCrudOperationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}

}
