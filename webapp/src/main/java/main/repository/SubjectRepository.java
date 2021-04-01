package main.repository;

import java.util.List;

import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.model.Subject;

@PersistenceContext
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

	public Subject getByName(String term);
    
    @Query("select s from Subject s where s.name like %?1%")  
    public List<Subject> findByNameLikeIgnoreCase(String term);
	
}
