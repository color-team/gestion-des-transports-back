package dev.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.ReservationCovoiturage;

public interface ReservationCovoiturageRepository extends JpaRepository<ReservationCovoiturage, Long> {

	@Query("select r from ReservationCovoiturage r join r.passagers p where p.matricule = :matricule")
	List<ReservationCovoiturage> findByUtilisateurMatricule(@Param("matricule") String matricule);

	List<ReservationCovoiturage> findByDateDepartAfter(LocalDateTime now);
	
}
