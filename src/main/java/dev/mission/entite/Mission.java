package dev.mission.entite;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "mission")
public class Mission {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String libelle;
  private LocalDate dateDebut;
  private LocalDate dateFin;
  private BigDecimal tauxJournalier;
  
  
/**
 * @param id
 * @param libelle
 * @param dateDebut
 * @param dateFin
 * @param tauxJournalier
 */
public Mission(Integer id, String libelle, LocalDate dateDebut, LocalDate dateFin, BigDecimal tauxJournalier) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.tauxJournalier = tauxJournalier;
}


/**
 * 
 */
public Mission() {
	super();
}


/**
 * @return the id
 */
public Integer getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}
/**
 * @return the libelle
 */
public String getLibelle() {
	return libelle;
}
/**
 * @param libelle the libelle to set
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
/**
 * @return the dateDebut
 */
public LocalDate getDateDebut() {
	return dateDebut;
}
/**
 * @param dateDebut the dateDebut to set
 */
public void setDateDebut(LocalDate dateDebut) {
	this.dateDebut = dateDebut;
}
/**
 * @return the dateFin
 */
public LocalDate getDateFin() {
	return dateFin;
}
/**
 * @param dateFin the dateFin to set
 */
public void setDateFin(LocalDate dateFin) {
	this.dateFin = dateFin;
}
/**
 * @return the tauxJournalier
 */
public BigDecimal getTauxJournalier() {
	return tauxJournalier;
}
/**
 * @param tauxJournalier the tauxJournalier to set
 */
public void setTauxJournalier(BigDecimal tauxJournalier) {
	this.tauxJournalier = tauxJournalier;
}
@Override
public String toString() {
	return "Mission [id=" + id + ", libelle=" + libelle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
			+ ", tauxJournalier=" + tauxJournalier + "]";
}
  
  
}
