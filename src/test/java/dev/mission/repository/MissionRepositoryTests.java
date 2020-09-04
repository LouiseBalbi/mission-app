package dev.mission.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;

import dev.mission.entite.Mission;


@DataJpaTest
@Profile("lister")
public class MissionRepositoryTests {

	@Autowired
	TestEntityManager entityManager;
	@Autowired
	MissionRepository missionRepository;

	@Test
	void findByDateDebutGreaterThanEqual() {
//		entityManager.persist(new Mission());
//		List<Mission> listeMissions = missionRepository.findAllProchainesMissions(LocalDate.now());
//		assertThat(listeMissions.size()).isEqualTo(2);
	}

	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		// TODO insérer des données avec `entityManager`
		// TODO exécuter la requête
		// TODO vérifier le résultat
	}

}
