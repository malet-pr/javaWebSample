package main.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import main.model.Subject;
import main.repository.SubjectRepository;

@Service
@Transactional
public class SubjectServiceImplement implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Subject> getAll() {
		return (List<Subject>) subjectRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	@Transactional(readOnly = true)
	public Subject getById(int id) {	
		return subjectRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	@Override
	@Transactional
	public void delete(int id) {
		subjectRepository.deleteById(id);	
	}

	@Override
	@Transactional(readOnly = true)
	public Subject getByName(String name) {
		return subjectRepository.getByName(name);
	}

	@Override
	public List<Subject> findByNameLikeIgnoreCase(String term) {
		return subjectRepository.findByNameLikeIgnoreCase(term);
	}

}
