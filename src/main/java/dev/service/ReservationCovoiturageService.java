package dev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.mapper.ReservationCovoiturageMapper;
import dev.domain.ReservationCovoiturage;
import dev.domain.ReservationCovoituragePassager;
import dev.domain.StatutReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.enumeration.StatutReservationCovoiturageEnum;
import dev.repository.ReservationCovoituragePassagerRepository;
import dev.repository.ReservationCovoiturageRepository;
import dev.repository.UtilisateurRepo;

@Service
public class ReservationCovoiturageService {

	protected ReservationCovoiturageRepository reservationCovoiturageRepo;
	
	protected ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo;
	
	protected UtilisateurRepo utilisateurRepo;
	
	protected SecurityServiceImpl securityService;
	
	public ReservationCovoiturageService(ReservationCovoiturageRepository reservationCovoiturageRepo,
			ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo, UtilisateurRepo utilisateurRepo, SecurityServiceImpl securityService) {
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
		this.reservationCovoituragePassagerRepo = reservationCovoituragePassagerRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.securityService = securityService;
	}



	@Transactional
	public AnnonceCovoiturageDto addPassager(AnnonceCovoiturageDto annonceCovoiturageDto, String matricule) {
		
		Utilisateur passager = utilisateurRepo.findByMatricule(matricule).get(0);
		
		ReservationCovoiturage annonceCovoiturage = reservationCovoiturageRepo.findById(annonceCovoiturageDto.getId()).get();
		
		ReservationCovoituragePassager reservationCovoituragePassager = new ReservationCovoituragePassager(passager, annonceCovoiturage, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));
		
		reservationCovoituragePassagerRepo.save(reservationCovoituragePassager);
		
		annonceCovoiturageDto.addPassager();
		
		return annonceCovoiturageDto;
	}


	public List<AnnonceCovoiturageDto> findAllInFuture() {
		List<ReservationCovoiturage> reservationsCovoiturage = reservationCovoiturageRepo.findByDateDepartAfter(LocalDateTime.now());

		return reservationsCovoiturage.stream().map(reservationCovoiturage -> ReservationCovoiturageMapper.toDto(reservationCovoiturage)).collect(Collectors.toList());
	}
	
	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
		return reservationCovoituragePassagerRepo.findByPassagerMatricule(matricule).stream().map(reservationCovoituragePassager -> ReservationCovoiturageMapper.ReservationCovoituragePassagerToDto(reservationCovoituragePassager)).collect(Collectors.toList());
	}

}
