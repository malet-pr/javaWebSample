package main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import main.model.Course;
import main.repository.CourseRepository;

@Service
public class CourseServiceImplement implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Course> getAll() {
		return courseRepository.findAll(Sort.by(Sort.Direction.ASC, "code"));
	}

	@Override
	public Course getById(String id) {	
		return courseRepository.getOne(id);
	}

	@Override
	public void save(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void delete(String id) {
		courseRepository.deleteById(id);
	}

}
