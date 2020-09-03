package dev.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.controller.dto.AnnonceCovoiturageCreerDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.Localisation;
import dev.domain.ReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.VehiculeParticulier;
import dev.domain.ReservationCovoituragePassager;

@Component
public class ReservationCovoiturageMapper {
	

	public ReservationCovoiturageDto toDto( ReservationCovoiturage reservationCovoiturage) {
		return new ReservationCovoiturageDto(
				reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), 
				reservationCovoiturage.getDestination().getAdresse(),
				null,
				reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getMatricule());
	}
	
	public ReservationCovoiturageDto ReservationCovoituragePassagerToDto( ReservationCovoituragePassager reservationCovoituragePassager) {
		return new ReservationCovoiturageDto(
				reservationCovoituragePassager.getReservationCovoiturage().getDateDepart(),
				reservationCovoituragePassager.getReservationCovoiturage().getDepart().getAdresse(), 
				reservationCovoituragePassager.getReservationCovoiturage().getDestination().getAdresse(),
				reservationCovoituragePassager.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name(),
				reservationCovoituragePassager.getReservationCovoiturage().getVehiculeParticulier().getInfos(),
				reservationCovoituragePassager.getReservationCovoiturage().getConducteur().getInfos());
	}
	
	
	public ReservationCovoiturage fromDto( AnnonceCovoiturageCreerDto annonce, Utilisateur conducteur) {

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
		
		return new ReservationCovoiturage( 
				annonce.getDateDepart(),
				depart, 
				destination,
				conducteur,
				annonce.getNbPassager(),
				vehicule);
	}
}
