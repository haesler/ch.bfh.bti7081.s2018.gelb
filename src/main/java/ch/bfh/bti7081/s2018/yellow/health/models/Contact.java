package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contactID;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String city;

	private String firstname;

	private String lastname;

	private String mail;

	private String mobile;

	private String phone;

	private String plz;

	private String street;

	//bi-directional many-to-one association to Doctor
	@OneToMany(mappedBy="contact")
	private List<Doctor> doctors;

	//bi-directional many-to-one association to Patient
	@OneToMany(mappedBy="contact")
	private List<Patient> patients1;

	//bi-directional many-to-many association to Patient
	@ManyToMany(mappedBy="contacts")
	private List<Patient> patients2;

	public Contact() {
	}

	public int getContactID() {
		return this.contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date date) {
		this.birthday = date;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlz() {
		return this.plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setContact(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setContact(null);

		return doctor;
	}

	public List<Patient> getPatients1() {
		return this.patients1;
	}

	public void setPatients1(List<Patient> patients1) {
		this.patients1 = patients1;
	}

	public Patient addPatients1(Patient patients1) {
		getPatients1().add(patients1);
		patients1.setContact(this);

		return patients1;
	}

	public Patient removePatients1(Patient patients1) {
		getPatients1().remove(patients1);
		patients1.setContact(null);

		return patients1;
	}

	public List<Patient> getPatients2() {
		return this.patients2;
	}

	public void setPatients2(List<Patient> patients2) {
		this.patients2 = patients2;
	}
	
	//Temp save all attribute
	public void createContact(String fn, String ln, String str, String plz, String City, String Phone, String Mobile, String Mail, java.sql.Date date){
		this.setFirstname(fn);
		this.setLastname(ln);
		this.setStreet(str);
		this.setPlz(plz);
		this.setCity(City);
		this.setPhone(Phone);
		this.setMobile(Mobile);
		this.setMail(Mail);
		this.setBirthday(date);
	}

}