package main.service;

import java.util.List;
import main.model.Subject;

public interface SubjectService{
	
	public List<Subject> getAll();
 	public Subject getById(int id);
	public void save(Subject subject);
	public void delete(int id);
	public Subject getByName(String name);
	public List<Subject> findByNameLikeIgnoreCase(String term);
	
}


