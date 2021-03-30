package main.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import main.model.Professor;
import main.repository.ProfessorRepository;

@Service
@Transactional
public class ProfessorServiceImplement implements ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public List<Professor> getAll() {
		return professorRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
	}

	@Override
	public Professor getById(int id) {	
		return professorRepository.getOne(id);
	}

	@Override
	public void save(Professor professor) {
		professorRepository.save(professor);
	}

	@Override
	public void delete(int id) {
		professorRepository.deleteById(id);
	}

	@Override
	public Professor findByFullName(String lastName) {
		return professorRepository.findByFullName(lastName);
	}

	@Override
	public List<Professor> findByFullNameLikeIgnoreCase(String lastName) {
		return professorRepository.findByFullNameLikeIgnoreCase(lastName);
	}
	
}