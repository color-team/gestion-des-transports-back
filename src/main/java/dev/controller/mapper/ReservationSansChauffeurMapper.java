package dev.controller.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.controller.dto.DispoResrvationSansChauffeurDto;
import dev.controller.dto.ReservationSansChauffeurDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
import dev.domain.ReservationEntreprise;
import dev.domain.ReservationSansChauffeur;
import dev.domain.StatutReservationEntreprise;
import dev.domain.Utilisateur;
import dev.domain.VehiculeEntreprise;
import dev.domain.enumeration.StatutReservationEntrepriseEnum;

@Component
public class ReservationSansChauffeurMapper {
	
	public VehiculeSansChauffeurDto toVehiculeDto( VehiculeEntreprise vehicule) {
		return new VehiculeSansChauffeurDto(
				vehicule.getId(),
				vehicule.getImmatriculation(),
				vehicule.getMarque(),
				vehicule.getModele(),
				vehicule.getPhotoUrl(),
				vehicule.getCategorie(),
				vehicule.getStatutVehicule().getStatutVehicule().name(),
				vehicule.getReservationsEntreprise().stream()
				.map( reservation -> this.toDispoDto( reservation))
				.collect( Collectors.toList())
				);
	}
	
	public DispoResrvationSansChauffeurDto toDispoDto( ReservationEntreprise reservation) {
		return new DispoResrvationSansChauffeurDto(
				reservation.getId(),
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise().name()
				);
	}
	
	public ReservationSansChauffeur dtoToReservation( ReservationSansChauffeurDto reservationDto, 
			VehiculeEntreprise vehicule, Utilisateur conducteur) {
		
		StatutReservationEntreprise statut = new StatutReservationEntreprise();
		statut.setStatutReservationEntreprise( StatutReservationEntrepriseEnum.ACCEPTEE);
		
		return new ReservationSansChauffeur(
				reservationDto.getDateDepart(),
				reservationDto.getDateArrivee(),
				null,
				null,
				conducteur,
				vehicule,
				statut);
	}

}
