package dev.controller.dto;

public class VehiculeParticulierDto {
	
    protected String immatriculation;
    
    protected String marque;
    
    protected String modele;
    
    protected int places;
    
    public VehiculeParticulierDto() {}

	public VehiculeParticulierDto(String immatriculation, String marque, String modele, int places) {
		super();
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.places = places;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getPlaces() {
		return places;
	}

	public void setPlaces(int places) {
		this.places = places;
	}
}
