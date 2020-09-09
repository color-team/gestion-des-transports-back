package dev.controller.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.controller.dto.DispoResrvationEntrepriseDto;
import dev.controller.dto.ReservationChauffeurPlanningDto;
import dev.controller.dto.ReservationEntrepriseAffichageDto;
import dev.controller.dto.ReservationEntrepriseDto;
import dev.controller.dto.ReservationEntrepriseInfosDto;
import dev.controller.dto.VehiculeSansChauffeurDto;
import dev.domain.ReservationChauffeur;
import dev.domain.ReservationEntreprise;
import dev.domain.ReservationSansChauffeur;
import dev.domain.StatutReservationEntreprise;
import dev.domain.Utilisateur;
import dev.domain.VehiculeEntreprise;
import dev.domain.enumeration.StatutReservationEntrepriseEnum;

@Component
public class ReservationEntrepriseMapper {
	
	public VehiculeSansChauffeurDto toVehiculeDto( VehiculeEntreprise vehicule) {
		return new VehiculeSansChauffeurDto(
				vehicule.getId(),
				vehicule.getImmatriculation(),
				vehicule.getMarque(),
				vehicule.getModele(),
				vehicule.getPhotoUrl(),
				vehicule.getCategorie(),
				vehicule.getStatutVehicule().getStatutVehicule().name(),
				vehicule.getReservationsEntreprise().stream()
				.map( reservation -> this.toDispoDto( reservation))
				.collect( Collectors.toList())
				);
	}
	
	public DispoResrvationEntrepriseDto toDispoDto( ReservationEntreprise reservation) {
		return new DispoResrvationEntrepriseDto(
				reservation.getId(),
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise().name()
				);
	}
	
	public ReservationSansChauffeur dtoToReservationSansChauffeur( ReservationEntrepriseDto reservationDto, 
			VehiculeEntreprise vehicule, Utilisateur conducteur) {
		
		StatutReservationEntreprise statut = new StatutReservationEntreprise();
		statut.setStatutReservationEntreprise( StatutReservationEntrepriseEnum.ACCEPTEE);
		
		ReservationSansChauffeur reservation = new ReservationSansChauffeur(
				reservationDto.getDateDepart(),
				reservationDto.getDateArrivee(),
				null,
				null,
				conducteur,
				vehicule,
				statut);
		
        statut.setReservationEntreprise( reservation);
        reservation.setStatutReservationEntreprise( statut);
        vehicule.addReservationEntreprise( reservation);
        reservation.setVehiculeEntreprise( vehicule);
        
		return reservation;
	}
	
	public ReservationChauffeur dtoToReservationAvecChauffeur( ReservationEntrepriseDto reservationDto, 
			VehiculeEntreprise vehicule, Utilisateur passager) {
		
		StatutReservationEntreprise statut = new StatutReservationEntreprise();
		statut.setStatutReservationEntreprise( StatutReservationEntrepriseEnum.EN_ATTENTE);
		
		ReservationChauffeur reservation = new ReservationChauffeur(
				reservationDto.getDateDepart(),
				null,
				null,
				null,
				reservationDto.getDateArrivee(),
				vehicule,
				statut,
				passager);
		
        statut.setReservationEntreprise( reservation);
        reservation.setStatutReservationEntreprise( statut);
        vehicule.addReservationEntreprise( reservation);
        reservation.setVehiculeEntreprise( vehicule);
        
		return reservation;
	}
	
	public ReservationEntrepriseInfosDto sansChauffeurtoInfosDto( ReservationSansChauffeur reservation) {
		return new ReservationEntrepriseInfosDto(
				reservation.getConducteur().getInfos(),
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getVehiculeEntreprise().getInfos(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise().name(),
				false);
	}
	
	public ReservationEntrepriseInfosDto avecChauffeurtoInfosDto( ReservationChauffeur reservation) {
		return new ReservationEntrepriseInfosDto(
				reservation.getPassager().getInfos(),
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getVehiculeEntreprise().getInfos(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise().name(),
				true);
	}
	
	public ReservationEntrepriseAffichageDto avecChauffeurToAffichageDto( ReservationChauffeur reservation) {
		String infosChauffeur = "";
		
		if ( reservation.getChauffeur() != null) {
			infosChauffeur = reservation.getChauffeur().getInfos();
		}
		
		return new ReservationEntrepriseAffichageDto(
				infosChauffeur,
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getVehiculeEntreprise().getImmatriculation(),
				reservation.getVehiculeEntreprise().getMarque(),
				reservation.getVehiculeEntreprise().getModele(),
				reservation.getId(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise());
	}
	
	public ReservationEntrepriseAffichageDto sansChauffeurToAffichageDto( ReservationSansChauffeur reservation) {
		
		return new ReservationEntrepriseAffichageDto(
				"",
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getVehiculeEntreprise().getImmatriculation(),
				reservation.getVehiculeEntreprise().getMarque(),
				reservation.getVehiculeEntreprise().getModele(),
				reservation.getId(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise());
	}
	
	public ReservationChauffeurPlanningDto avecChauffeurToPlanningDto( ReservationChauffeur reservation) {
		return new ReservationChauffeurPlanningDto(
				reservation.getDateDepart(),
				reservation.getDateArrivee(),
				reservation.getPassager().getInfos(),
				reservation.getPassager().getTelephone(),
				reservation.getVehiculeEntreprise().getImmatriculation(),
				reservation.getStatutReservationEntreprise().getStatutReservationEntreprise(),
				reservation.getId());
	}
	
}
