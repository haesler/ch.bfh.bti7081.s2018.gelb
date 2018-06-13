package ch.bfh.bti7081.s2018.yellow.health.ui.components.searchhistory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.bfh.bti7081.s2018.yellow.health.repo.HistoryEntryRepository;

@Service
public class SearchHistoryModel {

	@Autowired
	HistoryEntryRepository repo;
	//List<Historyentry> entrys;
	
	
	public SearchHistoryModel(HistoryEntryRepository repo){
		this.repo =repo;
		//entrys = repo.findAll();
		//dataProvider =  DataProvider.ofCollection(entrys);
	}

}


