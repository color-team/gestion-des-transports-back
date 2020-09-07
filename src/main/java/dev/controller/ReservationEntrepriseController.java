package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.CodeErreur;
import dev.controller.dto.MessageErreurDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.ReservationEntrepriseAffichageDto;
import dev.controller.dto.ReservationEntrepriseDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
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
	public ResponseEntity<List<ReservationEntrepriseAffichageDto>> findByUtilisateurMatricule( @PathVariable String matricule) {
		return ResponseEntity.ok( service.findByUtilisateurMatricule (matricule));
	}
}
