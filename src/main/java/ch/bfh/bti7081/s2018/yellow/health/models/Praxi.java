package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the praxis database table.
 * 
 */
@Entity
@Table(name="praxis")
@NamedQuery(name="Praxi.findAll", query="SELECT p FROM Praxi p")
public class Praxi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int praxisID;

	private int fax;

	private String mail;

	private String name;

	private int phone;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="praxi")
	private List<Doctor> doctors;

	public Praxi() {
	}

	public int getPraxisID() {
		return this.praxisID;
	}

	public void setPraxisID(int praxisID) {
		this.praxisID = praxisID;
	}

	public int getFax() {
		return this.fax;
	}

	public void setFax(int fax) {
		this.fax = fax;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setPraxi(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setPraxi(null);

		return doctor;
	}

}