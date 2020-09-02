package dev.controller.mapper;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.ReservationCovoituragePassager;

public class ReservationCovoiturageMapper {

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
}
