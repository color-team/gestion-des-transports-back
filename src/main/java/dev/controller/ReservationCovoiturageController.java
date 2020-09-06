package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceCovoiturageConducteurDto;
import dev.controller.dto.AnnonceCovoiturageCreerDto;
import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.CodeErreur;
import dev.controller.dto.MessageErreurDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageUpdateStatutReservationDto;
import dev.domain.ReservationCovoiturage;
import dev.exception.ReservationCovoiturageInvalideException;
import dev.service.ReservationCovoiturageService;

@RestController
@RequestMapping("/reservations-covoiturage")
@Secured("ROLE_COLLABORATEUR")
public class ReservationCovoiturageController {

	protected ReservationCovoiturageService service;

	public ReservationCovoiturageController(ReservationCovoiturageService service) {
		super();
		this.service = service;
	}

	// GET /reservations-covoiturage
	/**
	 * Lister toutes les annonces de covoiturages dans le futur dont le statut est
	 * "PUBLIEE"
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<AnnonceCovoiturageDto>> findAllInFuture() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllInFuture());
	}

	// GET /reservations-covoiturage/me
	/**
	 * Lister toutes les réservations de covoiturage d'un utilisateur connecté
	 * 
	 * @return
	 */
	@GetMapping("/me")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerConnecte() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerConnecte());
	}

	// GET /reservations-covoiturage/matricule
	/**
	 * Lister toutes les réservation de covoiturage de l'utilisateur dont le
	 * matricule a été passé en paramètre
	 * 
	 * @param matricule
	 * @return
	 */
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatricule(@PathVariable String matricule) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
	}

	// GET /reservations-covoiturage/conducteur
	/**
	 * Lister toutes les annonces de covoiturage d'un utilisateur connecté (qu'il a
	 * publié étant conducteur)
	 * 
	 * @param matricule
	 * @return
	 */
	@GetMapping("/conducteur")
	public ResponseEntity<List<AnnonceCovoiturageConducteurDto>> findByConducteurConnecte() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByConducteurConnecte());
	}

//AL
	// POST /reservations-covoiturage
	/**
	 * Créer une annonce de covoiturage
	 * 
	 * @param annonceCovoitDto
	 * @param result
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid AnnonceCovoiturageCreerDto annonceCovoitDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		ReservationCovoiturage resaCovoit = service.create(annonceCovoitDto);
		ReservationCovoiturageDto resaCovoitDto = service.convertToDto(resaCovoit);

		return ResponseEntity.status(HttpStatus.OK).body(resaCovoitDto);
	}

	// PUT /reservations-covoiturage
	/**
	 * Ajouter l'utilisateur connecté comme passager d'une annonce de covoiturage
	 * 
	 * @param annonceCovoiturageDto
	 * @param result
	 * @return
	 */
	@PutMapping
	public ResponseEntity<?> addMeAsPassenger(@RequestBody @Valid AnnonceCovoiturageDto annonceCovoiturageDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(service.addMeAsPassenger(annonceCovoiturageDto));
	}

	// PUT /reservations-covoiturage/matricule
	/**
	 * Ajouter l'utilisateur dont le matricule est passé en paramètre comme passager
	 * d'une annonce de covoiturage
	 * 
	 * @param annonceCovoiturageDto
	 * @param result
	 * @param matricule
	 * @return
	 */
	@Secured("ROLE_ADMININSTRATEUR")
	@PutMapping("/{matricule}")
	public ResponseEntity<?> addPassagerByMatricule(@RequestBody @Valid AnnonceCovoiturageDto annonceCovoiturageDto,
			BindingResult result, @PathVariable String matricule) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		return ResponseEntity.status(HttpStatus.OK)
				.body(service.addPassagerByMatricule(annonceCovoiturageDto, matricule));
	}
	
	// PATCH /reservations-covoiturage
	/**
	 * Ajouter l'utilisateur connecté comme passager d'une annonce de covoiturage
	 * 
	 * @param annonceCovoiturageDto
	 * @param result
	 * @return
	 */
	@PatchMapping
	public ResponseEntity<?> annulerReservation(@RequestBody @Valid ReservationCovoiturageUpdateStatutReservationDto updateStatutDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(service.annulerReservation(updateStatutDto));
	}

}
