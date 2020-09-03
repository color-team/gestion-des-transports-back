package dev.controller.mapper;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.ReservationCovoiturage;
import dev.domain.ReservationCovoituragePassager;

public class ReservationCovoiturageMapper {

	public static AnnonceCovoiturageDto toDto(ReservationCovoiturage reservationCovoiturage) {
		return new AnnonceCovoiturageDto(
				reservationCovoiturage.getId(),
				reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), reservationCovoiturage.getDestination().getAdresse(),
				reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getInfos(),
				reservationCovoiturage.getNbPlacesDisponibles());
	}

	public static ReservationCovoiturageDto ReservationCovoituragePassagerToDto(
			ReservationCovoituragePassager reservationCovoituragePassager) {
		return new ReservationCovoiturageDto(reservationCovoituragePassager.getReservationCovoiturage().getDateDepart(),
				reservationCovoituragePassager.getReservationCovoiturage().getDepart().getAdresse(),
				reservationCovoituragePassager.getReservationCovoiturage().getDestination().getAdresse(),
				reservationCovoituragePassager.getStatutReservationCovoiturage().getStatutReservationCovoiturage()
						.name(),
				reservationCovoituragePassager.getReservationCovoiturage().getVehiculeParticulier().getInfos(),
				reservationCovoituragePassager.getReservationCovoiturage().getConducteur().getInfos());
	}
}
