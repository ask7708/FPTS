package Release1;

import java.util.Observer;

import javax.swing.JPanel;

public abstract class View implements Observer {

	/**
	 * the container holding everything (kind of represents the view)
	 */
	protected JPanel screen;
	
	protected String viewName;

	/**
	 * 
	 * Makes the view appear in the application
	 */
	public void showScreen() {
		this.screen.setVisible(true);
	}

	/**
	 * Hides the view away from the application
	 */
	public void hideScreen() {
		this.screen.setVisible(false);
	}

	public abstract void getData(Object sim);
	
	/**
	 * Constructor for a View object
	 */
	public View() {

		this.screen = new JPanel();
	}

}
