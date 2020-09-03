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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.AnnonceCovoiturageCreerDto;
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

	// GET /reservations-covoiturage/
	@GetMapping
	public ResponseEntity<List<AnnonceCovoiturageDto>> findAllInFuture() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAllInFuture());
	}

	// GET /reservations-covoiturage/matricule
	@GetMapping("/{matricule}")
	public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerMatricule(@PathVariable String matricule) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerMatricule(matricule));
	}

	// GET /reservations-covoiturage/me
		@GetMapping("/me")
		public ResponseEntity<List<ReservationCovoiturageDto>> findByPassagerConnecte() {
			return ResponseEntity.status(HttpStatus.OK).body(service.findByPassagerConnecte());
		}

//AL
	// POST /reservations-covoiturage
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
	@PutMapping
	public ResponseEntity<?> addMeAsPassenger(@RequestBody @Valid AnnonceCovoiturageDto annonceCovoiturageDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}

		return ResponseEntity.status(HttpStatus.OK).body(service.addMeAsPassenger(annonceCovoiturageDto));
	}

	// POST /reservations-covoiturage/matricule
		@Secured("ROLE_ADMININSTRATEUR")
		@PostMapping("/{matricule}")
		public ResponseEntity<?> addPassagerByMatricule(@RequestBody @Valid AnnonceCovoiturageDto annonceCovoiturageDto,
				BindingResult result, @PathVariable String matricule) {
			if (result.hasErrors()) {
				throw new ReservationCovoiturageInvalideException(
						new MessageErreurDto(CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
			}

			return ResponseEntity.status(HttpStatus.OK)
					.body(service.addPassagerByMatricule(annonceCovoiturageDto, matricule));
		}

}
