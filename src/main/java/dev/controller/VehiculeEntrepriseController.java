package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceCovoiturageCreerDto;
import dev.controller.dto.CodeErreur;
import dev.controller.dto.MessageErreurDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.VehiculeEntrepriseInfosGeneralesDto;
import dev.domain.ReservationCovoiturage;
import dev.exception.ReservationCovoiturageInvalideException;
import dev.service.VehiculeEntrepriseService;

@RestController
@RequestMapping("/vehicules-entreprise")
@Secured("ROLE_ADMINISTRATEUR")
public class VehiculeEntrepriseController {

	protected VehiculeEntrepriseService service;

	public VehiculeEntrepriseController(VehiculeEntrepriseService service) {
		super();
		this.service = service;
	}

	// GET /vehicules-entreprise
	/**
	 * Lister tous les véhicules
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<VehiculeEntrepriseInfosGeneralesDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	
	// POST /vehicules-entreprise
	/**
	 * Créer un véhicule de service avec le statut EN_SERVICE
	 * 
	 * @param VehiculeEntrepriseInfosGeneralesDto
	 * @param result
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid VehiculeEntrepriseInfosGeneralesDto vehiculeEntrepriseInfosGeneralesDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(service.create(vehiculeEntrepriseInfosGeneralesDto));
	}


}
