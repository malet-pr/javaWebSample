package main.service;

import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.model.Course;
import main.model.Student;
import main.repository.CourseRepository;
import main.repository.StudentRepository;

@Service
public class CourseServiceImplement implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Course> getAll() {
		return (List<Course>) courseRepository.findAll(Sort.by(Sort.Direction.ASC, "code"));
	}

	@Override
	@Transactional(readOnly = true)
	public Course getById(int id) {	
		return courseRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Course course) {
		courseRepository.save(course);
	}

	@Override
	@Transactional
	public void delete(int id) {
		courseRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void addStudent(int id, String username) {
		Course course = courseRepository.getOne(id);
		if(course.getStudents() == null) {
			course.setStudents(new HashSet());
		}
		Student student = studentRepository.getByNationalID(username);
		if(student != null) {
			course.getStudents().add(student);
			courseRepository.save(course);
		}
	}

}
