package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.domain.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
    Optional<Utilisateur> findByEmail(String email);
    
	@Query( "SELECT u FROM Utilisateur u WHERE u.matricule = :matricule")
	List<Utilisateur> findByMatricule( @Param("matricule") String matricule);
	
}
