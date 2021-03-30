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

    public Professor findByFullName(String term);
    
    @Query("select p from Professor p where p.fullName like %?1%")  
    public List<Professor> findByFullNameLikeIgnoreCase(String term);

}