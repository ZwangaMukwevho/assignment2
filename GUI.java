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

public class GUI {
	static JTextField searchArea = new JTextField(7);
	static JTextField searchArea1 = new JTextField(7);
	static JTextField searchArea2 = new JTextField(7);

	public static class ButtonListener implements ActionListener{
		 public void actionPerformed(ActionEvent e) {
			searchArea.setText("hello");
    			}

	}
	
	public static void main(String[] args){
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

	final Color VERY_LIGHT_RED = new Color(255,102,102);
	final Color pop = new Color(0,0,153);
	final Color pop1 = new Color(51,153,255);

	// Creating a button
        JButton searchButton = new JButton("SEARCH");
	searchButton.addActionListener(new ButtonListener());

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

 	constraints.gridx = 0;
        constraints.gridy = 3;
	constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;     
        newPanel.add(line, constraints);	

	constraints.gridx = 0;
	constraints.gridy = 5;
	constraints.gridwidth = 2;
        newPanel.add(labelResults, constraints);


	
	
	//newPanel.add(buttonLogin, constraints);
          
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
