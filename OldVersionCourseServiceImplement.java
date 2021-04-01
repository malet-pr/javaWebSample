package main.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.model.Course;
import main.repository.CourseRepository;

@Service
public class OldVersionCourseServiceImplement implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Course> getAll() {
		return (List<Course>) courseRepository.findAll(Sort.by(Sort.Direction.ASC, "code"));
	}

	@Override
	@Transactional(readOnly = true)
	public Course getById(int id) {	
		return courseRepository.findById(null).orElse(null);
	}

	@Override
	public void save(Course course) {
		// courseRepository.save(course);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		try {
		  em.getTransaction().begin();
		  em.persist(course);
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
		//courseRepository.deleteById(id);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("all");
		EntityManager em = emf.createEntityManager();
		Course c = courseRepository.findById(null).orElse(null);
	    try {
	        em.getTransaction().begin();  
	        Course course=em.merge(c);
	        em.remove(course);
	        em.getTransaction().commit();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    } 
	    finally {
	        em.close();
	    }			
	}

}
