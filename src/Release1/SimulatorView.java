package Release1;

import java.util.Observable;
import java.util.Observer;

public class SimulatorView extends View {
   
	public SimulatorView(Simulator simulator  ){
		
		super();
		simulator.addObserver(this);
	}
   
	









	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}}
