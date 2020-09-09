package dev.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.ReservationChauffeur;
import dev.domain.enumeration.StatutReservationEntrepriseEnum;

public interface ReservationChauffeurRepository extends JpaRepository<ReservationChauffeur, Long> {

	@Query("select r from ReservationChauffeur r join r.passager p where p.matricule = :matricule")
	List<ReservationChauffeur> findByPassagerMatricule(@Param("matricule") String matricule);
	
	@Query("select r from ReservationChauffeur r join r.chauffeur c where c.matricule = :matricule")
	List<ReservationChauffeur> findByChauffeurMatricule(@Param("matricule") String matricule);

	List<ReservationChauffeur> findByDateDepartAfter(LocalDateTime now);
	
	@Query("select r from ReservationChauffeur r join r.statutReservationEntreprise s where "
			+ "s.statutReservationEntreprise = :statut")
	List<ReservationChauffeur> findByStatutReservationEntreprise(
			@Param("statut") StatutReservationEntrepriseEnum statut);
	
}
