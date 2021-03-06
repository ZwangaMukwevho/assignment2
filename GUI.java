import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.io.FileNotFoundException; 

public class GUI implements ActionListener{

	// Overriding the actionperformed method
	public void actionPerformed(ActionEvent e) {
			String a = searchArea.getText();
			String b = searchArea2.getText();
			String c = searchArea2.getText();
			}
	
	static JTextField searchArea = new JTextField(7);
	static JTextField searchArea1 = new JTextField(7);
	static JTextField searchArea2 = new JTextField(7);
	
	// Creating global strings
	static String a = "";
	static String b = "";
	static String c = "";
	static String outputString = "";


	//Creating a textarea
	static JTextArea outputDisplay = new JTextArea(15, 30);
	
	//Creating BSTdata Object
	
	
	
	public static void main(String[] args) implements ActionListener throws FileNotFoundException, Exception{
	BSTdata BSTdataobj = new BSTdata();
	BinarySearchTree<LSObject> BSTobj = new BinarySearchTree<LSObject>();
	BSTdataobj.DataCollection1("Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt",BSTobj);
	
	JFrame frame = new JFrame("LoadShed App");
  
	// Creating labels
       	JLabel labelResults = new JLabel("Results");
	labelResults.setOpaque(true);
	labelResults.setForeground(Color.WHITE);
	labelResults.setBackground(Color.ORANGE);
	labelResults.setFont(new Font("Tahoma", Font.ITALIC, 20));

	JLabel label1 = new JLabel("Date");
	JLabel label2 = new JLabel("Area");
	JLabel label3 = new JLabel("Zone");

        JLabel line = new JLabel("--------------------------------------------------");
	line.setForeground(Color.RED);
        JTextField textDescription = new JTextField(20);

	// Creating a buttons
        JButton searchButton = new JButton("SEARCH");
	searchButton.addActionListener(this);
	//JButton dateButton =  new JButton("Confirm");
	//dateButton.addActionListener(new ButtonListener2());
	
	searchButton.setBackground(Color.ORANGE);
    	searchButton.setForeground(Color.WHITE);
	searchButton.setBorder(BorderFactory.createEtchedBorder());
	
         
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridBagLayout());
 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
          
        // add components to the panel
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 2;
        newPanel.add(searchArea, constraints);
	
	constraints.gridx = 2;
	newPanel.add(label1,constraints);

	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 2;
        newPanel.add(searchArea1, constraints);

	constraints.gridx = 2;
	newPanel.add(label2,constraints);

	constraints.gridx = 0;
	constraints.gridy = 2;
	constraints.gridwidth = 2;
        newPanel.add(searchArea2, constraints);


	constraints.gridx = 2;
	newPanel.add(label3,constraints);


        constraints.gridx = 0;
        constraints.gridy = 4;
	constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;     
        newPanel.add(searchButton, constraints);

 	//constraints.gridx = 0;
        //constraints.gridy = 3;
	//constraints.gridwidth = 2;
        //constraints.anchor = GridBagConstraints.CENTER;     
        //newPanel.add(line, constraints);	

	constraints.gridx = 0;
	constraints.gridy = 5;
	constraints.gridwidth = 2;
        newPanel.add(searchButton, constraints);

	
	constraints.gridx = 0;
	constraints.gridy = 6;
	constraints.gridwidth = 2;
	newPanel.add(outputDisplay,constraints);
	

          
        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "LoadShed App"));
          
        // add the panel to this frame
        //add(newPanel);  
        //setLocationRelativeTo(null);
	//frame.setSize(250,250);
	frame.add(newPanel); // Adds Button to content pane of frame
	frame.pack();
	frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
	
	//f.setLocation(300,200);
	}
					

	public static class ButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			a = searchArea.getText();
			b = searchArea2.getText();
			c = searchArea2.getText();
			outputString = BSTdataobj.printAreas3(a,b,c,BSTobj);
			
			outputDisplay.setText(outputString);}
		}


}
