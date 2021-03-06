package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.data.ValueProvider;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Grid.Column;
import com.vaadin.ui.components.grid.HeaderCell;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;

import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;
import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament.AddMedicamentModel;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddMedicationLayout;


@Component
public class AddMedicationViewImpl extends AbsoluteLayout implements AddMedicationView{

	private static final long serialVersionUID = 1L;
	
	List<AddMedicationViewListener> listeners = new ArrayList<AddMedicationViewListener>();
	private AddMedicationPresenter presenter;
	private AddMedicationLayout layout;
	Grid<Medicament> grid = new Grid<Medicament>(Medicament.class);

	@Autowired	
	public AddMedicationViewImpl(AddMedicationModel service, AddMedicamentModel modelMeds){
		layout = new AddMedicationLayout();
		layout.getBu_save().addClickListener(e -> this.buttonClick());
		this.presenter = new AddMedicationPresenter(service, modelMeds, this);
		loadGridView();
		addComponent(layout);
	}
	
	private void loadGridView(){

		// Create a header row to hold column filters
		HeaderRow filterRow = grid.appendHeaderRow();
		grid.setColumns("name", "description");
		for (Column<Medicament, ?> pid: grid.getColumns()) {
		    HeaderCell cell = filterRow.getCell(pid.getId());
		    final TextField filter = new TextField();
		    filter.setPlaceholder("Filter");
		    filter.addValueChangeListener(e -> {refresh(filter.getValue(),  pid.getValueProvider());});
		    filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
		    cell.setComponent(filter);
		}
		addComponent(grid, "left: 555px; top: 150px;");

		
		
	}
	
	private void refresh(String text, ValueProvider<Medicament, ?> valueProvider) {
		for (AddMedicationViewListener listener: listeners)
			listener.filter1(text, valueProvider);
		
	}

	@Override
	public void addListener(AddMedicationViewListener listener) {
		listeners.add(listener);
		
	}
	
	@Override
	public void buttonClick() {
		for (AddMedicationViewListener listener: listeners)
			listener.buttonClick();
	}

	@Override
	public void setNotification(Boolean value) {
		layout.getLbl_Message().setVisible(value);		
	}

	@Override
	public String getUsage() {
		return layout.getTxt_usage().getValue().toString();
	}

	@Override
	public Date getStartDate() {
		return java.sql.Date.valueOf(layout.getDf_StartDate().getValue());
	}

	@Override
	public Date getEndDate() {
		return java.sql.Date.valueOf(layout.getDf_EndDate().getValue());
	}

	@Override
	public byte getActive() {
		boolean activeBoolean =  layout.getCkb_active().getValue();
		byte activeByte = (byte)(activeBoolean?1:0);
		return activeByte;
	}

	@Override
	public Grid getGrid() {
		return grid;
	}
	
	public Medicament getMedicament(){
		
		Set<Medicament> set = grid.getSelectedItems();
		return set.iterator().next();
	}
	
	
	@Override
	public void showMedicaments(List<Medicament> medicament) {
				
	}
	
	public boolean checkInput(){
		if(this.getUsage()!="" && this.getStartDate()!=null && this.getEndDate()!=null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public AddMedicationPresenter getPresenter() {
		return presenter;
	}
}
