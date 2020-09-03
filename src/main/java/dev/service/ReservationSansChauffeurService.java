package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.repository.ReservationSansChauffeurRepository;
import dev.repository.UtilisateurRepo;
import dev.repository.VehiculeEntrepriseRepository;
import dev.controller.dto.ReservationSansChauffeurDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
import dev.controller.mapper.ReservationSansChauffeurMapper;
import dev.domain.ReservationSansChauffeur;
import dev.domain.Utilisateur;
import dev.domain.VehiculeEntreprise;

@Service
public class ReservationSansChauffeurService {
	
	private ReservationSansChauffeurRepository resaSansChauffeurRepo;
	
	private VehiculeEntrepriseRepository vehiculeEntrepriseRepo;
	
	private UtilisateurRepo utilisateurRepo;

	private ReservationSansChauffeurMapper mapper;
	
	public ReservationSansChauffeurService(ReservationSansChauffeurRepository resaSansChauffeurRepo,
			VehiculeEntrepriseRepository vehiculeEntrepriseRepo, UtilisateurRepo utilisateurRepo,
			ReservationSansChauffeurMapper mapper) {
		super();
		this.resaSansChauffeurRepo = resaSansChauffeurRepo;
		this.vehiculeEntrepriseRepo = vehiculeEntrepriseRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.mapper = mapper;
	}

	public List<VehiculeEntreprise> findVehicules() {
		return vehiculeEntrepriseRepo.findAll();
	}
	
	public VehiculeSansChauffeurDto toVehiculeDto( VehiculeEntreprise vehicule) {
		return mapper.toVehiculeDto( vehicule);
	}
	
	public ReservationSansChauffeur create( ReservationSansChauffeurDto reservationDto) {
		VehiculeEntreprise vehicule = vehiculeEntrepriseRepo.findById( reservationDto.getVehiculeId()).get();
		Utilisateur conducteur = utilisateurRepo.findByMatricule( reservationDto.getConducteur()).get(0);
		ReservationSansChauffeur reservation =  mapper.dtoToReservation( reservationDto, vehicule, conducteur);
		resaSansChauffeurRepo.save( reservation);
		return reservation;
	}
	
}
