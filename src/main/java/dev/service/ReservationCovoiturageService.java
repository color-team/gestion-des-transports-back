package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.mapper.ReservationCovoiturageMapper;
import dev.domain.ReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.repository.ReservationCovoituragePassagerRepository;
import dev.repository.ReservationCovoiturageRepository;
import dev.repository.UtilisateurRepo;

@Service
public class ReservationCovoiturageService {

	@Autowired
	protected ReservationCovoiturageRepository resaCovoitRepo;
	@Autowired
	protected ReservationCovoituragePassagerRepository resaCovoitPassagerRepo;
	@Autowired
	protected UtilisateurRepo userRepo;
	@Autowired
	protected ReservationCovoiturageMapper resaCovoitMapper;


	@Transactional
	public ReservationCovoiturage create( AnnonceCovoiturageDto annonceCovoitDto) {
		Utilisateur conducteur = userRepo.findByMatricule( annonceCovoitDto.getConducteur()).get(0);
		ReservationCovoiturage resaCovoit = resaCovoitMapper.fromDto( annonceCovoitDto, conducteur);
		resaCovoitRepo.save( resaCovoit);
		
		return resaCovoit;
	}
	
	public ReservationCovoiturageDto convertToDto( ReservationCovoiturage resaCovoit) {
		return resaCovoitMapper.toDto( resaCovoit);
	}


	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
		return resaCovoitPassagerRepo.findByPassagerMatricule( matricule).stream()
				.map( resaCovoitPassager -> resaCovoitMapper.ReservationCovoituragePassagerToDto( resaCovoitPassager)).collect( Collectors.toList());
	}

}
