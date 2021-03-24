package main.repository;

import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.model.Subject;

@PersistenceContext
@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {

}
