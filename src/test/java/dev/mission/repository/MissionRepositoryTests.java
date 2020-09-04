package dev.mission.repository;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;
import dev.mission.exec.ListerProchainesMissionsParTJM;

@DataJpaTest
public class MissionRepositoryTests {

	private static final Logger LOG = LoggerFactory.getLogger(MissionRepositoryTests.class);

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	MissionRepository missionRepository;

	@BeforeEach
	public void init() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal(100.2));
		mission.setDateDebut(LocalDate.of(2020, 11, 12));
		mission.setDateFin(LocalDate.of(2021, 1, 12));
		this.entityManager.persist(mission);
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal(150.2));
		mission2.setDateDebut(LocalDate.of(2020, 11, 12));
		mission2.setDateFin(LocalDate.of(2021, 1, 3));
		this.entityManager.persist(mission2);
		
		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 3");
		mission3.setTauxJournalier(new BigDecimal(200.5));
		mission3.setDateDebut(LocalDate.of(2021, 4, 12));
		mission3.setDateFin(LocalDate.of(2022, 1, 7));
		this.entityManager.persist(mission3);
	}

	@Test
	void findByDateDebutGreaterThanEqualBis() {

		List<Mission> listeMissions = missionRepository.findAllProchainesMissions(LocalDate.now());
		assertThat(listeMissions.size()).isEqualTo(3);
	}
	
	@Test
	public void findByDateDebutGreaterThanEqual() {
		List<Mission> missions = this.missionRepository.findAllProchainesMissions(LocalDate.now());
		
		for(Mission m : missions) {
			LocalDate dateDeMission = m.getDateDebut();
			assertThat(dateDeMission).isAfter(LocalDate.now());
		}
	}


	@Test 
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqualOK(){
		List<Mission> missions = this.missionRepository.findAllProchainesMissionsParTjm(LocalDate.now(), new BigDecimal("200"));

		assertThat(missions.size()).isEqualTo(1);
	}


}
