package dev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceCovoiturageCreerDto;
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
	protected ReservationCovoiturageMapper resaCovoitMapper;
	protected UtilisateurRepo utilisateurRepo;
	protected ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo;
	protected SecurityServiceImpl securityService;

	public ReservationCovoiturageService(ReservationCovoiturageRepository reservationCovoiturageRepo,
			ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo,
			UtilisateurRepo utilisateurRepo, SecurityServiceImpl securityService,
			ReservationCovoiturageMapper resaCovoitMapper) {
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
		this.reservationCovoituragePassagerRepo = reservationCovoituragePassagerRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.securityService = securityService;
		this.resaCovoitMapper = resaCovoitMapper;
	}

	@Transactional
	public ReservationCovoiturage create(AnnonceCovoiturageCreerDto annonceCovoitDto) {
		Utilisateur conducteur = utilisateurRepo.findByMatricule(annonceCovoitDto.getConducteur()).get(0);
		ReservationCovoiturage resaCovoit = resaCovoitMapper.fromDto(annonceCovoitDto, conducteur);
		reservationCovoiturageRepo.save(resaCovoit);

		return resaCovoit;
	}

	public ReservationCovoiturageDto convertToDto(ReservationCovoiturage resaCovoit) {
		return resaCovoitMapper.toReservationCovoiturageDto(resaCovoit);
	}

	@Transactional
	public AnnonceCovoiturageDto addPassager(AnnonceCovoiturageDto annonceCovoiturageDto, String matricule) {

		Utilisateur passager = utilisateurRepo.findByMatricule(matricule).get(0);

		ReservationCovoiturage annonceCovoiturage = reservationCovoiturageRepo.findById(annonceCovoiturageDto.getId())
				.get();

		ReservationCovoituragePassager reservationCovoituragePassager = new ReservationCovoituragePassager(passager,
				annonceCovoiturage, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));

		reservationCovoituragePassagerRepo.save(reservationCovoituragePassager);

		annonceCovoiturageDto.addPassager();

		return annonceCovoiturageDto;
	}

	@Transactional
	public AnnonceCovoiturageDto addPassagerByMatricule(AnnonceCovoiturageDto annonceCovoiturageDto, String matricule) {

		Utilisateur passager = utilisateurRepo.findByMatricule(matricule).get(0);

		ReservationCovoiturage annonceCovoiturage = reservationCovoiturageRepo.findById(annonceCovoiturageDto.getId())
				.get();

		ReservationCovoituragePassager reservationCovoituragePassager = new ReservationCovoituragePassager(passager,
				annonceCovoiturage, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));

		reservationCovoituragePassagerRepo.save(reservationCovoituragePassager);

		annonceCovoiturageDto.addPassager();

		return annonceCovoiturageDto;
	}
	
	@Transactional
	public AnnonceCovoiturageDto addMeAsPassenger(AnnonceCovoiturageDto annonceCovoiturageDto) {

		Utilisateur passager = utilisateurRepo
				.findByMatricule(utilisateurRepo.findByEmail(securityService.getUserEmail()).get().getMatricule())
				.get(0);

		ReservationCovoiturage annonceCovoiturage = reservationCovoiturageRepo.findById(annonceCovoiturageDto.getId())
				.get();

		ReservationCovoituragePassager reservationCovoituragePassager = new ReservationCovoituragePassager(passager,
				annonceCovoiturage, new StatutReservationCovoiturage(null, StatutReservationCovoiturageEnum.DEMANDEE));

		reservationCovoituragePassagerRepo.save(reservationCovoituragePassager);

		annonceCovoiturageDto.addPassager();

		return annonceCovoiturageDto;
	}

	public List<AnnonceCovoiturageDto> findAllInFuture() {
		List<ReservationCovoiturage> reservationsCovoiturage = reservationCovoiturageRepo
				.findByDateDepartAfter(LocalDateTime.now());

		return reservationsCovoiturage.stream()
				.map(reservationCovoiturage -> this.resaCovoitMapper.toAnnonceCovoiturageDto(reservationCovoiturage))
				.collect(Collectors.toList());
	}

	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
		return reservationCovoituragePassagerRepo.findByPassagerMatricule(matricule).stream()
				.map(resaCovoitPassager -> resaCovoitMapper.ReservationCovoituragePassagerToDto(resaCovoitPassager))
				.collect(Collectors.toList());
	}
	
	public List<ReservationCovoiturageDto> findByPassagerConnecte() {

		return reservationCovoituragePassagerRepo
				.findByPassagerMatricule(
						utilisateurRepo.findByEmail(securityService.getUserEmail()).get().getMatricule())
				.stream()
				.map(reservationCovoituragePassager -> resaCovoitMapper
						.ReservationCovoituragePassagerToDto(reservationCovoituragePassager))
				.collect(Collectors.toList());
	}
}
