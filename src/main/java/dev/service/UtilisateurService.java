package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.controller.dto.ChauffeurDto;
import dev.domain.Utilisateur;
import dev.repository.UtilisateurRepo;

@Service
public class UtilisateurService {
	
	protected UtilisateurRepo collegueRep;

	public UtilisateurService() {
	}
	
	public Utilisateur chercherParEmail (String email) {
		return collegueRep.findByEmail(email)
				.orElseThrow();
	}
	
	public List<ChauffeurDto> listerChauffeurs() {
		return collegueRep.findByRole("ROLE_CHAUFFEUR");
    }

}
