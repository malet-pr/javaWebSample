package main.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.model.Course;
import main.repository.CourseRepository;
import main.model.Professor;
import main.repository.ProfessorRepository;

@Service
public class CourseServiceImplement implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public List<Course> getAll() {
		return courseRepository.findAll(Sort.by(Sort.Direction.ASC, "code"));
	}

	@Override
	@Transactional(readOnly = true)
	public Course getById(int id) {	
		return courseRepository.getOne(id);
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
	
	/*
	@Override
	@Transactional(readOnly = true)
	public List<Professor> findByFullName(String term) {
		return professorRepository.findByFullNameLikeIgnoreCase("%" + term + "%");
	}
	*/
}
