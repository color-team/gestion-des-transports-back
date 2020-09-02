package dev.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.controller.dto.ReservationCovoiturageDto;
import dev.controller.mapper.ReservationCovoiturageMapper;
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



//	@Transactional
//	public ReservationCovoiturage create(ReservationCovoiturageDto reservationCovoiturageDto) {
//		ReservationCovoiturage reservationCovoiturage = ReservationCovoiturageMapper.INSTANCE.reservationCovoiturageDtoToReservationCovoiturage( reservationCovoiturageDto );
//		reservationCovoiturageRepo.save(reservationCovoiturage);
//		
//		return reservationCovoiturage;
//	}


	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
		return reservationCovoituragePassagerRepo.findByPassagerMatricule(matricule).stream().map(reservationCovoituragePassager -> ReservationCovoiturageMapper.ReservationCovoituragePassagerToDto(reservationCovoituragePassager)).collect(Collectors.toList());
	}

}
