package main.repository;

import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import main.model.Course;

@PersistenceContext
@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    
}
