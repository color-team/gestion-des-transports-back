package dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.domain.VehiculeEntreprise;

public interface VehiculeEntrepriseRepository extends JpaRepository<VehiculeEntreprise, Long> {
	
	@Query( "SELECT v FROM VehiculeEntreprise v JOIN v.statutVehicule WHERE v.statutVehicule = 'EN_SERVICE'")
	List<VehiculeEntreprise> findVehiculeEnService();
	
	Optional<VehiculeEntreprise> findById( Long id);
}
