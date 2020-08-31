package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Localisation;

public interface LocalisationRepository extends JpaRepository<Localisation, Long> {
	
}
