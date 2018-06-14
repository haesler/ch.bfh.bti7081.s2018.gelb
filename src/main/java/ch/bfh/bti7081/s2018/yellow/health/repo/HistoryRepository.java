package ch.bfh.bti7081.s2018.yellow.health.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.bfh.bti7081.s2018.yellow.health.models.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{
	
	
	List<History> findbyPatient(int Patient);

	List<History> findPatient();

}
