package main.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import main.model.Student;
import main.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImplement implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Student> getAll() {
		return (List<Student>) studentRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	@Transactional(readOnly = true)
	public Student getById(int id) {	
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	@Transactional
	public void delete(int id) {
		studentRepository.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Student getByLastName(String name) {
		return studentRepository.getByLastName(name);
	}

	@Override
	public List<Student> findByLastNameLikeIgnoreCase(String term) {
		return studentRepository.findByLastNameLikeIgnoreCase(term);
	}

}
