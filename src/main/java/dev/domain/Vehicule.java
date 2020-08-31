package dev.domain;

import java.sql.Blob;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicule {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	protected String immatriculation;
	
	protected String marque;
	
	protected String photoUrl;
	
	protected Blob photo;
	
	protected String modele;
	
	protected String categorie;

	public Vehicule() {}
	
	public Vehicule(String immatriculation, String marque, String photoUrl, Blob photo, String modele,
			String categorie) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.photoUrl = photoUrl;
		this.photo = photo;
		this.modele = modele;
		this.categorie = categorie;
	}
	public String getInfos() {
		return marque + " " + modele;
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

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
}
