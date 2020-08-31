package dev.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.ReservationCovoiturage;
import dev.service.ReservationCovoiturageService;

@RestController
@RequestMapping("/reservationsCovoiturage")
@Secured("ROLE_COLLABORATEUR")
public class ReservationCovoiturageController {

	protected ReservationCovoiturageService service;

	public ReservationCovoiturageController(ReservationCovoiturageService service) {
		super();
		this.service = service;
	}

	// GET /reservationsCovoiturage
	@GetMapping
	public ResponseEntity<List<ReservationCovoiturageDto>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}

	// GET /reservationsCovoiturage/matricule
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatricule(@PathVariable String matricule) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
	}

	// POST /reservationsCovoiturage
//	@PostMapping
//	public ResponseEntity<?> create(@RequestBody @Valid ReservationCovoiturageDto reservationCovoiturageDto,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			throw new ReservationCovoiturageInvalideException(
//					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
//		}
//
//		return ResponseEntity.status(HttpStatus.OK).body(service.create(reservationCovoiturageDto));
//	}

}
