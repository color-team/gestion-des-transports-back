package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.controller.dto.ChauffeurDto;
import dev.controller.mapper.UtilisateurChauffeurMapper;
import dev.domain.Utilisateur;
import dev.domain.enumeration.Role;
import dev.repository.UtilisateurRepo;

@Service
public class UtilisateurService {
	
	protected UtilisateurRepo collegueRep;
	
	protected UtilisateurChauffeurMapper mapper;
	
	public UtilisateurService( UtilisateurRepo collegueRep, UtilisateurChauffeurMapper mapper) {
		super();
		this.collegueRep = collegueRep;
		this.mapper = mapper;
	}

	public Utilisateur chercherParEmail (String email) {
		return collegueRep.findByEmail(email)
				.orElseThrow();
	}
	
	public List<ChauffeurDto> listerChauffeurs() {
		return collegueRep.findByRole( Role.ROLE_CHAUFFEUR).stream()
				.map( user -> mapper.toChauffeurDto(user))
				.collect( Collectors.toList());
    }

}
