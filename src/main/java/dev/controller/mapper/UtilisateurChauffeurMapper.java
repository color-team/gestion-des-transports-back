package dev.controller.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.controller.dto.ChauffeurDto;
import dev.domain.RoleUtilisateur;
import dev.domain.Utilisateur;

@Component
public class UtilisateurChauffeurMapper {	

	public ChauffeurDto toChauffeurDto( Utilisateur utilisateur) {
		return new ChauffeurDto( 
				utilisateur.getId(), 
				utilisateur.getNom(), 
				utilisateur.getPrenom(), 
				utilisateur.getMatricule(),
				utilisateur.getEmail(),
				utilisateur.getCategoriePermis(),
				utilisateur.getPhotUrl(),
				utilisateur.getTelephone());
	}
	
	public Utilisateur toDtoUtilisateur( ChauffeurDto chauffeur) {
		List<RoleUtilisateur> roles = null;
		return new Utilisateur( 
				chauffeur.getId(), 
				chauffeur.getNom(), 
				chauffeur.getPrenom(), 
				chauffeur.getMatricule(),
				chauffeur.getEmail(),
				chauffeur.getCategorie_permis(),
				chauffeur.getPhotoUrl(),
				chauffeur.getTelephone(), 
				null, 
				roles);
	}

}
