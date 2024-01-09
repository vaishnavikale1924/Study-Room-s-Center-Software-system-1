import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MainMenu implements ActionListener {

    private JPanel jpInfo = new JPanel();

    private JTextField txtNo, txtName, txtPass;
    private JButton btnAdd, btnDelete, btnSearch, btnUpdate, btnDisplay;
    static JFrame frame = new JFrame();
    JProgressBar headingLabel = new JProgressBar();
  

    MainMenu() {

        JPanel headingPanel = new JPanel();
        headingPanel.setPreferredSize(new Dimension(714, 50));
        //JLabel headingLabel = new JLabel("VIVEKANAND STUDY CENTER");
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        headingLabel.setForeground(Color.black);
        headingPanel.add(headingLabel);
        headingPanel.setBounds(0, 7, 714, 70);
        
    	
    
		
		//headingLabel.setComponentOrientation(0); //JProgressBar.HORIZONTAL;//spin style
		
		headingLabel.setFont(new Font("Colonna MT",Font.BOLD,40));
		headingLabel.setForeground(Color.red); //Spindle color
		headingLabel.setToolTipText("My Office");
		headingLabel.setIndeterminate(false);
		headingLabel.setString("VIVEKANAND STUDY CENTER" );
		headingLabel.setStringPainted(true);
		headingLabel.setBorderPainted(false);
		
		headingLabel.setBounds(0, 0, 714, 70);
		//Show string with FONT & Color
		
		setResizable(false);	


        frame.setTitle("VIVEKANAND STUDY CENTER");
        frame.setSize(750, 550);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        jpInfo.setBounds(0, 0, 714, 500);
        jpInfo.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jpInfo.add(headingPanel);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(440, 120, 235, 50);
        btnAdd.addActionListener(this);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(440, 190, 235, 50);
        btnDelete.addActionListener(this);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(440, 260, 235, 50);
        btnSearch.addActionListener(this);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(440, 330, 235, 50);
        btnUpdate.addActionListener(this);

        btnDisplay = new JButton("Display All Records");
        btnDisplay.setBounds(440, 400, 235, 50);
        btnDisplay.addActionListener(this);

        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.setBounds(20, 80, 350, 500);
        label.setIcon(new ImageIcon("C:\\Users\\abhis\\OneDrive\\Documents\\project\\Study Room's Center Software system\\pexels-cottonbro-studio-4861373.jpg"));// your image here
        // create a new ImageIcon with the ssers\abhis\Onpecified image file
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\abhis\\OneDrive\\Documents\\project\\Study Room's Center Software system\\pexels-cottonbro-studio-4861373.jpg");

        // get the image from the imageIcon
        Image image = imageIcon.getImage();

        // get the dimensions of the panel
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        // scale the image to fit within the panel dimensions
        Image scaledImage = image.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);

        // create a new ImageIcon with the scaled image
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        // set the scaled ImageIcon as the icon for the label
        label.setIcon(scaledImageIcon);
        panel.add(label);


        // Adding the All the Controls to Panel.
        jpInfo.add (btnAdd);
        jpInfo.add (btnDelete);
        jpInfo.add (btnUpdate);
        jpInfo.add (btnSearch);
        jpInfo.add (btnDisplay);
        jpInfo.add (panel);
        jpInfo.add(headingPanel);

        frame.getContentPane().add (jpInfo);
        frame.setVisible (true);
    }
    	
    		

    	private void setLocation(int i, int j) {
		// TODO Auto-generated method stub
		
	}
        private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}
        private void setSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}
        private void add(JProgressBar jprgbar2) {
		// TODO Auto-generated method stub
		
	}



		public static void main(String[] args) {
    	    new MainMenu();
    	    MainMenu obj = new MainMenu();
    	}


    public void actionPerformed1(ActionEvent e) {
        // TODO Auto-generated method stub
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		   if (e.getSource() == btnAdd) { // check if the source of the event is the btnAdd button
		        Add addWindow = new Add(); // create an instance of the Add class
		        addWindow.setVisible(true); // show the Add window
		   }
		   if (e.getSource() == btnDelete) { // check if the source of the event is the btnAdd button
		         Delete deleteWindow = new Delete(); // create an instance of the Add class
		         deleteWindow.setVisible(true); // show the delete window
		    }
		    if (e.getSource() == btnSearch) { // check if the source of the event is the btnAdd button
		         search searchWindow = new search(); // create an instance of the Add class
		         searchWindow.setVisible(true); // show the search window
		    }
		    if (e.getSource() == btnUpdate) { // check if the source of the event is the btnAdd button
		    	Update updateWindow = new Update(); // create an instance of the Add class
		    	updateWindow.setVisible(true); // show the update window
		    }
		    if (e.getSource() == btnDisplay) { // check if the source of the event is the btnAdd button
		    	Display.display(); // show the Add window
		    }

		
	}
}
