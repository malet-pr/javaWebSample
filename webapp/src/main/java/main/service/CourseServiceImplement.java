package main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.model.Course;
import main.repository.CourseRepository;

@Service
public class CourseServiceImplement implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course getById(int id) {
		return courseRepository.getOne(id);
	}

	@Override
	public void save(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void delete(int id) {
		courseRepository.deleteById(id);
	}

}
