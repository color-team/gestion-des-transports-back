package dev.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.Localisation;
import dev.domain.ReservationCovoiturage;
import dev.domain.Utilisateur;
import dev.domain.VehiculeParticulier;
import dev.repository.UtilisateurRepo;
import dev.domain.ReservationCovoituragePassager;

public class ReservationCovoiturageMapper {
	
	@Autowired
	private static UtilisateurRepo userRepo;	
	
//	public static ReservationCovoiturageDto toDto(ReservationCovoiturage reservationCovoiturage) {
//		return new ReservationCovoiturageDto(reservationCovoiturage.getDateDepart(),
//				reservationCovoiturage.getDepart().getAdresse(), reservationCovoiturage.getDestination().getAdresse(),
//				reservationCovoiturage.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name(),
//				reservationCovoiturage.getVehiculeParticulier().getInfos(),
//				reservationCovoiturage.getConducteur().getInfos());
//	}
	
	public static ReservationCovoiturageDto ReservationCovoituragePassagerToDto(ReservationCovoituragePassager reservationCovoituragePassager) {
		return new ReservationCovoiturageDto(reservationCovoituragePassager.getReservationCovoiturage().getDateDepart(),
				reservationCovoituragePassager.getReservationCovoiturage().getDepart().getAdresse(), reservationCovoituragePassager.getReservationCovoiturage().getDestination().getAdresse(),
				reservationCovoituragePassager.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name(),
				reservationCovoituragePassager.getReservationCovoiturage().getVehiculeParticulier().getInfos(),
				reservationCovoituragePassager.getReservationCovoiturage().getConducteur().getInfos());
	}
	
	
	public static ReservationCovoiturage fromDto( AnnonceCovoiturageDto annonce) {

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
		
		Utilisateur conducteur = userRepo.findByMatricule( annonce.getConducteur()).get(0);

		return new ReservationCovoiturage( 
				annonce.getDateDepart(),
				depart, 
				destination,
				conducteur,
				annonce.getNbPassager(),
				vehicule);
	}
}
