package dev.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Localisation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	protected String adresse;
	
	protected String ville;
	
	protected Integer codePostal;
	
	protected Float latitude;
	
	protected Float longitude;

	public Localisation() {}
	
	public Localisation(String adresse, String ville, Integer codePostal, Float latitude, Float longitude) {
		this.adresse = adresse;
		this.ville = ville;
		this.codePostal = codePostal;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	
}
