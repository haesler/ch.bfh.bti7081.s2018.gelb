package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory;


import java.util.List;

import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.bfh.bti7081.s2018.yellow.health.repo.HistoryRepository;
import ch.bfh.bti7081.s2018.yellow.health.models.History;

@Service
public class SearchHistoryModel {

	
	HistoryRepository repo;
	List<History> entrys;
	ListDataProvider<History> dataProvider;
	
	@Autowired
	public SearchHistoryModel(HistoryRepository repo){
		this.repo =repo;
		entrys = repo.findAll();
		dataProvider =  DataProvider.ofCollection(entrys);
	}
	
	public void findByPatient(int Patient){
		entrys = repo.findbyPatient(Patient);
		dataProvider =  DataProvider.ofCollection(entrys);
	}

}


