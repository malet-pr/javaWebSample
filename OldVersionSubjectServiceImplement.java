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
public class OldVersionSubjectServiceImplement implements SubjectService {
	
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
	public void save(Subject subject) {
		//subjectRepository.save(subject);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		try {
			  em.getTransaction().begin();
			  em.persist(subject);
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
		//subjectRepository.deleteById(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		Subject s = subjectRepository.findById(null).orElse(null);
	    try {
	        em.getTransaction().begin();  
	        Subject subject=em.merge(s);
	        em.remove(subject);
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
	public Subject getByName(String name) {
		return subjectRepository.getByName(name);
	}

}
