package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.AnnonceCovoiturageDto;
import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.mapper.ReservationCovoiturageMapper;
import dev.domain.ReservationCovoiturage;
import dev.repository.ReservationCovoituragePassagerRepository;
import dev.repository.ReservationCovoiturageRepository;

@Service
public class ReservationCovoiturageService {

	protected ReservationCovoiturageRepository reservationCovoiturageRepo;
	
	protected ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo;
	
	public ReservationCovoiturageService(ReservationCovoiturageRepository reservationCovoiturageRepo,
			ReservationCovoituragePassagerRepository reservationCovoituragePassagerRepo) {
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
		this.reservationCovoituragePassagerRepo = reservationCovoituragePassagerRepo;
	}



	@Transactional
	public ReservationCovoiturage create( AnnonceCovoiturageDto annonceCovoitDto) {
		ReservationCovoiturage resaCovoit = ReservationCovoiturageMapper.fromDto( annonceCovoitDto );
		reservationCovoiturageRepo.save( resaCovoit);
		
		return resaCovoit;
	}


	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
		return reservationCovoituragePassagerRepo.findByPassagerMatricule(matricule).stream().map(reservationCovoituragePassager -> ReservationCovoiturageMapper.ReservationCovoituragePassagerToDto(reservationCovoituragePassager)).collect(Collectors.toList());
	}

}
