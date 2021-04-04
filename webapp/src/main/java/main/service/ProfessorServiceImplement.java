package main.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.model.Course;
import main.model.Professor;
import main.repository.ProfessorRepository;

@Service
public class ProfessorServiceImplement implements ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Professor> getAll() {
		return (List<Professor>) professorRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@Override
	@Transactional(readOnly = true)
	public Professor getById(int id) {	
		return professorRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Professor professor) {
		professorRepository.save(professor);
	}

	@Override
	@Transactional
	public void delete(int id) {
		professorRepository.deleteById(id);	
	}

	@Override
	public List<Professor> findByLastNameLikeIgnoreCase(String term) {
		return professorRepository.findByLastNameLikeIgnoreCase(term);
	}

	@Override
	public List<Professor> findByLastNameLikeIgnoreCaseAndIsActive(String term) {
		return professorRepository.findByLastNameLikeIgnoreCaseAndIsActive(term);
	}

	@Override
	public List<Professor> findByLastNameWithoutTBA() {
		return professorRepository.findByLastNameWithoutTBA();
	}

	@Override
	public List<Professor> findByLastNameWithoutTBAAndIsActive() {
		return professorRepository.findByLastNameWithoutTBAAndIsActive();
	}
	
}
