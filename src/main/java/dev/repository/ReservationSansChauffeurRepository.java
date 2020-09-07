package dev.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.ReservationSansChauffeur;

public interface ReservationSansChauffeurRepository extends JpaRepository<ReservationSansChauffeur, Long> {
	
	@Query("select r from ReservationSansChauffeur r join r.conducteur c where c.matricule = :matricule")
	List<ReservationSansChauffeur> findByConducteurMatricule(@Param("matricule") String matricule);

	List<ReservationSansChauffeur> findByDateDepartAfter(LocalDateTime now);
	
}
