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
import javax.swing.table.DefaultTableModel;

public class SimulatorView extends View {

   private final String[] SIMULATIONTYPES = { "Simulation Type","Bull Market Simulation", "Bear Market Simulation", 
         "No-Growth Market Simulation" }; 
   
   private final String[] INTERVALTYPES = { "Interval Type", "DAY", "MONTH", "YEAR" };
   
   private DefaultTableModel simTableStructure, tableStructure;
   
   private JComboBox<String> mChoices = new JComboBox<String>(SIMULATIONTYPES);
   private JComboBox<String> iChoices = new JComboBox<String>(INTERVALTYPES);
   private JTextField stepsField, percentageField;
//   private JLabel timePrompt, percentPrompt;
   
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
	   
	   JButton add = new JButton("ADD NEW SIM");
	   add.setSize(125, 40);
	   
	   add.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            SimulationType sType = null;
            Interval iType = null;
            int stepsAmount = 0;
            double percentAmount = 0.0;
            double percent = 0;
            
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
         }
      });
	   
	   simForm.add(add);
	   
	   JButton reset1 = new JButton("RESET ONE SIM");
      reset1.setSize(125, 40);
      
      reset1.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
               
            simulator.removeOneSimulation();
         }
      });
      
      simForm.add(reset1);
      
      JButton resetAll = new JButton("RESET ALL SIM");
      resetAll.setSize(125, 40);
      
      resetAll.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
         }
      });
      
      simForm.add(resetAll);
      
	   String simCol[] = {"Simulations"};
	   simTableStructure = new DefaultTableModel(simCol, 0);
	   JTable simulations = new JTable(simTableStructure);
	   JScrollPane simTableContainer = new JScrollPane(simulations);
	   simTableContainer.setPreferredSize(new Dimension(125,500));
	   
	   String col[] = { "Ticker Symbol", "Name", "Initial Price", "Simulated Price" };
	   
	   tableStructure = new DefaultTableModel(col, 0);
	   JTable table = new JTable(tableStructure);
	   
	   JScrollPane tableContainer = new JScrollPane(table);
	   tableContainer.setPreferredSize(new Dimension(400,500));
	   
	   screen.add(simForm);
	   screen.add(tableContainer);
	   screen.add(simTableContainer);
	   
	   screen.setSize(200, 600);	
	   screen.setVisible(true);
	}
	
//	public static void main(String[] args) {
//	   
//	      User me = new User("dxr5716", "me");
//	      
//	      Portfolio portfolio = new Portfolio(me);
//	       
//	      Equity e1 = new Equity("GOOG", "Google Inc.", 100.00);
//	      e1.setAcquiredShares(50);
//	      Equity e2 = new Equity("AAPL", "Apple Inc.", 500.00);
//	      e2.setAcquiredShares(20);
//	      
//	      portfolio.addEquity(e1);
//	      portfolio.addEquity(e2);
//	      
//	      //Simulator simulator = new Simulator();
//	      
//	      SimulatorView ex = new SimulatorView();
//	      ex.showScreen();
//	}
	
	public void update(Observable o, Object arg) {

	   System.out.println("Was update called? Yes it was");
	   
//	   for()
//	   if(tableStructure.getRowCount() > 0) {
//	      for(int i = 0; i < tableStructure.getRowCount(); i++)
//	         tableStructure.removeRow(i);
//	   }
	   
	   if(simTableStructure.getRowCount() > 0) {
	      for(int i = 0; i < simTableStructure.getRowCount(); i++)
	         simTableStructure.removeRow(i);
	   }
	   
	   for(int i = 0; i < simulator.holdings.size(); i++) {
	      
	      String tickSym = simulator.holdings.get(i).getTickSymbol();
	      String name = simulator.holdings.get(i).getName();
	      double initprice = simulator.holdings.get(i).getSharePrice();
	      double simprice = simulator.holdings.get(i).getSimulationPrice(); 
	      
	      Object[] data = { tickSym, name, initprice, simprice };
	      
	      tableStructure.addRow(data);
	   }
	   
	   ArrayList<String> simData = simulator.getSimulationsShort();
	   
	   for(String obj: simData) {
	      
	      Object[] line = { obj }; 
	      simTableStructure.addRow(line);
	   }
	   
	}
	
   @Override
   public void getData(Object sim) {
      
      System.out.println("I am getting a new simulator now");
      String pv = (String) sim;
      this.simulator = new Simulator(pv);
      this.simulator.addObserver(this);
      System.out.println(simulator.countObservers());
            
   }

}