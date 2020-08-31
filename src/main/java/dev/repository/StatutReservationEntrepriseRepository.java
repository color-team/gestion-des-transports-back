package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.StatutReservationEntreprise;

public interface StatutReservationEntrepriseRepository extends JpaRepository<StatutReservationEntreprise, Long> {
	
}
