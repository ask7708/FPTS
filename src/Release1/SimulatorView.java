package Release1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class SimulatorView extends View {

   private final String[] SIMULATIONTYPES = { "Simulation Type","Bull Market Simulation", "Bear Market Simulation", 
         "No-Growth Market Simulation" }; 
   
   private final String[] INTERVALTYPES = { "Interval Type", "DAY", "MONTH", "YEAR" };
   
   private final String[] tableHeadings = { "Ticker Symbol", "Name", "Initial Price", "Simulated Price" };
   private final String[] simCol = {"Simulations"};

   private JButton addNewSim, reset1, resetAll;
   private DefaultTableModel simTableStructure, tableStructure;
   
   private JComboBox<String> mChoices = new JComboBox<String>(SIMULATIONTYPES);
   private JComboBox<String> iChoices = new JComboBox<String>(INTERVALTYPES);
   private JTextField stepsField, percentageField;
   
    private Simulator simulator;
    

	public SimulatorView() {
		
		super();
		this.simulator = null;

	   screen.setLayout(new FlowLayout());
	   
	   mChoices.setEditable(false);
	   iChoices.setEditable(false);
	   
	   JPanel simForm = new JPanel();
	   simForm.setLayout(new BoxLayout(simForm, BoxLayout.Y_AXIS));
	   simForm.add(mChoices);
	   simForm.add(iChoices);
	   
	   JPanel percentage = new JPanel();
	   percentage.setLayout(new FlowLayout());
	   percentage.add(new JLabel("Enter percentage:"));
	   percentageField = new JTextField(10);
	   percentage.add(percentageField);
	   simForm.add(percentage);
	   
	   JPanel timeLength = new JPanel();
	   timeLength.setLayout(new FlowLayout());
	   timeLength.add(new JLabel("Enter time length:"));
	   stepsField = new JTextField(10);
	   timeLength.add(stepsField);
	   simForm.add(timeLength);
	   simForm.setPreferredSize(new Dimension(125,500));
	   
	   addNewSim = new JButton("ADD NEW SIM");
	   addNewSim.setSize(125, 40);
	   
	   addNewSim.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            SimulationType sType = null;
            Interval iType = null;
            int stepsAmount = 0;
            double percentAmount = 0.0;
            
            switch(mChoices.getSelectedIndex()) {
            
               case 1:
                  sType = SimulationType.BULL;
                  break;
               case 2:
                  sType = SimulationType.BEAR;
                  break;
               case 3:
                  sType = SimulationType.NONE;
                  break;
               default:
                  return;
            }
            
            switch(iChoices.getSelectedIndex()) {
            
               case 1:
                  iType = Interval.DAY;
                  break;
               case 2:
                  iType = Interval.MONTH;
                  break;
               case 3:
                  iType = Interval.YEAR;
                  break;
               default:
                  break;
            }
            
            stepsAmount = Integer.parseInt(stepsField.getText());
            percentAmount = Double.parseDouble(percentageField.getText());
            
            System.out.println(sType.toString());
            System.out.println(iType.toString());
            System.out.println(stepsAmount);
            System.out.println(percentAmount);

            simulator.addNewSimulation(new Simulation(sType, stepsAmount, iType, percentAmount, simulator.getNextSimDate()));
            
            stepsField.setText("");
            percentageField.setText("");
            mChoices.setSelectedIndex(0);
            iChoices.setSelectedIndex(0);
         }
      });
	   
	   simForm.add(addNewSim);
	   
	   reset1 = new JButton("RESET ONE SIM");
      //reset1.set;
      
      reset1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
               
            simulator.removeOneSimulation();
         }
      });
      
      simForm.add(reset1);
      
      resetAll = new JButton("RESET ALL SIM");
      resetAll.setSize(125, 40);
      
      resetAll.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            simulator.resetAll();
         }
      });
      
      simForm.add(resetAll);
      
	   simTableStructure = new DefaultTableModel(simCol, 0);
	   JTable simulations = new JTable(simTableStructure);
	   JScrollPane simTableContainer = new JScrollPane(simulations);
	   simTableContainer.setPreferredSize(new Dimension(250,500));
	   	   
	   tableStructure = new DefaultTableModel(tableHeadings, 0);
	   JTable table = new JTable(tableStructure);
	   
	   JScrollPane tableContainer = new JScrollPane(table);
	   tableContainer.setPreferredSize(new Dimension(400,500));
	   
	   screen.add(simForm);
	   screen.add(tableContainer);
	   screen.add(simTableContainer);
	   
	   screen.setSize(200, 600);	
	   screen.setVisible(true);
	      

	      	 
		
	}
			
	public static void main(String[] args) {
	      User me = new User("dxr5716", "me");
	      
	      Portfolio portfolio = new Portfolio(me);
	       
	      Equity e1 = new Equity("GOOG", "Google Inc.", 100.00);
	      e1.setAcquiredShares(50);
	      Equity e2 = new Equity("AAPL", "Apple Inc.", 500.00);
	      e2.setAcquiredShares(20);
	      
	      portfolio.addEquity(e1);
	      portfolio.addEquity(e2);
	      
	      //Simulator simulator = new Simulator();
	      
	      SimulatorView ex = new SimulatorView();
	      ex.showScreen();
	}
	
	@Override
	public void update(Observable o, Object arg) {

	   System.out.println("Was update called? Yes it was");
	   
	   if(tableStructure.getRowCount() > 0) {
	      for(int i = tableStructure.getRowCount()-1; i >= 0 ; i--)
	         tableStructure.removeRow(i);
	   }
	   
	   if(simTableStructure.getRowCount() > 0) {
	      for(int i = simTableStructure.getRowCount()-1; i >= 0; i--)
	         simTableStructure.removeRow(i);
	   }
	   	   
	   for(int i = 0; i < simulator.holdings.size(); i++) {
	      
	      String tickSym = simulator.holdings.get(i).getTickSymbol();
	      String name = simulator.holdings.get(i).getName();
	      double initprice = simulator.holdings.get(i).getSharePrice();
	      double simprice = simulator.holdings.get(i).getSimulationPrice(); 
	      
	      Object[] data = { tickSym, name, "$" + initprice, '$' + String.format("%.02f", simprice) };
	      
	      this.tableStructure.addRow(data);
	   }
	   
	   ArrayList<String> simData = simulator.getSimulationsShort();
	   
	   for(String obj: simData) {
	      
	      Object[] line = { obj }; 
	      this.simTableStructure.addRow(line);
	   }
	  
	   if(simulator.simulations.isEmpty()) {
	      
	      reset1.setEnabled(false);
	      resetAll.setEnabled(false);
	   }
	   // The view will be updated 
	}
	
   @Override
   public void getData(Object sim) {
      
      String pv = (String) sim;
      simulator = new Simulator(pv);
      simulator.addObserver(this);
            
   }

}
