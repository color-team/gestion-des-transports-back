package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.ReservationCovoituragePassager;
import dev.domain.ReservationCovoituragePassagerKey;

public interface ReservationCovoituragePassagerRepository extends JpaRepository<ReservationCovoituragePassager, ReservationCovoituragePassagerKey> {

	@Query("select r from ReservationCovoituragePassager r join r.passager p where p.matricule = :matricule")
	List<ReservationCovoituragePassager> findByPassagerMatricule(@Param("matricule") String matricule);
	
}
