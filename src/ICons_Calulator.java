import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ICons_Calulator implements ActionListener, DocumentListener {
	/*
	 * This is a Calculator for ICons 189H CS2 Group 5: Space Junk
	 * List of Factors (7 total) User will be asked to provide percentages based on their perceived importance
	 * 1.) Time to remove (Slider Instantaneous, 1 week, 1 month 6 months, 1 year, 2 years+)
	 * 2.) Quantity (Slider or bubbles 10:1, 1:1, 1:10, 1:100, 1:1000, 1:10000)
	 * 3.) Cost (Text box)
	 * 4.) Technological Readiness (Slider with values Already built, In development(< 2 years), In development (> 2years), < 5 years, > 5years)
	 * 5.) Environmental Impact (Sliders None, Very Low, Low, High, Very High)
	 * 6.) Scalability (Sliders Very Low, Low, High, Very High)
	 * 7.) Type of objects it can remove (Check boxes Maybe?)
	 */
	
	//Initializing some variables up here so that I can use them later
	int recommendations[]= {10, 15, 10, 10, 15, 20, 20};
	JTextField AllPercents[]=new JTextField[7];
	JTextField total;
	//JComponent allInput[]=new JComponent[11];
	JSlider row2slider;
	JSlider row3slider;
	JSlider row5slider;
	JSlider row6slider;
	JSlider row7slider;
	JTextField row4cost;
	JCheckBox smallBox;
    JCheckBox mediumBox;
    JCheckBox largeBox;
    JCheckBox specialBox;
    JCheckBox UncatBox;
    
    //Declare methods
    spaceJunkMethod SingleRoboticArm=new spaceJunkMethod(3, 0, 117000000, 2, 0, 2, 0, 1, 1, 0, 0);
    spaceJunkMethod EDDE=new spaceJunkMethod(5, 5, 1900000, 2, 0, 1, 1, 0, 0, 0, 1);
    spaceJunkMethod ELSAd=new spaceJunkMethod(3, 0, 191000000, 1, 0, 2, 0, 0, 0, 1, 0);
    spaceJunkMethod IBS=new spaceJunkMethod(3, 0, 50000000, 2, 0, 2, 0, 1, 1, 0, 0);
    spaceJunkMethod EDT=new spaceJunkMethod(4, 0, 2000000, 1, 0, 2, 0, 1, 1, 0, 0);
    spaceJunkMethod SpaceTug=new spaceJunkMethod(3, 4, 2000000, 2, 0, 2, 0, 1, 1, 0, 0);
    spaceJunkMethod StickyFoam=new spaceJunkMethod(3, 3, 4000000, 1, 0, 2, 0, 1, 1, 0, 1);
    spaceJunkMethod StarKiller=new spaceJunkMethod(0, 5, 2000000000, 5, 0, 4, 1, 1, 1, 1, 1);
    spaceJunkMethod HydroWall=new spaceJunkMethod(4, 5, 1000000, 4, 2, 1, 1, 0, 0, 0, 1);
    
    //Make Buttons for each Method
    JButton method1= new JButton("Single Robotic Arm");
    JButton method2= new JButton("Electrodynamic Debris Eliminator");
    JButton method3= new JButton("ELSA-d");
    JButton method4= new JButton("Ion Beam Shepard");
    JButton method5= new JButton("Electrodynamic Tether");
    JButton method6= new JButton("Reusable Space Tug");
    JButton method7= new JButton("Sticky Foam");
    JButton method8= new JButton("STAR KILLER!");
    JButton method9= new JButton("Hydrogen Wall");
    JButton recPer= new JButton("Our Recommended Perecentages");
    
    
    //Pretty Much just makes the GUI
	private void prepareGUI()
	{
		//Make an array with all percent text boxes
		AllPercents[0]=new JTextField();
		AllPercents[1]=new JTextField();
		AllPercents[2]=new JTextField();
		AllPercents[3]=new JTextField();
		AllPercents[4]=new JTextField();
		AllPercents[5]=new JTextField();
		AllPercents[6]=new JTextField();
	
	    method1.addActionListener(this);
	    method2.addActionListener(this);
	    method3.addActionListener(this);
	    method4.addActionListener(this);
	    method5.addActionListener(this);
	    method6.addActionListener(this);
	    method7.addActionListener(this);
	    method8.addActionListener(this);
	    method9.addActionListener(this);
	    recPer.addActionListener(this);
	    
	    //factor text boxes
	    JLabel AllColumn1[]=new JLabel[8];
	    AllColumn1[0]= new JLabel("Factors");
	    AllColumn1[1]= new JLabel("Time to Remove");
	    AllColumn1[2]= new JLabel("Quantity");
	    AllColumn1[3]= new JLabel("Cost (USD)");
	    AllColumn1[4]= new JLabel("Technological Readiness");
	    AllColumn1[5]= new JLabel("Environmental Impact");
	    AllColumn1[6]= new JLabel("Scalability");
	    AllColumn1[7]= new JLabel("Type of Objects it can remove");
	    
	    
		for(int i=0;i<7;i++)
		{
			AllPercents[i].getDocument().addDocumentListener(this);
		}
		
		//Get the height and width of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int width= (int)(screenSize.getWidth());
		final int height=(int)screenSize.getHeight();
		
		for(JLabel e: AllColumn1)
	    {
			e.setMinimumSize(new Dimension(width/4,height/11));
			e.setMaximumSize(new Dimension(width/4,height/11));
	    }
		for(JTextField e: AllPercents)
		{
			e.setMinimumSize(new Dimension(width/4,height/11));
			e.setMaximumSize(new Dimension(width/4,height/11));
		}
		//Create New Frame that takes up the whole screen
		JFrame frame = new JFrame("Group 5: Super Awesome Calculator");
		frame.setLayout(new FlowLayout());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(width,height);
	    
	    JPanel methodButtonPanel=new JPanel(new GridLayout(2,5));
	    methodButtonPanel.setSize(new Dimension(width, 2*(height/11)));
	    methodButtonPanel.add(method1);
	    methodButtonPanel.add(method2);
	    methodButtonPanel.add(method3);
	    methodButtonPanel.add(method4);
	    methodButtonPanel.add(recPer);
	    methodButtonPanel.add(method5);
	    methodButtonPanel.add(method6);
	    methodButtonPanel.add(method7);
	    methodButtonPanel.add(method8);
	    methodButtonPanel.add(method9);
	    frame.add(methodButtonPanel);
	    
	    //Create panel with FlowLayout()
	    JPanel panel=new JPanel(new FlowLayout());
	    
	    //Left Panel
	    JPanel panel1=new JPanel(new GridLayout(8,1));
	    panel1.setPreferredSize(new Dimension(width/4, 8*(height/11)));
	    
	    //Center panel
	    JPanel panel2=new JPanel(new GridLayout(8,1));
	    panel2.setPreferredSize(new Dimension(width/4, 8*(height/11)));
	    
	    //Right Panel
	    JPanel panel3=new JPanel(new GridLayout(8,1));
	    panel3.setPreferredSize(new Dimension((width/2)-50, 8*(height/11)));
	    
	    panel.setPreferredSize(new Dimension(width, 8*(height/11)));
	    
	    //Row One Headers
	    panel1.add(AllColumn1[0]);
	    JPanel percentPanel= new JPanel(new GridLayout(2,1));
	    percentPanel.add(new JLabel("Enter in a number 0 to 100 for Each Factor. Numbers must sum to 100."));
	    JPanel bottomPercentPanel=new JPanel(new FlowLayout());
	    bottomPercentPanel.add(new JLabel("Total: "));
	    total=new JTextField("0",3);
	    bottomPercentPanel.add(total);
	    bottomPercentPanel.add(new JLabel("%"));
	    percentPanel.add(bottomPercentPanel);
	    panel2.add(percentPanel);
	    panel3.add(new JLabel("Input (Drag the Slider or Enter a Number)"));
	    
	    //Row 2 (Time to Remove)
	    panel1.add(AllColumn1[1]);
	    panel2.add(AllPercents[0]);
	    //Make a slider with a hash table of labels
	    row2slider=new JSlider(0,5,0);
	    //row2slider.setMinimumSize(new Dimension(width/3,height/11));
	    //row2slider.setMaximumSize(new Dimension(width/3,height/11));
	    Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
	    labelTable.put(0, new JLabel("1 week"));
	    labelTable.put(1, new JLabel("1 month"));
	    labelTable.put(2, new JLabel("3 months"));
	    labelTable.put(3, new JLabel("6 months"));
	    labelTable.put(4, new JLabel("1 year"));
	    labelTable.put(5, new JLabel("5+ years"));
	    row2slider.setLabelTable(labelTable);
	    row2slider.setPaintLabels(true);
	    row2slider.setSnapToTicks(true);
	    panel3.add(row2slider);
	    
	    //Row 3 Quantity
	    panel1.add(AllColumn1[2]);
	    panel2.add(AllPercents[1]);
	    //Make a slider with a hash table of labels
	    row3slider=new JSlider(0,5,0);
	    row3slider.setMinimumSize(new Dimension(width/3,height/11));
	    row3slider.setMaximumSize(new Dimension(width/3,height/11));
	    Hashtable<Integer, JLabel> labelTable3 = new Hashtable<Integer, JLabel>();
	    labelTable3.put(0, new JLabel("1:1"));
	    labelTable3.put(1, new JLabel("1:2"));
	    labelTable3.put(2, new JLabel("1:5"));
	    labelTable3.put(3, new JLabel("1:10"));
	    labelTable3.put(4, new JLabel("1:100"));
	    labelTable3.put(5, new JLabel(">1:100"));
	    row3slider.setLabelTable(labelTable3);
	    row3slider.setPaintLabels(true);
	    row3slider.setSnapToTicks(true);
	    panel3.add(row3slider);
	    
	    //Row 4 Cost
	    panel1.add(AllColumn1[3]);
	    panel2.add(AllPercents[2]);
	    row4cost=new JTextField();
	    row4cost.setMinimumSize(new Dimension(width/3,height/11));
		row4cost.setMaximumSize(new Dimension(width/3,height/11));
	    panel3.add(row4cost);
	    
	    //Row 5 Technological Readiness
	    panel1.add(AllColumn1[4]);
	    panel2.add(AllPercents[3]);
	    //Make a slider with a hash table of labels
	    row5slider=new JSlider(0,4,0);
	    row5slider.setMinimumSize(new Dimension(width/3,height/11));
		row5slider.setMaximumSize(new Dimension(width/3,height/11));
	    Hashtable<Integer, JLabel> labelTable5 = new Hashtable<Integer, JLabel>();
	    labelTable5.put(0, new JLabel("Built"));
	    labelTable5.put(1, new JLabel("Prototype        "));
	    labelTable5.put(2, new JLabel("Technology exists"));
	    //labelTable5.put(3, new JLabel("Technology needs to be made"));
	    labelTable5.put(3, new JLabel("     Researching"));
	    labelTable5.put(4, new JLabel("Idea"));
	    row5slider.setLabelTable(labelTable5);
	    row5slider.setPaintLabels(true);
	    row5slider.setSnapToTicks(true);
	    panel3.add(row5slider);
	    
	    //Row 6 Environmental Impact
	    panel1.add(AllColumn1[5]);
	    panel2.add(AllPercents[4]);
	    //Make a slider with a hash table of labels
	    row6slider=new JSlider(0,4,0);
	    row6slider.setMinimumSize(new Dimension(width/3,height/11));
		row6slider.setMaximumSize(new Dimension(width/3,height/11));
	    Hashtable<Integer, JLabel> labelTable6 = new Hashtable<Integer, JLabel>();
	    labelTable6.put(0, new JLabel("Very Low"));
	    labelTable6.put(1, new JLabel("Low"));
	    labelTable6.put(2, new JLabel("Medium"));
	    labelTable6.put(3, new JLabel("High"));
	    labelTable6.put(4, new JLabel("Very High"));
	    row6slider.setLabelTable(labelTable6);
	    row6slider.setPaintLabels(true);
	    row6slider.setSnapToTicks(true);
	    panel3.add(row6slider);
	    
	    
	    //Row 7 Scalability
	    panel1.add(AllColumn1[6]);
	    panel2.add(AllPercents[5]);
	    //Make a slider with a hash table of labels
	    row7slider=new JSlider(0,4,0);
	    row7slider.setMinimumSize(new Dimension(width/3,height/11));
		row7slider.setMaximumSize(new Dimension(width/3,height/11));
	    Hashtable<Integer, JLabel> labelTable7 = new Hashtable<Integer, JLabel>();
	    labelTable7.put(0, new JLabel("Very Low"));
	    labelTable7.put(1, new JLabel("Low"));
	    labelTable7.put(2, new JLabel("Medium"));
	    labelTable7.put(3, new JLabel("High"));
	    labelTable7.put(4, new JLabel("Very High"));
	    row7slider.setLabelTable(labelTable7);
	    row7slider.setPaintLabels(true);
	    row7slider.setSnapToTicks(true);
	    panel3.add(row7slider);
	    
	    //Row 8 Type of Objects it can remove
	    panel1.add(AllColumn1[7]);
	    panel2.add(AllPercents[6]);
	    //Check Boxed with various categories of space debris
	    JPanel row8container=new JPanel(new GridLayout(2,1));
	    row8container.add(new JLabel("Select all the boxes that apply"));
	    //Make check box panel
	    JPanel row8bottom=new JPanel(new GridLayout(2,3));
	    smallBox=new JCheckBox("Small < 50 kg");
	    mediumBox=new JCheckBox("Medium 50 kg to 500 kg");
	    largeBox=new JCheckBox("Large > 500 kg");
	    specialBox=new JCheckBox("Special Sattelites only");
	    UncatBox= new JCheckBox("Uncategorized Debris");
	    
	    row8bottom.add(smallBox);
	    row8bottom.add(mediumBox);
	    row8bottom.add(largeBox);
	    row8bottom.add(specialBox);
	    row8bottom.add(UncatBox);
	    row8container.add(row8bottom);
	    //row8container.setMinimumSize(new Dimension(width/3, height/11));
	    row8container.setMaximumSize(new Dimension(width/2, height/11));
	    panel3.add(row8container);
	    
	    //Add panel to frame
	    panel.add(panel1);
	    panel.add(panel2);
	    panel.add(panel3);
	    
	    frame.add(panel);
	    
	    //Create Button "Submit"
	    JButton button = new JButton("Submit");
	    button.addActionListener(this);
	    button.setPreferredSize(new Dimension(width/4, height/20));
	    frame.add(button); 
	    
	    
	    //frame.pack();
	    frame.setVisible(true);
	}
	public ICons_Calulator()
	{
		prepareGUI();
	}
	public static void main(String[] args) 
	{
		ICons_Calulator bob=new ICons_Calulator();
	}
	public void insertUpdate(DocumentEvent e)
	{
		try {
			int num=0;
			for(JTextField a:AllPercents)
			{
				if(!(a.getText().equals("")))
				{
					num+=Integer.parseInt(a.getText().trim());
				}
			}
			if(num>100)
			{
				JOptionPane.showMessageDialog(null,"The total percentage can't be higher than 100%","100% error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			total.setText(Integer.toString(num));
		}
		catch(NumberFormatException b)
		{
			JOptionPane.showMessageDialog(null,"Text boxes for percentage and cost must only contain numbers","You put letters in the number places!",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception b)
		{
			JOptionPane.showMessageDialog(null,"This is not good...","!",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void changedUpdate(DocumentEvent e)
	{
		
	}
	public void removeUpdate(DocumentEvent e)
	{
		try {
			int num=0;
			for(JTextField a:AllPercents)
			{
				if(!(a.getText().equals("")))
				{
					num+=Integer.parseInt(a.getText().trim());
				}
			}
			if(num>100)
			{
				JOptionPane.showMessageDialog(null,"The total percentage can't be higher than 100%","100% error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			total.setText(Integer.toString(num));
		}
		catch(NumberFormatException b)
		{
			JOptionPane.showMessageDialog(null,"Text boxes for percentage and cost must only contain numbers","You put letters in the number places!",JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception b)
		{
			JOptionPane.showMessageDialog(null,"This is not good...","!",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		//Method Buttons
		JButton thing=(JButton)e.getSource();
		if(thing.getText().equals("Submit"))
		{
			/*
			 * This function is invoked when the Submit button is pressed
			 * It should first test if all of the inputs are valid
			 * ex all percentages are in between 0 and 100 and sum to 100
			 * Then multiply the inputs by the weights and get the FINAL SCORE
			 * MUST THROW EXCEPTION
			 */
			try
			{
				//Initializing some variables
				Double finalScore=0.0;
				int total=0;
				double percents[]=new double[7];
				int factors[]=new int[7];
				
				//Checks if the percentages are between 0 and 100 and makes the percents array
				for(int i=0;i<7;i++)
				{
					if(Integer.parseInt(AllPercents[i].getText().trim())>=0&&Integer.parseInt(AllPercents[i].getText().trim())<=100)
					{
						total+=Integer.parseInt(AllPercents[i].getText());
						percents[i]=(double)(Integer.parseInt(AllPercents[i].getText())/5.0);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"All percentages must be numbers in between 1 and 100","CRITICAL ERROR!!!!!!!!!",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				
				//Checks to see if total is 100
				if(total!=100)
				{
					JOptionPane.showMessageDialog(null,"Percentages must add to 100","CRITICAL ERROR!!!!!!!!!",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//Setting values of factors 0,1
				factors[0]=(int)row2slider.getValue();//0-5
				factors[1]=(int)Math.abs(5-row3slider.getValue());//0-5
				
				//Factor 2
				int factor2=Integer.parseInt(row4cost.getText().trim());
				if(factor2<1000000)
					factors[2]=0;
				else if(factor2<2000000)
					factors[2]=1;
				else if(factor2<10000000)
					factors[2]=2;
				else if(factor2<50000000)
					factors[2]=3;
				else if(factor2<100000000)
					factors[2]=4;
				else
					factors[2]=5;
				
				//Factor 3-5
				factors[3]=(int)(1.25*(double)(row5slider.getValue()));
				factors[4]=(int)(1.25*(double)(row6slider.getValue()));
				factors[5]=(int)(1.25*(double)(row7slider.getValue()));
				factors[5]=Math.abs(5-factors[5]);
				
				//Factor 6 
				int numFactors=0;
				if(smallBox.isSelected()) 
				{
					numFactors++;
				}
				if(mediumBox.isSelected()) 
				{
					numFactors++;
				}
				if(largeBox.isSelected()) 
				{
					numFactors++;
				}
				if(specialBox.isSelected()) 
				{ 
					numFactors++;
				}
				if(UncatBox.isSelected())
				{
					numFactors++;
				}
				double var=(double)numFactors;
				factors[6]=(int)Math.abs(5-var);
				
				//This part is a little weird but I accidentally coded almost every variable
				//backwards so i had to fix it with all of the Math.abs() stuff
				for(int i=0;i<7;i++)
				{
					double finalFactors=(double)Math.abs(5-factors[i]);
					finalScore+=percents[i]*finalFactors;
				}
				finalScore=Math.round(finalScore*100.)/100.;
				JOptionPane.showMessageDialog(null,"Final Score is " + finalScore + " out of a possible 100 points","Final Score",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			//Catch statement for if they put non numbers where there is supposed to be numbers
			catch(NumberFormatException b)
			{
				JOptionPane.showMessageDialog(null,"Text boxes for percentage and cost must only contain numbers","You put letters in the number places!",JOptionPane.ERROR_MESSAGE);
			}
			//Hopefully this doesn't happen
			catch(Exception b)
			{
				JOptionPane.showMessageDialog(null,"This is not good...","!",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(thing.getText().equals("Our Recommended Perecentages"))
		{
			for(int i=0; i<7; i++)
			{
				AllPercents[i].setText(Integer.toString(recommendations[i]));
			}
		}
		else
		{
			try
			{
				spaceJunkMethod method=null;
				if(thing.getText().equals("Single Robotic Arm"))
				{
					method=SingleRoboticArm;
				}
				else if(thing.getText().equals("Electrodynamic Debris Eliminator"))
				{
					method=EDDE;
				}
				else if(thing.getText().equals("ELSA-d"))
				{
					method=ELSAd;
				}
				else if(thing.getText().equals("Ion Beam Shepard"))
				{
					method=IBS;
				}
				else if(thing.getText().equals("Electrodynamic Tether"))
				{
					method=EDT;
				}
				else if(thing.getText().equals("Reusable Space Tug"))
				{
					method=SpaceTug;
				}
				else if(thing.getText().equals("Sticky Foam"))
				{
					method=StickyFoam;
				}
				else if(thing.getText().equals("Hydrogen Wall"))
				{
					method=HydroWall;
				}
				else
				{
					method=StarKiller;
				}
				row2slider.setValue(method.time);
				row3slider.setValue(method.quantity);
				row4cost.setText(Integer.toString(method.cost));
				row5slider.setValue(method.techReadiness);
				row6slider.setValue(method.enviro);
				row7slider.setValue(method.scalability);
				smallBox.setSelected(method.small==1);
				mediumBox.setSelected(method.medium==1);
				largeBox.setSelected(method.large==1);
				specialBox.setSelected(method.special==1);
				UncatBox.setSelected(method.uncat==1);
			}
			catch(Exception b)
			{
				System.out.println("Shoot!");
			}
		}
	}
}

