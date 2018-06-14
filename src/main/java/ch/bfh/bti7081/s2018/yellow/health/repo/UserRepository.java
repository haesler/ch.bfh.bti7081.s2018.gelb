package ch.bfh.bti7081.s2018.yellow.health.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.bfh.bti7081.s2018.yellow.health.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select password from User where username = ?1")
	String findPassword(String Username);

	@Query("select username from User where username = ?1")
	String checkUsername(String Username);
	

}