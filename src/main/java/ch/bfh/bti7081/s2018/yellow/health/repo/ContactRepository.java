package ch.bfh.bti7081.s2018.yellow.health.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ch.bfh.bti7081.s2018.yellow.health.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	//https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html

	@Query("select u from Contact u where u.firstname like %?1%")
	List<Contact> findByFirstname(String firstname);
	
	@Query("select u from Contact u where u.lastname like %?1%")
	List<Contact> findByLastname(String lastname);
	
	@Query("select u from Contact u where u.city like %?1%")
	List<Contact> findByCity(String city);
	
	@Query("select u from Contact u where u.street like %?1%")
	List<Contact> findByStreet(String street);
}
