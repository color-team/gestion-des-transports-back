package dev.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.domain.ReservationCovoiturage;
import dev.repository.ReservationCovoiturageRepository;

@Service
public class ReservationCovoiturageService {

	protected ReservationCovoiturageRepository reservationCovoiturageRepo;

	public ReservationCovoiturageService(ReservationCovoiturageRepository reservationCovoiturageRepo) {
		this.reservationCovoiturageRepo = reservationCovoiturageRepo;
	}
	
	public List<ReservationCovoiturage> findAll() {
		return reservationCovoiturageRepo.findAll();
	}

//	@Transactional
//	public ReservationCovoiturage create(ReservationCovoiturageDto reservationCovoiturageDto) {
//		ReservationCovoiturage reservationCovoiturage = ReservationCovoiturageMapper.INSTANCE.reservationCovoiturageDtoToReservationCovoiturage( reservationCovoiturageDto );
//		reservationCovoiturageRepo.save(reservationCovoiturage);
//		
//		return reservationCovoiturage;
//	}

	public List<ReservationCovoiturage> findByUtilisateurMatricule(String matricule) {
		return reservationCovoiturageRepo.findByUtilisateurMatricule(matricule);
	}

	public List<ReservationCovoiturage> findAllInFuture() {
		return reservationCovoiturageRepo.findByDateDepartAfter(LocalDateTime.now());
	}

}
