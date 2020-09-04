package dev.mission.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer>{

	@Query("select m from Mission m where m.dateDebut >= NOW()")
	List<Mission> findAllProchainesMissions(LocalDate date);
	
	@Query("select m from Mission m where m.dateDebut >= NOW() and m.tauxJournalier > 200")
	List<Mission> findAllProchainesMissionsParTjm(LocalDate date, BigDecimal tauxJournalier);

	
}
