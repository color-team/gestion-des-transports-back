package dev.controller.dto;

import java.time.LocalDateTime;

import dev.domain.ReservationCovoiturage;

public class AnnonceCovoiturageConducteurDto {

	protected Long id;
	
	protected LocalDateTime dateDepart;

	protected String infosDepart;

	protected String infosDestination;

	protected Integer nbPlacesDisponibles;
	
	public String statutAnnonceCovoiturage;

	public AnnonceCovoiturageConducteurDto() {
	}

	public AnnonceCovoiturageConducteurDto(Long id, LocalDateTime dateDepart, String infosDepart,
			String infosDestination, Integer nbPlacesDisponibles, String statutAnnonceCovoiturage) {
		this.id = id;
		this.dateDepart = dateDepart;
		this.infosDepart = infosDepart;
		this.infosDestination = infosDestination;
		this.nbPlacesDisponibles = nbPlacesDisponibles;
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}
	
	public AnnonceCovoiturageConducteurDto(ReservationCovoiturage reservationCovoiturage) {
		this.id = reservationCovoiturage.getId();
		this.dateDepart = reservationCovoiturage.getDateDepart();
		this.infosDepart = reservationCovoiturage.getDepart().getAdresse();
		this.infosDestination = reservationCovoiturage.getDestination().getAdresse();
		this.nbPlacesDisponibles = reservationCovoiturage.getNbPlacesDisponibles();
		this.statutAnnonceCovoiturage = reservationCovoiturage.getStatutAnnonceCovoiturage().getStatutAnnonceCovoiturage().name();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getInfosDepart() {
		return infosDepart;
	}

	public void setInfosDepart(String infosDepart) {
		this.infosDepart = infosDepart;
	}

	public String getInfosDestination() {
		return infosDestination;
	}

	public void setInfosDestination(String infosDestination) {
		this.infosDestination = infosDestination;
	}

	public Integer getNbPlacesDisponibles() {
		return nbPlacesDisponibles;
	}

	public void setNbPlacesDisponibles(Integer nbPlacesDisponibles) {
		this.nbPlacesDisponibles = nbPlacesDisponibles;
	}

	public String getStatutAnnonceCovoiturage() {
		return statutAnnonceCovoiturage;
	}

	public void setStatutAnnonceCovoiturage(String statutAnnonceCovoiturage) {
		this.statutAnnonceCovoiturage = statutAnnonceCovoiturage;
	}
}
