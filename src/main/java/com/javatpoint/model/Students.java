package com.javatpoint.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Students {
@Id
@Column
private int studentId;
@Column
private String studentName;

public int getId()
{
	return studentId;
}

public void setStudentId(int stId) {
	this.studentId = stId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}



	
}
