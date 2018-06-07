package ch.bfh.bti7081.s2018.yellow.health.ui.components.medication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

import ch.bfh.bti7081.s2018.yellow.health.models.Medication;
import ch.bfh.bti7081.s2018.yellow.health.ui.layouts.AddMedicationLayout;


@Component
public class AddMedicationViewImpl extends AbsoluteLayout implements AddMedicationView{

	private static final long serialVersionUID = 1L;
	
	List<AddMedicationViewListener> listeners = new ArrayList<AddMedicationViewListener>();
	private AddMedicationPresenter presenter;
	private AddMedicationLayout layout;
	Grid<Medication> grid = new Grid<Medication>(Medication.class);

	@Autowired	
	public AddMedicationViewImpl(AddMedicationModel service, AddMedicationModel modelMeds){
	
		layout = new AddMedicationLayout();
		layout.getBu_save().addClickListener(e -> this.buttonClick());
		addComponent(layout);
		this.presenter = new AddMedicationPresenter(service, modelMeds, this);
		loadGridView();
	}
	
	private void loadGridView(){

		// Create a header row to hold column filters
		HeaderRow filterRow = grid.appendHeaderRow();
		grid.setColumns("medicationID","start", "end", "active");
		for (Column<Medication, ?> pid: grid.getColumns()) {
		    HeaderCell cell = filterRow.getCell(pid.getId());
		    final TextField filter = new TextField();
		    filter.setPlaceholder("Filter");
		    filter.addValueChangeListener(e -> {refresh(filter.getValue(),  pid.getValueProvider());});
		    filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
		    cell.setComponent(filter);
		}
		addComponent(grid, "left: 555px; top: 150px;");

		
		
	}
	
	private void refresh(String text, ValueProvider<Medication, ?> valueProvider) {
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
		return layout.getTxt_usage().getValue();
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
	
	
	@Override
	public void showMedications(List<Medication> medications) {
				
	}
	
	public boolean checkInput(){
		if(this.getUsage()!="" && this.getStartDate()!=null && this.getEndDate()!=null){
			return true;
		}
		else{
			return false;
		}
	}
}
