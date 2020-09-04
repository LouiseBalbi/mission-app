package dev.mission.exec;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.MissionAppApplication;
import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements Runnable{
	
	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissions.class);

	private MissionRepository missionRepository;

	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		List<Mission> listeProchainesMissions = missionRepository.findAllProchainesMissions(LocalDate.now());
		if(listeProchainesMissions.isEmpty()) {
			LOG.warn("Aucune mission prévue");
		}else {
			for(Mission mission : listeProchainesMissions) {
				LOG.warn("Mission [id={} dateDebut={} dateFin={} libelle={} tauxJournaliers={}]", mission.getId(), mission.getDateDebut(), mission.getDateFin(), mission.getLibelle(), mission.getTauxJournalier());
			}
		}
	}

}
