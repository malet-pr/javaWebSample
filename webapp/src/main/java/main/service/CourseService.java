package main.service;

import java.util.List;
import main.model.Course;

public interface CourseService{
	
	public List<Course> getAll();
 	public Course getById(int id);
	public void save(Course course);
	public void delete(int id);
	public void addStudent(int course_id, String username);
	
}
