package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import dev.domain.StatutVehicule;
import dev.domain.VehiculeEntreprise;
import dev.domain.enumeration.StatutVehiculeEnum;
import org.springframework.stereotype.Service;

import dev.controller.dto.VehiculeEntrepriseInfosGeneralesDto;
import dev.controller.mapper.VehiculeEntrepriseInfosGeneralesMapper;
import dev.repository.UtilisateurRepo;
import dev.repository.VehiculeEntrepriseRepository;

@Service
public class VehiculeEntrepriseService {

	protected VehiculeEntrepriseRepository vehiculeEntrepriseRepo;
	protected UtilisateurRepo utilisateurRepo;
	protected SecurityServiceImpl securityService;
	protected VehiculeEntrepriseInfosGeneralesMapper vehiculeEntrepriseInfosGeneralesMapper;

	public VehiculeEntrepriseService(VehiculeEntrepriseRepository vehiculeEntrepriseRepo,
			UtilisateurRepo utilisateurRepo, SecurityServiceImpl securityService,
			VehiculeEntrepriseInfosGeneralesMapper vehiculeEntrepriseInfosGeneralesMapper) {
		this.vehiculeEntrepriseRepo = vehiculeEntrepriseRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.securityService = securityService;
		this.vehiculeEntrepriseInfosGeneralesMapper = vehiculeEntrepriseInfosGeneralesMapper;
	}

	public List<VehiculeEntrepriseInfosGeneralesDto> findAll() {
		return vehiculeEntrepriseRepo.findAll().stream().map(VehiculeEntrepriseInfosGeneralesDto::new)
				.collect(Collectors.toList());
	}

	public VehiculeEntrepriseInfosGeneralesDto findOne(Long idVehiculeEntreprise) {
		return new VehiculeEntrepriseInfosGeneralesDto(vehiculeEntrepriseRepo.findById(idVehiculeEntreprise).get());
	}

	@Transactional
	public VehiculeEntrepriseInfosGeneralesDto create(
			VehiculeEntrepriseInfosGeneralesDto vehiculeEntrepriseInfosGeneralesDto) {
		vehiculeEntrepriseInfosGeneralesDto.setStatutVehicule("EN_SERVICE");
		vehiculeEntrepriseRepo.save(vehiculeEntrepriseInfosGeneralesMapper
				.vehiculeEntrepriseInfosGeneralesDtoToVehiculeEntreprise(vehiculeEntrepriseInfosGeneralesDto));

		return vehiculeEntrepriseInfosGeneralesDto;
	}

	@Transactional
	public VehiculeEntrepriseInfosGeneralesDto update(
			VehiculeEntrepriseInfosGeneralesDto vehiculeDto) {
		VehiculeEntreprise vehicule = vehiculeEntrepriseRepo.getOne( vehiculeDto.getId());
		StatutVehicule statut = vehicule.getStatutVehicule();
		switch ( vehiculeDto.getStatutVehicule()) {
			case "EN REPARATION":
				statut.setStatutVehicule(StatutVehiculeEnum.EN_REPARATION);
				break;
			case "EN SERVICE":
				statut.setStatutVehicule(StatutVehiculeEnum.EN_SERVICE);
				break;
			case "HORS SERVICE":
				statut.setStatutVehicule(StatutVehiculeEnum.HORS_SERVICE);
				break;
		}
		vehicule.setStatutVehicule( statut);
		vehiculeEntrepriseRepo.save( vehicule);

		return vehiculeDto;
	}

}
