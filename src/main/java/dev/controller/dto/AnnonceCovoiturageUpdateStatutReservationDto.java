package dev.controller.dto;

import javax.validation.constraints.NotNull;

import dev.domain.ReservationCovoiturage;

public class AnnonceCovoiturageUpdateStatutReservationDto {
	
	@NotNull
	protected Long id;
	
	protected String statutReservation;

	public AnnonceCovoiturageUpdateStatutReservationDto() {
	}

	public AnnonceCovoiturageUpdateStatutReservationDto(Long id, String statutReservation) {
		this.id = id;
		this.statutReservation = statutReservation;
	}

	public AnnonceCovoiturageUpdateStatutReservationDto(ReservationCovoiturage reservationCovoiturage) {
		this.id = reservationCovoiturage.getId();
		this.statutReservation = reservationCovoiturage.getStatutAnnonceCovoiturage().getStatutAnnonceCovoiturage().name();
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
