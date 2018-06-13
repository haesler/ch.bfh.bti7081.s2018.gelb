package ch.bfh.bti7081.s2018.yellow.health.ui.components.history;

import java.sql.Date;

import com.vaadin.navigator.View;

public interface AddHistoryView extends View{

	interface AddHistoryViewListener{
	}
	
	public void addListener(AddHistoryViewListener listener);
	void setNotification(String msg, String style);
	String getTitle();
	String getDescription();
	Date getDate();
	String getAttachment();
	AddHistoryPresenter getPresenter();
	

}
