package Release1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimulatorView extends View {

    private static final long serialVersionUID = 1L;
    private JPanel cardPanel, stockPanel, accountPanel, leftPanel, portfolioPanel, holdingsPanel;
    private JLabel stockLabel, accountLabel, portfolioLabel, holdingsLabel;
    private JButton stockButton, accountButton, portfolioButton, holdingsButton;
    private CardLayout cardLayout = new CardLayout();
    private Simulator simulator;
    
    public ArrayList<String> toString(ArrayList<Equity> list){
    	return new ArrayList<String>();
    	//ArrayList<String>
//    	StringBuffer results = new StringBuffer();
//    	String separator = ",";
//    	float[][] values = new float[50][50];
//
//    	// init values
//
//    	for (int i = 0; i < values.length; ++i)
//    	{
//    	  results.append('[');
//    	  for (int j = 0; j < values[i].length; ++j)
//    	    if (j > 0)
//    	      results.append(values[i][j]);
//    	    else
//    	      results.append(values[i][j]).append(separator);
//    	  results.append(']');
//    	}
//    	
//    	
    }
	public SimulatorView() {
		
		super();
		this.simulator = null;
	      
	      cardPanel = new JPanel();
	      leftPanel = new JPanel();
	      cardPanel.setLayout(cardLayout);
	   
	      
	      stockPanel = new JPanel();
	      stockLabel = new JLabel("Stock");
	      stockPanel.add(stockLabel);
	      cardPanel.add(stockPanel, "1");
	      stockButton = new JButton("Stock");
	      
	      //stockPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	      
//	      StringBuilder builder = new StringBuilder(simulator.myHoldings.size());
	      StringBuilder builder = new StringBuilder(simulator.holdings.size());
	      
//	      for (int i=0;i<simulator.myHoldings.size();builder.append(simulator.myHoldings.get(i++))) builder.append("\n");
	      for (int i=0; i<simulator.holdings.size();builder.append(simulator.holdings.get(i++))) builder.append("\n");
	      JOptionPane.showMessageDialog(null, builder.toString(), "Printing results", JOptionPane.INFORMATION_MESSAGE);
	      
	      
	      
//	      JLabel holdings = new JLabel(simulator.myHoldings.toString());
	      JLabel holdings = new JLabel(simulator.holdings.toString());
	      stockPanel.add(holdings);
	      stockButton.addActionListener(new ActionListener() {

	          public void actionPerformed(ActionEvent e) {
	              cardLayout.show(cardPanel, "1");
	          }
	      });

	      
	      /**
	      Date date = new Date();
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	      JLabel dateNow = new JLabel(sdf.format(date));
	      mainPanel.add(dateNow);
	      **/
	      
	  leftPanel.add(stockButton);

	 screen.add(cardPanel, BorderLayout.NORTH);
	 screen.add(leftPanel, BorderLayout.SOUTH);
	 screen.setSize(600, 600);
	 
		
	}
	
	



	public static void main(String[] args) {
	      User me = new User("dxr5716", "me");
	      
	      Portfolio portfolio = new Portfolio(me);
	       
	      Equity e1 = new Equity("GOOG", "Google Inc.", 100.00);
	      e1.setAcquiredShares(50);
	      Equity e2 = new Equity("AAPL", "Apple Inc.", 500.00);
	      e2.setAcquiredShares(20);
	      
	      portfolio.addHolding(e1);
	      portfolio.addHolding(e2);
	      
	      //Simulator simulator = new Simulator();
	      
	      SimulatorView ex = new SimulatorView();
	      ex.showScreen();
	}
	
	@Override
	public void update(Observable o, Object arg) {

	   // The view will be updated 
	}
	
   @Override
   public void getData(Object sim) {
      
      String pv = (String) sim;
      simulator = new Simulator(pv);
      simulator.addObserver(this);
            
   }

}