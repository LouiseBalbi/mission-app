package dev.mission.exec;

import java.math.BigDecimal;
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
@Profile("listerTjm")
public class ListerProchainesMissionsParTJM implements Runnable{
	
	private static final Logger LOG = LoggerFactory.getLogger(ListerProchainesMissionsParTJM.class);

	private MissionRepository missionRepository;

	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		BigDecimal big = new BigDecimal(200.0);
		List<Mission> listeProchainesMissionsParTjm = missionRepository.findAllProchainesMissionsParTjm(LocalDate.now(), big);
		if(listeProchainesMissionsParTjm.isEmpty()) {
			LOG.warn("Aucune mission prévue");
		}else {
			for(Mission mission : listeProchainesMissionsParTjm) {
				LOG.warn("Mission [id={} dateDebut={} dateFin={} libelle={} tauxJournaliers={}]", mission.getId(), mission.getDateDebut(), mission.getDateFin(), mission.getLibelle(), mission.getTauxJournalier());
			}
		}
		
	}

}
