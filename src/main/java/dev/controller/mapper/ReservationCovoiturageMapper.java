package dev.controller.mapper;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.ReservationCovoiturage;

public class ReservationCovoiturageMapper {

	public static ReservationCovoiturageDto toDto(ReservationCovoiturage reservationCovoiturage) {
		return new ReservationCovoiturageDto(reservationCovoiturage.getDateDepart(),
				reservationCovoiturage.getDepart().getAdresse(), reservationCovoiturage.getDestination().getAdresse(),
				reservationCovoiturage.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name(),
				reservationCovoiturage.getVehiculeParticulier().getInfos(),
				reservationCovoiturage.getConducteur().getInfos());
	}
}
