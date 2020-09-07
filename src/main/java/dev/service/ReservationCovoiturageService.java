package dev.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.AnnonceCovoiturageConducteurDto;
import dev.controller.dto.AnnonceCovoiturageCreerDto;
import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.AnnonceCovoiturageUpdateStatutReservationDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageUpdateStatutReservationDto;
import dev.controller.mapper.ReservationCovoiturageMapper;
import dev.domain.ReservationCovoiturage;
import dev.domain.ReservationCovoituragePassager;
import dev.domain.StatutAnnonceCovoiturage;
import dev.domain.StatutReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.enumeration.StatutAnnonceCovoiturageEnum;
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
	protected EmailServiceImpl emailService;

	public ReservationCovoiturageService(ReservationCovoiturageRepository reservationCovoiturageRepo,
			ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo,
			UtilisateurRepo utilisateurRepo, SecurityServiceImpl securityService,
			ReservationCovoiturageMapper resaCovoitMapper, EmailServiceImpl emailService) {
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
		this.reservationCovoituragePassagerRepo = reservationCovoituragePassagerRepo;
		this.utilisateurRepo = utilisateurRepo;
		this.securityService = securityService;
		this.resaCovoitMapper = resaCovoitMapper;
		this.emailService = emailService;
	}

	@Transactional
	public ReservationCovoiturage create(AnnonceCovoiturageCreerDto annonceCovoitDto) {
		Utilisateur conducteur = utilisateurRepo.findByMatricule(annonceCovoitDto.getConducteur()).get(0);
		ReservationCovoiturage resaCovoit = resaCovoitMapper.fromDto(annonceCovoitDto, conducteur);
		// Il faut valoriser le statutAnnonceCovoiturage avant de persister
		resaCovoit.setStatutAnnonceCovoiturage(new StatutAnnonceCovoiturage(resaCovoit, StatutAnnonceCovoiturageEnum.PUBLIEE));
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
				.filter(reservationCovoiturage -> reservationCovoiturage.getStatutAnnonceCovoiturage().getStatutAnnonceCovoiturage() == StatutAnnonceCovoiturageEnum.PUBLIEE)
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
	
	public List<AnnonceCovoiturageConducteurDto> findByConducteurConnecte() {

		return reservationCovoiturageRepo
				.findByConducteurMatricule(
						utilisateurRepo.findByEmail(securityService.getUserEmail()).get().getMatricule())
				.stream()
				.map(AnnonceCovoiturageConducteurDto::new)
				.collect(Collectors.toList());
	}
	
	public ReservationCovoiturageUpdateStatutReservationDto annulerReservation(ReservationCovoiturageUpdateStatutReservationDto updateStatutDto) {
		ReservationCovoituragePassager reservationCovoituragePassager = reservationCovoituragePassagerRepo
				.findByPassagerMatricule(
						utilisateurRepo.findByEmail(securityService.getUserEmail()).get().getMatricule())
				.stream().filter(reservation -> reservation.getReservationCovoiturage().getId() == updateStatutDto.getId())
				.collect(Collectors.toList())
				.get(0);
		reservationCovoituragePassager.cancelReservation();
		//  Repose sur le @OneToOne(cascade = CascadeType.ALL) entre ReservationCovoituragePassager et
		//  StatutReservationCovoiturage
		reservationCovoituragePassagerRepo.save(reservationCovoituragePassager);
		EnvoyerEmailAnnulationReservation(reservationCovoituragePassager.getReservationCovoiturage(), securityService.getUserEmail(), false);
		
		return new ReservationCovoiturageUpdateStatutReservationDto(reservationCovoituragePassager);
	}
	
	public AnnonceCovoiturageUpdateStatutReservationDto annulerAnnonce(AnnonceCovoiturageUpdateStatutReservationDto updateStatutDto) {
		ReservationCovoiturage reservationCovoiturage = reservationCovoiturageRepo
				.findByConducteurMatricule(
						utilisateurRepo.findByEmail(securityService.getUserEmail()).get().getMatricule())
				.stream().filter(reservation -> reservation.getId() == updateStatutDto.getId())
				.collect(Collectors.toList())
				.get(0);
		reservationCovoiturage.cancelAnnonceByConducteur();
		//  Repose sur le @OneToOne(cascade = CascadeType.ALL) entre ReservationCovoiturage et
		//  StatutAnnonceCovoiturage
		reservationCovoiturageRepo.save(reservationCovoiturage);
		EnvoyerEmailAnnulationAnnonce(reservationCovoiturage, securityService.getUserEmail());
		reservationCovoiturage.getReservationsCovoituragePassagers().
		forEach(rerservation -> {
			EnvoyerEmailAnnulationReservation(reservationCovoiturage, rerservation.getPassager().getEmail(), true);
			rerservation.cancelReservation();
		});
		
		return new AnnonceCovoiturageUpdateStatutReservationDto(reservationCovoiturage);
	}
	
	protected void EnvoyerEmailAnnulationReservation(ReservationCovoiturage reservation, String email, boolean parConducteur) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String finMessage = parConducteur ? " par le conducteur de l'annonce." : ".";
		String text = "Votre réservation pour le " + reservation.getDateDepart().format(formatter) +
			" de " + reservation.getDepart().getAdresse() + " à " + reservation.getDestination().getAdresse() +
			" a été annulée" + finMessage;
		emailService.sendSimpleMessage(email, "Annulation de la réservation", text);
	}
	
	protected void EnvoyerEmailAnnulationAnnonce(ReservationCovoiturage reservation, String email) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String text = "Votre annonce pour le " + reservation.getDateDepart().format(formatter) +
			" de " + reservation.getDepart().getAdresse() + " à " + reservation.getDestination().getAdresse() +
			" a bien été annulée.";
		emailService.sendSimpleMessage(email, "Annulation de l'annonce", text);
	}
}
