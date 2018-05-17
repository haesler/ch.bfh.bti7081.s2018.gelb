package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the doctor database table.
 * 
 */
@Entity
@NamedQuery(name="Doctor.findAll", query="SELECT d FROM Doctor d")
public class Doctor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int doctorID;

	//bi-directional many-to-one association to Contact
	@ManyToOne
	@JoinColumn(name="ContactID")
	private Contact contact;

	//bi-directional many-to-one association to Praxi
	@ManyToOne
	@JoinColumn(name="PraxisID")
	private Praxi praxi;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="doctor")
	private List<Patient> patients;

	public Doctor() {
	}

	public int getDoctorID() {
		return this.doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Praxi getPraxi() {
		return this.praxi;
	}

	public void setPraxi(Praxi praxi) {
		this.praxi = praxi;
	}

	public List<Patient> getPatients() {
		return this.patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public Patient addPatient(Patient patient) {
		getPatients().add(patient);
		patient.setDoctor(this);

		return patient;
	}

	public Patient removePatient(Patient patient) {
		getPatients().remove(patient);
		patient.setDoctor(null);

		return patient;
	}

}