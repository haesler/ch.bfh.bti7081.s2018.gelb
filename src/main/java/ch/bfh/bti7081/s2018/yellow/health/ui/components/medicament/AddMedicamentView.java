package ch.bfh.bti7081.s2018.yellow.health.ui.components.medicament;


import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import ch.bfh.bti7081.s2018.yellow.health.models.Medicament;


public interface AddMedicamentView extends View {
	
	interface AddMedicamentViewListener{
		void itemClick(Medicament selectedMedicament);
		void buttonClick(String buttonName);
		void filter(String text, ValueProvider<Medicament, ?> valueProvider);
		void changeToModifyMode();
	}
	
	public void addListener(AddMedicamentViewListener listener);
}