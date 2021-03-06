package main.repository;

import java.util.List;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import main.model.Professor;

@PersistenceContext
@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
	
	@Query("select p from Professor p where p.lastName <> 'TBA'")  
    public List<Professor> findByLastNameWithoutTBA();
	
	@Query("select p from Professor p where p.lastName <> 'TBA' and  p.isActive=true")  
    public List<Professor> findByLastNameWithoutTBAAndIsActive();
	
    
    @Query("select p from Professor p where p.lastName like %?1%")  
    public List<Professor> findByLastNameLikeIgnoreCase(String term);
    
    @Query("select p from Professor p where p.lastName like %?1% and  p.isActive=true")  
    public List<Professor> findByLastNameLikeIgnoreCaseAndIsActive(String term);
    
    @Query("select p from Professor p where p.isActive=true")  
    public List<Professor> getAllActive();

}
