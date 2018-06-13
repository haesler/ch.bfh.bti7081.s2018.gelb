package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the historyentry database table.
 * 
 */
@Entity
@NamedQuery(name="Historyentry.findAll", query="SELECT h FROM Historyentry h")
public class Historyentry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int historyEntryID;

	private byte active;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String entry;

	private String title;

	//bi-directional many-to-one association to Attachment
	@OneToMany(mappedBy="historyentry")
	private List<Attachment> attachments;

	//bi-directional many-to-one association to Patient
	@ManyToOne
	@JoinColumn(name="PatientID")
	private Patient patient;

	public Historyentry() {
	}

	public int getHistoryEntryID() {
		return this.historyEntryID;
	}

	public void setHistoryEntryID(int historyEntryID) {
		this.historyEntryID = historyEntryID;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEntry() {
		return this.entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public Attachment addAttachment(Attachment attachment) {
		getAttachments().add(attachment);
		attachment.setHistoryentry(this);

		return attachment;
	}

	public Attachment removeAttachment(Attachment attachment) {
		getAttachments().remove(attachment);
		attachment.setHistoryentry(null);

		return attachment;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void createEntry(Patient patient, String title, String entry, byte active, java.sql.Date date) {
		this.setPatient(patient);
		this.setTitle(title);
		this.setEntry(entry);
		this.setActive(active);
		this.setDate(date);
	}

}