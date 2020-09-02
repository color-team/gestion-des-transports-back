package dev.controller.mapper;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.dto.VehiculeParticulierDto;
import dev.domain.Localisation;
import dev.domain.ReservationCovoiturage;
import dev.domain.StatutReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.VehiculeParticulier;

public class ReservationCovoiturageMapper {
	
	

	public static ReservationCovoiturageDto toDto(ReservationCovoiturage reservationCovoiturage) {
		return new ReservationCovoiturageDto(
				reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), 
				reservationCovoiturage.getDestination().getAdresse(),
				reservationCovoiturage.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name(),
				reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getInfos());
	}
	
	/*public static ReservationCovoiturage fromDto( AnnonceCovoiturageDto annonce) {
		
		Localisation depart = new Localisation();
		depart.setAdresse( annonce.getDepart());
		
		Localisation destination = new Localisation();
		destination.setAdresse( annonce.getDestination());
		
		VehiculeParticulier vehicule = new VehiculeParticulier(
				annonce.getVehicule().getImmatriculation(),
				annonce.getVehicule().getMarque(),
				null,
				null,
				annonce.getVehicule().getModele(),
				null);
		
		Utilisateur conduteur = repo.findUser();
		
		return new ReservationCovoiturage( 
				annonce.getDateDepart(),
				depart, 
				destination,
				annonce.getVehicule().getPlaces(),
				null,
				vehicule,
				'',
				null);
	}*/
}
