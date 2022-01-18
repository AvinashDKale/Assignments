package com.springPostmen.postmentpractice.serviceinterface;



import java.util.List;

import com.springPostmen.postmentpractice.model.Student;

public interface StudentInterface {
	public Student saveStudent(Student student);
	public Student updateStudent(Student student);
	public List<Student>findAllStudent();
	public void deleteStudent(int ID);

}
