package main.service;

import java.util.List;
import main.model.Course;
import main.model.Professor;

public interface CourseService{
	
	public List<Course> getAll();
 	public Course getById(int id);
	public void save(Course course);
	public void delete(int id);
	//public List<Professor> findByFullName(String term);
	
}
