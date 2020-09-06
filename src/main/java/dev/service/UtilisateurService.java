package dev.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.ChauffeurDto;
import dev.controller.dto.UtilisateurDto;
import dev.controller.mapper.UtilisateurChauffeurMapper;
import dev.domain.RoleUtilisateur;
import dev.domain.Utilisateur;
import dev.domain.enumeration.Role;
import dev.exception.CollegueDejaChauffeurExcep;
import dev.exception.CollegueNonTrouveExcep;
import dev.repository.RoleUtilisateurRepository;
import dev.repository.UtilisateurRepo;

@Service
public class UtilisateurService {
	
	protected UtilisateurRepo collegueRep;
	
	protected RoleUtilisateurRepository roleUtilisateurRep;
	
	protected UtilisateurChauffeurMapper mapper;
	
	public UtilisateurService( UtilisateurRepo collegueRep, UtilisateurChauffeurMapper mapper) {
		super();
		this.collegueRep = collegueRep;
		this.mapper = mapper;
	}

	public Optional<Utilisateur> chercherParEmail (String email) {
		return collegueRep.findByEmail(email);
	}
	
	public List<ChauffeurDto> listerChauffeurs() {
		return collegueRep.findByRole( Role.ROLE_CHAUFFEUR).stream()
				.map( user -> mapper.toChauffeurDto(user))
				.collect( Collectors.toList());
    }
	
	public Utilisateur rechercherParMatricule(String matriculeRecherche) {
		return collegueRep.findByMatriculeUtilisateur(matriculeRecherche).orElseThrow(CollegueNonTrouveExcep::new);
	}
	
	@Transactional
	public UtilisateurDto modifierRole(String matricule) throws CollegueDejaChauffeurExcep {
		Utilisateur utilisateur = rechercherParMatricule(matricule);
		
		List<RoleUtilisateur> roles = utilisateur.getRoles();
		
		for (RoleUtilisateur role : roles) {
			if (role.getRole().equals(Role.ROLE_CHAUFFEUR)) {
				throw new CollegueDejaChauffeurExcep("Ce collègue est déja un chauffeur");
			}
		}
				roles.add(new RoleUtilisateur(utilisateur, Role.ROLE_CHAUFFEUR));
				utilisateur.setRoles(roles);
				UtilisateurDto collegueDTO = new UtilisateurDto(utilisateur);
				return collegueDTO;
	}

}
