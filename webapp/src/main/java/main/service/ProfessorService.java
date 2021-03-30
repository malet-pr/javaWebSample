package main.service;

import java.util.List;
import main.model.Professor;

public interface ProfessorService{
	
	public List<Professor> getAll();
 	public Professor getById(int id);
	public void save(Professor professor);
	public void delete(int id);
	public Professor findByFullName(String lastName);
	public List<Professor> findByFullNameLikeIgnoreCase(String lastName);

}


