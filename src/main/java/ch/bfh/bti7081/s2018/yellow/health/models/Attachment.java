package ch.bfh.bti7081.s2018.yellow.health.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the attachment database table.
 * 
 */
@Entity
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int attachmentID;

	private byte[] file;

	//bi-directional many-to-one association to Historyentry
	@ManyToOne
	@JoinColumn(name="HistoryEntryID")
	private Historyentry historyentry;

	public Attachment() {
	}

	public int getAttachmentID() {
		return this.attachmentID;
	}

	public void setAttachmentID(int attachmentID) {
		this.attachmentID = attachmentID;
	}

	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Historyentry getHistoryentry() {
		return this.historyentry;
	}

	public void setHistoryentry(Historyentry historyentry) {
		this.historyentry = historyentry;
	}

}