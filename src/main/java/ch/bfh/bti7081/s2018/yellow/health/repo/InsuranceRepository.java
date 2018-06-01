package ch.bfh.bti7081.s2018.yellow.health.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ch.bfh.bti7081.s2018.yellow.health.models.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

}
