package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

	protected VehiculeEntrepriseService vehiculeEntrepriseService;

	public VehiculeEntrepriseController(VehiculeEntrepriseService vehiculeEntrepriseService) {
		super();
		this.vehiculeEntrepriseService = vehiculeEntrepriseService;
	}

	// GET /vehicules-entreprise
	/**
	 * Lister tous les véhicules
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<VehiculeEntrepriseInfosGeneralesDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(vehiculeEntrepriseService.findAll());
	}

	// GET /vehicules-entreprise/{vehicleEntrepriseId}
	/**
	 * Lister tous les véhicules
	 *
	 * @return
	 */
	@GetMapping(value = "/{vehicleEntrepriseId}")
	public ResponseEntity<VehiculeEntrepriseInfosGeneralesDto> findOne(@PathVariable String vehicleEntrepriseId) {
		return ResponseEntity.status(HttpStatus.OK).body(vehiculeEntrepriseService.findOne(Long.parseLong(vehicleEntrepriseId)));
	}

	
	// POST /vehicules-entreprise
	/**
	 * Créer un véhicule de service avec le statut EN_SERVICE
	 * 
	 * @param vehiculeEntrepriseInfosGeneralesDto
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

		return ResponseEntity.status(HttpStatus.OK).body(vehiculeEntrepriseService.create(vehiculeEntrepriseInfosGeneralesDto));
	}


}
