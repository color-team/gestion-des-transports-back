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
    
    @Query("select new dev.controller.dto.ChauffeurDto(u.id, u.nom, u.prenom, u.matricule, u.email)"+" from Utilisateur u inner join RoleUtilisateur r on r.utilisateur=u where r.role=:role")
    List<ChauffeurDto> findByRole(@Param("role") String role);

}
