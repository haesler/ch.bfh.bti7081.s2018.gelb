package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory;

import java.util.List;

import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;

import ch.bfh.bti7081.s2018.yellow.health.models.History;
import ch.bfh.bti7081.s2018.yellow.health.models.Historyentry;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;

public interface SearchHistoryView extends View {
	
	interface SearchHistoryViewListener {
        void filter1(String value, ValueProvider<History, ?> valueProvider);
    }
	
	public void addListener(SearchHistoryViewListener listener);
	
	public void showEntrys(List<History> entry);
}


