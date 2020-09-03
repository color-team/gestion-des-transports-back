package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.domain.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
<<<<<<< HEAD
	
    Optional<Utilisateur> findByEmail(String email);
=======

	Optional<Utilisateur> findByEmail(String email);
>>>>>>> b43e93d... avec utilisateur connecte POST/reservations-covoiturages
    
    List<Utilisateur> findByMatricule(String matricule);
}
