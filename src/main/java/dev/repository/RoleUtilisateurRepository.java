package dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.RoleUtilisateur;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur, Long> {
	
}
