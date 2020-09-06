package dev.controller.dto;

import dev.domain.ReservationCovoituragePassager;

public class ReservationCovoiturageUpdateStatutReservationDto {
	
	protected Long id;
	
	protected String statutReservation;

	public ReservationCovoiturageUpdateStatutReservationDto() {
	}

	public ReservationCovoiturageUpdateStatutReservationDto(Long id, String statutReservation) {
		this.id = id;
		this.statutReservation = statutReservation;
	}

	public ReservationCovoiturageUpdateStatutReservationDto(ReservationCovoituragePassager reservationCovoituragePassager) {
		this.id = reservationCovoituragePassager.getReservationCovoiturage().getId();
		this.statutReservation = reservationCovoituragePassager.getStatutReservationCovoiturage().getStatutReservationCovoiturage().name();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatutReservation() {
		return statutReservation;
	}

	public void setStatutReservation(String statutReservation) {
		this.statutReservation = statutReservation;
	}
}
