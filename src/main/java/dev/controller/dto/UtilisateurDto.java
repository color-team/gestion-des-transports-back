package dev.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dev.domain.Utilisateur;
import dev.domain.enumeration.Role;

/**
 * Structure modèlisant un utilisateur servant à communiquer avec l'extérieur (WEB API).
 */
public class UtilisateurDto {

    private String email;
    private String nom;
    private String prenom;
    private List<Role> roles = new ArrayList<>();
    private String matricule;

    public UtilisateurDto() {}
    
    public UtilisateurDto(Utilisateur user) {
        this.email = user.getEmail();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.roles = user.getRoles().stream().map(roleUtilisateur -> roleUtilisateur.getRole()).collect(Collectors.toList());
        this.matricule = user.getMatricule();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
}
