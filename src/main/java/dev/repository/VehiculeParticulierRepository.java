package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.VehiculeParticulier;

public interface VehiculeParticulierRepository extends JpaRepository<VehiculeParticulier, Long> {
	
}
