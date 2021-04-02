package main.repository;

import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.model.UserSys;

@PersistenceContext
@Repository
public interface UserSysRepository extends JpaRepository<UserSys,Integer> {
	
	public UserSys getByUsername(String username);
 	
}
