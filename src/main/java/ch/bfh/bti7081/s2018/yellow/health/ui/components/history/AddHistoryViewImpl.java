package ch.bfh.bti7081.s2018.yellow.health.ui.components.history;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import ch.bfh.bti7081.s2018.yellow.health.ui.components.history.AddHistoryView.AddHistoryViewListener;
import ch.bfh.bti7081.s2018.yellow.health.repo.HistoryEntryRepository;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.history.AddHistoryPresenter;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddHistoryLayout;

@Service
public class AddHistoryViewImpl extends VerticalLayout implements AddHistoryView {
	
	List<AddHistoryViewListener> listeners = new ArrayList<AddHistoryViewListener>();
	private AddHistoryPresenter presenter;
	private AddHistoryLayout AddHistoryForm;
	AddHistoryView view;
	private HistoryEntryRepository repoHistory;
	
	private static AddHistoryViewImpl repo;
	
	@Autowired
	public AddHistoryViewImpl() {
		setSizeFull();
		AddHistoryViewImpl.repo = repo;
		AddHistoryForm = new AddHistoryLayout();
		addComponent(AddHistoryForm);
		setComponentAlignment(AddHistoryForm, Alignment.MIDDLE_CENTER);
		
		this.presenter = new AddHistoryPresenter(this, repoHistory);
		
	}
	
	@Override
	public void addListener(AddHistoryViewListener listener) {
		System.out.println("AddListener in AddHistoryViewImpl.java");
		listeners.add(listener);
	}
		
	@Override
	public String getTitle() {
		return AddHistoryForm.getTxt_TitleNew().getValue();
	}
	
	@Override
	public java.sql.Date getDate() {
		LocalDate tempDate = AddHistoryForm.getDt_DateNew().getValue();
		return java.sql.Date.valueOf(tempDate);
	}
	
	@Override
	public String getDescription() {
		return AddHistoryForm.getTxt_DescNew().getValue();
	}
	
	@Override
	public String getAttachment() {
		return "No upload at the moment.";
	}

	@Override
	public void setNotification(String msg, String style) {
		AddHistoryForm.getLbl_Notify().setValue(msg);
		AddHistoryForm.getLbl_Notify().setStyleName(style);
		AddHistoryForm.getLbl_Notify().setVisible(true);
	}
	
}
