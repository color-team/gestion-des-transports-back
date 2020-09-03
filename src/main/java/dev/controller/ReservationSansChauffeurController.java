package dev.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.controller.dto.CodeErreur;
import dev.controller.dto.MessageErreurDto;
import dev.controller.dto.ReservationSansChauffeurDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
import dev.domain.ReservationSansChauffeur;
import dev.domain.VehiculeEntreprise;
import dev.exception.ReservationCovoiturageInvalideException;
import dev.service.ReservationSansChauffeurService;

@RestController
@RequestMapping("/reservation-entreprise")
@Secured("ROLE_COLLABORATEUR")
public class ReservationSansChauffeurController {
	
	protected ReservationSansChauffeurService service;

	public ReservationSansChauffeurController( ReservationSansChauffeurService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/vehicules")
	public ResponseEntity<List<VehiculeSansChauffeurDto>> getVehicules(){
		
		List<VehiculeEntreprise> vehicules = service.findVehicules();
		List<VehiculeSansChauffeurDto> vehiculesDto = vehicules.stream()
				.map( vehicule -> service.toVehiculeDto( vehicule))
				.collect( Collectors.toList());
		
		return ResponseEntity.ok( vehiculesDto);
	}
	
	@PostMapping
	public ResponseEntity<?> create( @RequestBody @Valid ReservationSansChauffeurDto reservationDto,
			BindingResult result) {
		if ( result.hasErrors()) {
			throw new ReservationCovoiturageInvalideException(
					new MessageErreurDto( CodeErreur.VALIDATION, "Les champs doivent être tous remplis"));
		}
		
		ReservationSansChauffeur reservation = service.create( reservationDto);
		
		return ResponseEntity.ok( reservation);
	}

}
