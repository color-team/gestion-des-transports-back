package dev.controller.mapper;

import org.springframework.stereotype.Component;

import dev.controller.dto.ChauffeurDto;
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

}
