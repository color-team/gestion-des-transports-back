package dev.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import dev.domain.enumeration.StatutVehiculeEnum;

@Entity
public class StatutVehicule {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    protected VehiculeEntreprise vehiculeEntreprise;

    @Enumerated(EnumType.STRING)
    protected StatutVehiculeEnum statutVehicule;

    public StatutVehicule() {}
    
	public StatutVehicule(VehiculeEntreprise vehiculeEntreprise, StatutVehiculeEnum statutVehicule) {
		this.vehiculeEntreprise = vehiculeEntreprise;
		this.statutVehicule = statutVehicule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VehiculeEntreprise getVehiculeEntreprise() {
		return vehiculeEntreprise;
	}

	public void setVehiculeEntreprise(VehiculeEntreprise vehiculeEntreprise) {
		this.vehiculeEntreprise = vehiculeEntreprise;
	}

	public StatutVehiculeEnum getStatutVehicule() {
		return statutVehicule;
	}

	public void setStatutVehicule(StatutVehiculeEnum statutVehicule) {
		this.statutVehicule = statutVehicule;
	}
}
