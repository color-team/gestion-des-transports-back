package dev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.CodeErreur;
import dev.controller.dto.MessageErreurDto;
import dev.controller.dto.ReservationCovoiturageDto;
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

	// GET /reservations-covoiturage/matricule
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatriculeTest(@PathVariable String matricule) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
	}

	// POST /reservations-covoiturage
	@PostMapping
	public ResponseEntity<?> create( @RequestBody @Valid AnnonceCovoiturageDto annonceCovoitDto,
			BindingResult result) {
		if ( result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto( CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}
		
		return ResponseEntity.status( HttpStatus.OK).body(service.create( annonceCovoitDto));
	}

}
