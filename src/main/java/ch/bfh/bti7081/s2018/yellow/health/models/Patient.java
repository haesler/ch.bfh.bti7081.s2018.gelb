package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the patient database table.
 * 
 */
@Entity
@NamedQuery(name="Patient.findAll", query="SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientID;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date end;

	@Temporal(TemporalType.DATE)
	private Date start;

	//bi-directional many-to-one association to Historyentry
	@OneToMany(mappedBy="patient")
	private List<Historyentry> historyentries;

	//bi-directional many-to-one association to Medication
	@OneToMany(mappedBy="patient")
	private List<Medication> medications;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="ContactID")
	private Contact contact;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="DoctorID")
	private Doctor doctor;

	//bi-directional many-to-one association to Insurance
	@ManyToOne
	@JoinColumn(name="InsuranceID")
	private Insurance insurance;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinTable(
		name="relative"
		, joinColumns={
			@JoinColumn(name="PatientID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ContactID")
			}
		)
	private List<Contact> contacts;

	public Patient() {
	}

	public int getPatientID() {
		return this.patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
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

	public List<Historyentry> getHistoryentries() {
		return this.historyentries;
	}

	public void setHistoryentries(List<Historyentry> historyentries) {
		this.historyentries = historyentries;
	}

	public Historyentry addHistoryentry(Historyentry historyentry) {
		getHistoryentries().add(historyentry);
		historyentry.setPatient(this);

		return historyentry;
	}

	public Historyentry removeHistoryentry(Historyentry historyentry) {
		getHistoryentries().remove(historyentry);
		historyentry.setPatient(null);

		return historyentry;
	}

	public List<Medication> getMedications() {
		return this.medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

	public Medication addMedication(Medication medication) {
		getMedications().add(medication);
		medication.setPatient(this);

		return medication;
	}

	public Medication removeMedication(Medication medication) {
		getMedications().remove(medication);
		medication.setPatient(null);

		return medication;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Insurance getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}