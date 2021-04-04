package main.service;

import java.util.List;
import main.model.Professor;

public interface ProfessorService{
	
	public List<Professor> getAll();
 	public Professor getById(int id);
	public void save(Professor professor);
	public void delete(int id);
	public List<Professor> findByLastNameLikeIgnoreCase(String term);
	public List<Professor> findByLastNameLikeIgnoreCaseAndIsActive(String term);
	public List<Professor> findByLastNameWithoutTBA();
	public List<Professor> findByLastNameWithoutTBAAndIsActive();

}


