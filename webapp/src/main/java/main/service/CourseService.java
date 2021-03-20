package main.service;

import java.util.List;
import main.model.Course;

public interface CourseService{
	
	public List<Course> getAll();
	public Course getById(String id);
	public void save(Course course);
	public void delete(String id);
	
}
