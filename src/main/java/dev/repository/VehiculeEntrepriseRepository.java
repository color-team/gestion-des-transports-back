package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.VehiculeEntreprise;

public interface VehiculeEntrepriseRepository extends JpaRepository<VehiculeEntreprise, Long> {
	
}
