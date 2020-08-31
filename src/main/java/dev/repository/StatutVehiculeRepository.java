package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.StatutVehicule;

public interface StatutVehiculeRepository extends JpaRepository<StatutVehicule, Long> {
	
}
