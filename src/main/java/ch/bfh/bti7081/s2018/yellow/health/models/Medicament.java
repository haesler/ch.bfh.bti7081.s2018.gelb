package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicament database table.
 * 
 */
@Entity
@NamedQuery(name="Medicament.findAll", query="SELECT m FROM Medicament m")
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int medicamentID;

	private String description;

	private String name;

	//bi-directional many-to-one association to Medication
	@OneToMany(mappedBy="medicament")
	private List<Medication> medications;

	public Medicament() {
	}

	public int getMedicamentID() {
		return this.medicamentID;
	}

	public void setMedicamentID(int medicamentID) {
		this.medicamentID = medicamentID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Medication> getMedications() {
		return this.medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
	}

	public Medication addMedication(Medication medication) {
		getMedications().add(medication);
		medication.setMedicament(this);

		return medication;
	}

	public Medication removeMedication(Medication medication) {
		getMedications().remove(medication);
		medication.setMedicament(null);

		return medication;
	}
	
	public void createMedicament(String name, String description){
		this.setName(name);
		this.setDescription(description);
	}

}