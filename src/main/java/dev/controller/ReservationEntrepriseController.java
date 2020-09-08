package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import dev.controller.dto.*;
import dev.exception.ReservationCovoiturageInvalideException;
import dev.service.ReservationEntrepriseService;

@RestController
@RequestMapping("/reservation-entreprise")
@Secured("ROLE_COLLABORATEUR")
public class ReservationEntrepriseController {
	
	protected ReservationEntrepriseService service;

	public ReservationEntrepriseController( ReservationEntrepriseService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/vehicules")
	public ResponseEntity<List<VehiculeSansChauffeurDto>> getVehicules() {
		return ResponseEntity.ok( service.findVehicules());
	}
	
	@PostMapping
	public ResponseEntity<?> create( @RequestBody @Valid ReservationEntrepriseDto reservationDto,
			BindingResult result) {
		if ( result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto( CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}
		return ResponseEntity.ok( service.create( reservationDto));
	}
	
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationEntrepriseAffichageDto>> findByUtilisateur( @PathVariable String matricule) {
		return ResponseEntity.ok( service.findByUtilisateurMatricule( matricule));
	}
	
	@GetMapping("/chauffeur/{matricule}")
	public ResponseEntity<List<ReservationChauffeurPlanningDto>> findByChauffeur( @PathVariable String matricule) {
		return ResponseEntity.ok( service.findByChauffeur( matricule));
	}
	
	@PostMapping
	public ResponseEntity<?> acceptReservation( @RequestBody @Valid AcceptationChauffeurDto acceptation,
			BindingResult result) {
		if ( result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto( CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}
		return ResponseEntity.ok( service.acceptReservation( acceptation));
	}
	
}
