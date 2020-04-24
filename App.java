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

public class App extends JFrame {

	static JTextField searchArea = new JTextField(7);
	static JTextField searchArea1 = new JTextField(7);
	static JTextField searchArea2 = new JTextField(7);

	//Creating a textarea
	static JTextArea outputDisplay = new JTextArea(15, 30);
	static JScrollPane scrollPane = new JScrollPane(outputDisplay);  


	public static class ButtonListener implements ActionListener {
		 public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();

			String a = searchArea.getText();
			String b = searchArea1.getText();
			String c = searchArea2.getText();
			String output = "error";
	
	if(actionCommand.equals("BST SEARCH")){
		try{
			BSTdata BSTdataobj = new BSTdata();
			output = BSTdataobj.printAreas3(a,b,c);
			outputDisplay.setText(output);
			}

		catch(FileNotFoundException f){
			output = "No textfile to read from";}
			outputDisplay.setText(output);
							
					}		
						
	
	if(actionCommand.equals("AVL SEARCH")){
		try{
			AVLUtiles AVLobj = new AVLUtiles();
			output = AVLobj.printAreas2(a,b,c);
			outputDisplay.setText(output);
			}

		catch(FileNotFoundException f){
			output = "No textfile to read from";}
			outputDisplay.setText(output);
								
								}		

	}}	

	

	public static void main(String[] args) throws FileNotFoundException, Exception{
		//appDemo gui = new appDemo();
		//Demo; 
		gui();
	}

	public static void gui() throws FileNotFoundException, Exception{
	
	JFrame frame = new JFrame("LoadShed App");
  
	JTextArea outputDisplay = new JTextArea(15, 30);


	// Creating labels
       	JLabel labelResults = new JLabel("Results");
	labelResults.setOpaque(true);
	labelResults.setForeground(Color.WHITE);
	labelResults.setBackground(Color.ORANGE);
	labelResults.setFont(new Font("Tahoma", Font.ITALIC, 20));

	JLabel label1 = new JLabel("Stage");
	JLabel label2 = new JLabel("Date");
	JLabel label3 = new JLabel("Time");

        JLabel line = new JLabel("--------------------------------------------------");
	line.setForeground(Color.RED);
        JTextField textDescription = new JTextField(20);

	// Creating a buttons
	JButton searchButton = new JButton("BST SEARCH");
	searchButton.addActionListener(new ButtonListener());
	JButton searchButton1 =  new JButton("AVL SEARCH");
	searchButton1.addActionListener(new ButtonListener());
	
	searchButton.setBackground(Color.ORANGE);
    	searchButton.setForeground(Color.WHITE);
	searchButton.setBorder(BorderFactory.createEtchedBorder());
	
	searchButton1.setBackground(Color.ORANGE);
    	searchButton1.setForeground(Color.WHITE);
	searchButton1.setBorder(BorderFactory.createEtchedBorder());
         
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
	constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;     
        newPanel.add(searchButton, constraints);

 	constraints.gridx = 1;
        constraints.gridy = 4;
	constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;     
        newPanel.add(searchButton1, constraints);	

	//constraints.gridx = 0;
	//constraints.gridy = 5;
	//constraints.gridwidth = 2;
        //newPanel.add(searchButton, constraints);

	//outputDisplay.setBackround(Color.YELLOW);	
	scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
	
	constraints.gridx = 0;
	constraints.gridy = 5;
	constraints.gridwidth = 2;
	newPanel.add(scrollPane,constraints);
	

          
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
	
}
