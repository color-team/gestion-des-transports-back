package dev.controller.dto;

import java.util.List;

public class VehiculeSansChauffeurDto {
	
	protected Long id;

	protected String immatriculation;
    
    protected String marque;
    
    protected String modele;
    
    protected String photoUrl;
    
    protected String categorie;
    
    protected String statutVehivule;
    
    protected List<DispoResrvationSansChauffeurDto> dispoReservation;
    
    public VehiculeSansChauffeurDto() {}

	public VehiculeSansChauffeurDto(Long id, String immatriculation, String marque, String modele, String photoUrl,
			String categorie, String statutVehivule, List<DispoResrvationSansChauffeurDto> dispoReservation) {
		super();
		this.id = id;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.photoUrl = photoUrl;
		this.categorie = categorie;
		this.statutVehivule = statutVehivule;
		this.dispoReservation = dispoReservation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getStatutVehivule() {
		return statutVehivule;
	}

	public void setStatutVehivule(String statutVehivule) {
		this.statutVehivule = statutVehivule;
	}

	public List<DispoResrvationSansChauffeurDto> getDispoReservation() {
		return dispoReservation;
	}

	public void setDispoReservation(List<DispoResrvationSansChauffeurDto> dispoReservation) {
		this.dispoReservation = dispoReservation;
	}

}
