package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.StatutReservationCovoiturage;

public interface StatutReservationCovoiturageRepository extends JpaRepository<StatutReservationCovoiturage, Long> {
	
}
