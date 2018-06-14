package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medication database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Medication.findAll", query="SELECT m FROM Medication m"),
@NamedQuery(name="Medication.findPatient", query="SELECT m FROM Medication m where PatientID = 1"),
@NamedQuery(name="Medication.findbyPatient", query="SELECT m FROM Medication m where PatientID = ?1"),
}) 


public class Medication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int medicationID;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date end;

	@Temporal(TemporalType.DATE)
	private Date start;

	private String usage;

	//bi-directional many-to-one association to Medicament
	@ManyToOne
	@JoinColumn(name="MedicamentID")
	private Medicament medicament;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PatientID")
	private Patient patient;

	public Medication() {
	}

	public int getMedicationID() {
		return this.medicationID;
	}

	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getEnd() {
		return this.end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

public void createMedication(Medicament Medicament, Patient Patient, byte active, Date End, Date Start, String Usage){
	this.setMedicament(Medicament);
	this.setPatient(Patient);
	this.setActive(active);
	this.setEnd(End);
	this.setStart(Start);
	this.setUsage(Usage);		
}

}