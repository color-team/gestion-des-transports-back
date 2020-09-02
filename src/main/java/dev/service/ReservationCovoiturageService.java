package dev.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

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

//	public List<ReservationCovoiturageDto> findAll() {
//		return reservationCovoiturageRepo.findAll().stream().map(reservationCovoiturage -> ReservationCovoiturageMapper.toDto(reservationCovoiturage)).collect(Collectors.toList());
//	}

//	@Transactional
//	public ReservationCovoiturage create(ReservationCovoiturageDto reservationCovoiturageDto) {
//		ReservationCovoiturage reservationCovoiturage = ReservationCovoiturageMapper.INSTANCE.reservationCovoiturageDtoToReservationCovoiturage( reservationCovoiturageDto );
//		reservationCovoiturageRepo.save(reservationCovoiturage);
//		
//		return reservationCovoiturage;
//	}

//	public List<ReservationCovoiturageDto> findByPassagerMatricule(String matricule) {
//		return reservationCovoiturageRepo.findByPassagerMatricule(matricule).stream().map(reservationCovoiturage -> ReservationCovoiturageMapper.toDto(reservationCovoiturage)).collect(Collectors.toList());
//	}
//
//	public List<ReservationCovoiturageDto> findAllInFuture() {
//		List<ReservationCovoiturage> reservationsCovoiturage = reservationCovoiturageRepo.findByDateDepartAfter(LocalDateTime.now());
//		
//		return reservationsCovoiturage.stream().map(reservationCovoiturage -> ReservationCovoiturageMapper.toDto(reservationCovoiturage)).collect(Collectors.toList());
//	}
//	
//	public List<ReservationCovoiturageDto> findAllInPast() {
//		List<ReservationCovoiturage> reservationsCovoiturage = reservationCovoiturageRepo.findByDateDepartBefore(LocalDateTime.now());
//		
//		return reservationsCovoiturage.stream().map(reservationCovoiturage -> ReservationCovoiturageMapper.toDto(reservationCovoiturage)).collect(Collectors.toList());
//	}

	public List<ReservationCovoiturageDto> findByPassagerMatriculeTest(String matricule) {
		return reservationCovoituragePassagerRepo.findByPassagerMatricule(matricule).stream().map(reservationCovoituragePassager -> ReservationCovoiturageMapper.ReservationCovoituragePassagerToDto(reservationCovoituragePassager)).collect(Collectors.toList());
	}

}
