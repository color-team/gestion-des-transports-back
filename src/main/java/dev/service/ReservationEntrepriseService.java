package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.AcceptationChauffeurDto;
import dev.controller.dto.ReservationChauffeurPlanningDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.ReservationEntrepriseAffichageDto;
import dev.controller.dto.ReservationEntrepriseDto;
import dev.controller.dto.ReservationEntrepriseInfosDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
import dev.controller.mapper.ReservationEntrepriseMapper;
import dev.domain.ReservationChauffeur;
import dev.domain.ReservationSansChauffeur;
import dev.domain.StatutReservationEntreprise;
import dev.domain.Utilisateur;
import dev.domain.VehiculeEntreprise;
import dev.domain.enumeration.StatutReservationEntrepriseEnum;
import dev.repository.ReservationChauffeurRepository;
import dev.repository.ReservationSansChauffeurRepository;
import dev.repository.UtilisateurRepo;
import dev.repository.VehiculeEntrepriseRepository;

@Service
public class ReservationEntrepriseService {
	
	private ReservationSansChauffeurRepository resaSansChauffeurRepo;
	
	private ReservationChauffeurRepository resaAvecChauffeurRepo;
	
	private VehiculeEntrepriseRepository vehiculeEntrepriseRepo;
	
	private UtilisateurRepo utilisateurRepo;

	private ReservationEntrepriseMapper mapper;
	
	public ReservationEntrepriseService(ReservationSansChauffeurRepository resaSansChauffeurRepo,
			ReservationChauffeurRepository resaAvecChauffeurRepo, VehiculeEntrepriseRepository vehiculeEntrepriseRepo,
			UtilisateurRepo utilisateurRepo, ReservationEntrepriseMapper mapper) {
		super();
		this.resaSansChauffeurRepo = resaSansChauffeurRepo;
		this.resaAvecChauffeurRepo = resaAvecChauffeurRepo;
		this.vehiculeEntrepriseRepo = vehiculeEntrepriseRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.mapper = mapper;
	}

	public List<VehiculeSansChauffeurDto> findVehicules() {
		return vehiculeEntrepriseRepo.findAll().stream()
				.map( vehicule -> mapper.toVehiculeDto( vehicule))
				.collect( Collectors.toList());
	}
	
	public VehiculeSansChauffeurDto toVehiculeDto( VehiculeEntreprise vehicule) {
		return mapper.toVehiculeDto( vehicule);
	}
	
	@Transactional
	public ReservationEntrepriseInfosDto create( ReservationEntrepriseDto reservationDto) {
		VehiculeEntreprise vehicule = vehiculeEntrepriseRepo.findById( reservationDto.getVehiculeId()).get();
		Utilisateur reservant = utilisateurRepo.findByMatricule( reservationDto.getReservant()).get(0);
		
		if ( reservationDto.isAvecChauffeur()) {
			ReservationChauffeur reservation =  mapper.dtoToReservationAvecChauffeur( reservationDto, vehicule, reservant);
			resaAvecChauffeurRepo.save( reservation);
			return mapper.avecChauffeurtoInfosDto( reservation);
		} 
		else {
			ReservationSansChauffeur reservation =  mapper.dtoToReservationSansChauffeur( reservationDto, vehicule, reservant);
			resaSansChauffeurRepo.save( reservation);
			return mapper.sansChauffeurtoInfosDto( reservation);
		}
	}
	
	public List<ReservationEntrepriseAffichageDto> findByUtilisateurMatricule( String matricule) {
		List<ReservationEntrepriseAffichageDto> reservations = resaAvecChauffeurRepo.findByPassagerMatricule( matricule)
				.stream().map( reservation -> mapper.avecChauffeurToAffichageDto( reservation))
				.collect( Collectors.toList());
		
		reservations.addAll( resaSansChauffeurRepo.findByConducteurMatricule( matricule).stream()
		.map( reservation -> mapper.sansChauffeurToAffichageDto( reservation))
		.collect( Collectors.toList()));
		
		return reservations;
	}
	
	public List<ReservationChauffeurPlanningDto> findByChauffeur( String matricule) {
		return resaAvecChauffeurRepo.findByChauffeurMatricule( matricule)
				.stream().map( reservation -> mapper.avecChauffeurToPlanningDto( reservation))
				.collect( Collectors.toList());
	}
	
	@Transactional
	public ReservationEntrepriseAffichageDto acceptReservation( AcceptationChauffeurDto acceptation) {
		Utilisateur chauffeur = utilisateurRepo.findByMatricule( acceptation.getChauffeurMatricule()).get(0);
		ReservationChauffeur reservation = resaAvecChauffeurRepo.getOne( acceptation.getReservationId());
		VehiculeEntreprise vehicule = reservation.getVehiculeEntreprise();
		StatutReservationEntreprise statut = new StatutReservationEntreprise(
				reservation, StatutReservationEntrepriseEnum.ACCEPTEE);
		
		chauffeur.addReservationChauffeur( reservation);
		vehicule.addReservationEntreprise( reservation);
		
		reservation.setStatutReservationEntreprise( statut);
		reservation.setChauffeur( chauffeur);
		reservation.setVehiculeEntreprise( vehicule);
		
		resaAvecChauffeurRepo.save( reservation);
		
		return mapper.avecChauffeurToAffichageDto( reservation);
	}
	
}
