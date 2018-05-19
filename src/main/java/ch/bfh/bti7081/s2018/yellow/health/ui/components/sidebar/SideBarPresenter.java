package ch.bfh.bti7081.s2018.yellow.health.ui.components.sidebar;

public class SideBarPresenter implements SideBarView.SideBarViewListener {
	
	private SideBarView view;
	
	public SideBarPresenter(SideBarView  view) {
	   this.view  = view;
	   view.addListener(this);
	}
}
