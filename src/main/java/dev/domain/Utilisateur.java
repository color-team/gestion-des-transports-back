package dev.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String nom;

    protected String prenom;

    protected String email;

    protected String motDePasse;
    
    protected String matricule;

    @OneToMany(mappedBy = "utilisateur")
    protected List<RoleUtilisateur> roles;
    
    @OneToMany(mappedBy = "conducteur")
    protected List<ReservationCovoiturage> annoncesCovoiturage;
    
    @OneToMany(mappedBy = "chauffeur")
    protected List<ReservationChauffeur> courses;
    
    @OneToMany(mappedBy = "passager")
    protected List<ReservationChauffeur> reservationsChauffeur;
    
    @OneToMany(mappedBy = "conducteur")
    protected List<ReservationSansChauffeur> reservationsSansChauffeur;
    
    @ManyToMany(mappedBy = "passagers")
    protected List<ReservationCovoiturage> reservationsCovoiturage;

    public Utilisateur() {}
    
    public Utilisateur(String nom, String prenom, String email, String motDePasse, String matricule,
			List<RoleUtilisateur> roles) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.matricule = matricule;
		this.roles = roles;
	}
    
    public String getInfos() {
    	return prenom + " " + nom.toUpperCase();
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<RoleUtilisateur> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleUtilisateur> roles) {
        this.roles = roles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public List<ReservationCovoiturage> getAnnoncesCovoiturage() {
		return annoncesCovoiturage;
	}

	public void setAnnoncesCovoiturage(List<ReservationCovoiturage> annoncesCovoiturage) {
		this.annoncesCovoiturage = annoncesCovoiturage;
	}

	public List<ReservationChauffeur> getCourses() {
		return courses;
	}

	public void setCourses(List<ReservationChauffeur> courses) {
		this.courses = courses;
	}

	public List<ReservationChauffeur> getReservationsChauffeur() {
		return reservationsChauffeur;
	}

	public void setReservationsChauffeur(List<ReservationChauffeur> reservationsChauffeur) {
		this.reservationsChauffeur = reservationsChauffeur;
	}

	public List<ReservationSansChauffeur> getReservationsSansChauffeur() {
		return reservationsSansChauffeur;
	}

	public void setReservationsSansChauffeur(List<ReservationSansChauffeur> reservationsSansChauffeur) {
		this.reservationsSansChauffeur = reservationsSansChauffeur;
	}

	public List<ReservationCovoiturage> getReservationsCovoiturage() {
		return reservationsCovoiturage;
	}

	public void setReservationsCovoiturage(List<ReservationCovoiturage> reservationsCovoiturage) {
		this.reservationsCovoiturage = reservationsCovoiturage;
	}
}
