package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.controller.dto.ChauffeurDto;
import dev.domain.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long> {
	
    Optional<Utilisateur> findByEmail(String email);
    
    List<Utilisateur> findByMatricule(String matricule);
    
    @Query("select u from Utilisateur u join u.roles r where r.role= :role")
    List<Utilisateur> findByRole(@Param("role") String role);

}
