package ch.bfh.bti7081.s2018.yellow.health.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.bfh.bti7081.s2018.yellow.health.models.Historyentry;

@Repository
public interface HistoryEntryRepository extends JpaRepository<Historyentry, Long>{

}
