package dev.controller.mapper;

import org.springframework.stereotype.Component;

import dev.controller.dto.AnnonceCovoiturageCreerDto;
import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.Localisation;
import dev.domain.ReservationCovoiturage;
import dev.domain.ReservationCovoituragePassager;
import dev.domain.Utilisateur;
import dev.domain.VehiculeParticulier;

@Component
public class ReservationCovoiturageMapper {

	public ReservationCovoiturageDto toReservationCovoiturageDto(ReservationCovoiturage reservationCovoiturage) {
		return new ReservationCovoiturageDto(reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), reservationCovoiturage.getDestination().getAdresse(),
				null, reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getMatricule());
	}

	public AnnonceCovoiturageDto toAnnonceCovoiturageDto(ReservationCovoiturage reservationCovoiturage) {
		return new AnnonceCovoiturageDto(reservationCovoiturage.getId(), reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), reservationCovoiturage.getDestination().getAdresse(),
				reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getInfos(), reservationCovoiturage.getNbPlacesDisponibles());
	}

	public ReservationCovoiturageDto ReservationCovoituragePassagerToDto(
			ReservationCovoituragePassager reservationCovoituragePassager) {
		return new ReservationCovoiturageDto(reservationCovoituragePassager.getReservationCovoiturage().getDateDepart(),
				reservationCovoituragePassager.getReservationCovoiturage().getDepart().getAdresse(),
				reservationCovoituragePassager.getReservationCovoiturage().getDestination().getAdresse(),
				reservationCovoituragePassager.getStatutReservationCovoiturage().getStatutReservationCovoiturage()
						.name(),
				reservationCovoituragePassager.getReservationCovoiturage().getVehiculeParticulier().getInfos(),
				reservationCovoituragePassager.getReservationCovoiturage().getConducteur().getInfos(),
				reservationCovoituragePassager.getReservationCovoiturage().getStatutAnnonceCovoiturage().getStatutAnnonceCovoiturage().name()
				);
	}

	public ReservationCovoiturage fromDto(AnnonceCovoiturageCreerDto annonce, Utilisateur conducteur) {

		Localisation depart = new Localisation();
		depart.setAdresse(annonce.getDepart());

		Localisation destination = new Localisation();
		destination.setAdresse(annonce.getDestination());

		VehiculeParticulier vehicule = new VehiculeParticulier(annonce.getVehicule().getImmatriculation(),
				annonce.getVehicule().getMarque(), null, null, annonce.getVehicule().getModele(), null);

		return new ReservationCovoiturage(annonce.getDateDepart(), depart, destination, conducteur,
				annonce.getNbPassager(), vehicule);
	}
}
