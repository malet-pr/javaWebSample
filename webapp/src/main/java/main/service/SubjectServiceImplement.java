package main.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import main.model.Subject;
import main.repository.SubjectRepository;

@Service
public class SubjectServiceImplement implements SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAll() {
		return subjectRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	@Override
	public Subject getById(int id) {	
		return subjectRepository.getOne(id);
	}

	@Override
	public void save(Subject subject) {
		subjectRepository.save(subject);
	}

	@Override
	public void delete(int id) {
		subjectRepository.deleteById(id);
	}

}
