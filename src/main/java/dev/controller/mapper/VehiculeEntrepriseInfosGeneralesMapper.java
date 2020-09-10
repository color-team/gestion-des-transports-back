package dev.controller.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import dev.controller.dto.VehiculeEntrepriseInfosGeneralesDto;
import dev.domain.ReservationEntreprise;
import dev.domain.StatutVehicule;
import dev.domain.VehiculeEntreprise;
import dev.domain.enumeration.StatutVehiculeEnum;

@Component
public class VehiculeEntrepriseInfosGeneralesMapper {

	public VehiculeEntreprise vehiculeEntrepriseInfosGeneralesDtoToVehiculeEntreprise(
			VehiculeEntrepriseInfosGeneralesDto vehiculeEntrepriseInfosGeneralesDto) {
		return new VehiculeEntreprise(
				vehiculeEntrepriseInfosGeneralesDto.getImmatriculation(),
				vehiculeEntrepriseInfosGeneralesDto.getMarque(),
				vehiculeEntrepriseInfosGeneralesDto.getPhotoUrl(),
				null,
				vehiculeEntrepriseInfosGeneralesDto.getModele(),
				vehiculeEntrepriseInfosGeneralesDto.getCategorie(),
				vehiculeEntrepriseInfosGeneralesDto.getNbPlaces().byteValue(),
				null,
				new ArrayList<ReservationEntreprise>(),
				new StatutVehicule(null, StatutVehiculeEnum.valueOf(vehiculeEntrepriseInfosGeneralesDto.getStatutVehicule()))
		);
	}
}
