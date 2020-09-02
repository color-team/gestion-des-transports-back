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
@RequestMapping("/reservations-covoiturage")
@Secured("ROLE_COLLABORATEUR")
public class ReservationCovoiturageController {

	protected ReservationCovoiturageService service;

	public ReservationCovoiturageController(ReservationCovoiturageService service) {
		super();
		this.service = service;
	}

//	// GET /reservations-covoiturage
//	@GetMapping("/present")
//	public ResponseEntity<List<ReservationCovoiturageDto>> findAllInFuture() {
//		return ResponseEntity.status(HttpStatus.OK).body(service.findAllInFuture());
//	}
//	
//	@GetMapping("/past")
//	public ResponseEntity<List<ReservationCovoiturageDto>> findAllInPast() {
//		return ResponseEntity.status(HttpStatus.OK).body(service.findAllInPast());
//	}
//
//	// GET /reservations-covoiturage/matricule
//	@GetMapping("/{matricule}")
//	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatricule(@PathVariable String matricule) {
//		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
//	}
	
	// GET /reservations-covoiturage/matricule
		@GetMapping("/test/{matricule}")
		public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatriculeTest(@PathVariable String matricule) {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatriculeTest(matricule));
		}

	// POST /reservations-covoiturage
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
