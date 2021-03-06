package dev.controller.dto;

import java.time.LocalDateTime;

public class AnnonceCovoiturageCreerDto {
	
	protected LocalDateTime dateDepart;

	protected String depart;

	protected String destination;
	
	protected byte nbPassager;

	protected VehiculeParticulierDto vehicule;

	protected String conducteur;
	
	public AnnonceCovoiturageCreerDto() {}

	public AnnonceCovoiturageCreerDto(LocalDateTime dateDepart, String depart, String destination, byte nbPassager,
			VehiculeParticulierDto vehicule, String conducteur) {
		super();
		this.dateDepart = dateDepart;
		this.depart = depart;
		this.destination = destination;
		this.nbPassager = nbPassager;
		this.vehicule = vehicule;
		this.conducteur = conducteur;
	}

	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public byte getNbPassager() {
		return nbPassager;
	}

	public void setNbPassager(byte nbPassager) {
		this.nbPassager = nbPassager;
	}

	public VehiculeParticulierDto getVehicule() {
		return vehicule;
	}

	public void setVehicule(VehiculeParticulierDto vehicule) {
		this.vehicule = vehicule;
	}

	public String getConducteur() {
		return conducteur;
	}

	public void setConducteur(String conducteur) {
		this.conducteur = conducteur;
	}
}
