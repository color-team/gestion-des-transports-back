package dev.repository;

import dev.domain.ReservationEntreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationEntrepriseRepository extends JpaRepository<ReservationEntreprise, Long> {
	
}
