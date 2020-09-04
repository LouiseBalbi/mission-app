package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("insert")
public class InsererMission implements Runnable {
	private MissionRepository missionRepository;

	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 5");
		mission.setTauxJournalier(new BigDecimal("175.2"));
		mission.setDateDebut(LocalDate.of(2020, 1, 11));
		mission.setDateFin(LocalDate.of(2021, 1, 4));
		this.missionRepository.save(mission);
	}
}
