package Release1;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public abstract class View implements Observer {

	/**
	 * the container holding everything (kind of represents the view)
	 */
	protected JPanel screen;
	
	protected String viewName;

	/**
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

	// may be necessary to have all views to be set up in a default
	// kind of way (leaving blank for now until we know what should be set
	// for all Views when they are instantiated
	public View() {

		this.screen = new JPanel();
	}

}
