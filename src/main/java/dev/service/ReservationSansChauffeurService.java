package dev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.repository.ReservationSansChauffeurRepository;
import dev.repository.VehiculeEntrepriseRepository;
import dev.domain.VehiculeEntreprise;

@Service
public class ReservationSansChauffeurService {
	
	protected ReservationSansChauffeurRepository resaSansChauffeurRepo;
	
	protected VehiculeEntrepriseRepository vehiculeEntrepriseRepo;

	public ReservationSansChauffeurService(ReservationSansChauffeurRepository resaSansChauffeurRepo,
			VehiculeEntrepriseRepository vehiculeEntrepriseRepo) {
		super();
		this.resaSansChauffeurRepo = resaSansChauffeurRepo;
		this.vehiculeEntrepriseRepo = vehiculeEntrepriseRepo;
	}
	
	public List<VehiculeEntreprise> findVehiculesEnService() {
		return vehiculeEntrepriseRepo.findAll();
	}
	
}
