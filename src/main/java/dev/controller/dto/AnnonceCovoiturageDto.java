package dev.controller.dto;

import java.time.LocalDateTime;

public class AnnonceCovoiturageDto {

	protected Long id;
	
	protected LocalDateTime dateDepart;

	protected String infosDepart;

	protected String infosDestination;

	protected String infosVehiculeParticulier;

	protected String infosConducteur;

	protected Integer nbPlacesDisponibles;

	public AnnonceCovoiturageDto() {
	}

	public AnnonceCovoiturageDto(Long id, LocalDateTime dateDepart, String infosDepart, String infosDestination,
			String infosVehiculeParticulier, String infosConducteur, Integer nbPlacesDispo) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.infosDepart = infosDepart;
		this.infosDestination = infosDestination;
		this.infosVehiculeParticulier = infosVehiculeParticulier;
		this.infosConducteur = infosConducteur;
		this.nbPlacesDisponibles = nbPlacesDispo;
	}
	
	public void addPassager() {
		setNbPlacesDisponibles(getNbPlacesDisponibles() - 1);
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

	public String getInfosVehiculeParticulier() {
		return infosVehiculeParticulier;
	}

	public void setInfosVehiculeParticulier(String infosVehiculeParticulier) {
		this.infosVehiculeParticulier = infosVehiculeParticulier;
	}

	public String getInfosConducteur() {
		return infosConducteur;
	}

	public void setInfosConducteur(String infosConducteur) {
		this.infosConducteur = infosConducteur;
	}

	public Integer getNbPlacesDisponibles() {
		return nbPlacesDisponibles;
	}

	public void setNbPlacesDisponibles(Integer nbPlacesDisponibles) {
		this.nbPlacesDisponibles = nbPlacesDisponibles;
	}
}
