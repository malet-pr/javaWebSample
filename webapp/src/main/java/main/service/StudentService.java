package main.service;

import java.util.List;
import main.model.Student;

public interface StudentService{
	
	public List<Student> getAll();
 	public Student getById(int id);
	public void save(Student subject);
	public void delete(int id);
	public Student getByLastName(String name);
	public List<Student> findByLastNameLikeIgnoreCase(String term);
	
}


