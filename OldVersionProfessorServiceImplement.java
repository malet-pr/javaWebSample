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
public class OldVersionProfessorServiceImplement implements ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Professor> getAll() {
		return (List<Professor>) professorRepository.findAll(Sort.by(Sort.Direction.ASC, "fullName"));
	}

	@Override
	@Transactional(readOnly = true)
	public Professor getById(int id) {	
		return professorRepository.findById(id).orElse(null);
	}

	@Override
	public void save(Professor professor) {
		//professorRepository.save(professor);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		try {
			  em.getTransaction().begin();
			  em.persist(professor);
			  em.getTransaction().commit();
			} 
			catch (Exception e) {
			  e.printStackTrace();
			} 
			finally {
			  em.close();
			}
	}

	@Override
	public void delete(int id) {
		//professorRepository.deleteById(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		Professor p = professorRepository.findById(null).orElse(null);
	    try {
	        em.getTransaction().begin();  
	        Professor professor=em.merge(p);
	        em.remove(professor);
	        em.getTransaction().commit();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    } 
	    finally {
	        em.close();
	    }	
	}

	@Override
	@Transactional(readOnly = true)
	public Professor findByFullName(String lastName) {
		return professorRepository.findByFullName(lastName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Professor> findByFullNameLikeIgnoreCase(String lastName) {
		return professorRepository.findByFullNameLikeIgnoreCase(lastName);
	}
	
}
