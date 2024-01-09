import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class search extends JFrame implements ActionListener {
	JPanel  jpInfo = new JPanel();
	JLabel L1,headingLabel,confirmationlabel;
	JTextField tf1;
	JButton btnSearch, btnCancel,btnDone;
	JFrame frame = new JFrame();
	
	search()
	{
	super("Search user Information");
	setSize(400,300);
	setLocationRelativeTo(null);
	setVisible(true);
	setResizable(false);
	
	headingLabel = new JLabel("Search Enquiry");
	headingLabel.setFont(new Font("times new Roman", Font.BOLD, 24));
	headingLabel.setBounds(105,20,250,35);
	
	L1 = new JLabel("Mobile No");
	L1.setForeground(Color.black);
	L1.setFont(new Font("times new Roman",0,18));
	L1.setBounds(40,70,250,35);
	tf1 = new JTextField();
	tf1.setBounds(130,70,200,35);
	
	jpInfo.setBounds(0,0,500,115);
	jpInfo.setLayout(null);

	
	btnSearch = new JButton("Search");
	btnSearch.setBounds(70,150,120,35);
	btnSearch.addActionListener(this);
	
	btnCancel = new JButton("Cancel");
	btnCancel.setBounds(220, 150, 120, 35);
	btnCancel.addActionListener(this);
	
	
	
    jpInfo.add(L1);
	jpInfo.add(tf1);
	jpInfo.add(btnSearch);
	jpInfo.add(btnCancel);
	jpInfo.add(headingLabel);
	
	


	getContentPane().add(jpInfo);
	}
	
	public static void main(String[] args) {
		search obj = new search();
		obj.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnSearch) {
	        String mobno = tf1.getText();

	        try {
	            // Connect to the database
	            DAO db = new DAO();
	            Connection conn = db.getConnection();

	            // Prepare a SQL statement to search for the user based on their mobile number
	            String selectQuery = "SELECT * FROM studentdb WHERE mobno = ?";
	            PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
	            preparedStatement.setString(1, mobno);

	            // Execute the query
	            ResultSet result = preparedStatement.executeQuery();

	            // Check if a user was found
	            if (result.next()) {
	                // If a user was found, create a new window to display their information
	                final JFrame resultFrame = new JFrame("User Information");
	                //resultFrame.setSize(600, 500);
	                resultFrame.setSize(580,580);
	                resultFrame.setLocationRelativeTo(null);

	                JPanel jpInfo = new JPanel();
	                //jpInfo.setLayout(new GridLayout(8, 2));
	                //jpInfo.setPreferredSize(new Dimension(400, 300));
	                //JPanel.setLayout(null);
	                jpInfo.setLayout(null);
	                

	                // Add labels and text fields to display the user information
	                JLabel userIDLabel = new JLabel("User ID:");
	                userIDLabel.setBounds(100,70,250,35);
	                JTextField userIDField = new JTextField(result.getString("userID"));
	                userIDField.setBounds(250,70,200,35);
	                userIDField.setEditable(false);
	                userIDLabel.setForeground(Color.black);
	                userIDLabel.setFont(new Font("times new Roman",0,18));
	                userIDField.setForeground(Color.black);
	                userIDField.setFont(new Font("times new roman",0,18));
	               
	            
	        		

	                JLabel nameLabel = new JLabel("Name:");
	                JTextField nameField = new JTextField(result.getString("name"));
	                nameField.setEditable(false);
	                nameLabel.setBounds(100,110,250,35);
	                nameField.setBounds(250,110,200,35);
	                nameLabel.setForeground(Color.black);
	                nameLabel.setFont(new Font("times new Roman",0,18));
	                nameField.setForeground(Color.black);
	                nameField.setFont(new Font("times new roman",0,18));
	               

	                JLabel emailLabel = new JLabel("Email:");
	                JTextField emailField = new JTextField(result.getString("email"));
	                emailField.setEditable(false);
	                emailLabel.setBounds(100,150,250,35);
	        		emailField.setBounds(250,150,200,35);
	        		emailLabel.setForeground(Color.black);
	        		emailLabel.setFont(new Font("times new Roman",0,18));
	        		emailField.setForeground(Color.black);
	        		emailField.setFont(new Font("times new roman",0,18));
	               

	                JLabel mobnoLabel = new JLabel("Mobile Number:");
	                JTextField mobnoField = new JTextField(result.getString("mobno"));
	                mobnoField.setEditable(false);
	                mobnoLabel.setBounds(100,190,250,35);
	        		mobnoField.setBounds(250,190,200,35);
	        		mobnoLabel.setForeground(Color.black);
	        		mobnoLabel.setFont(new Font("times new Roman",0,18));
	        		mobnoField.setForeground(Color.black);
	        		mobnoField.setFont(new Font("times new roman",0,18));
	                

	                JLabel parentsMobNoLabel = new JLabel("Parent's Mobile No:");
	                JTextField parentsMobNoField = new JTextField(result.getString("parentsMobNo"));
	                parentsMobNoField.setEditable(false);
	                parentsMobNoLabel.setBounds(100,230,250,35);
	                parentsMobNoField.setBounds(250,230,200,35);
	                parentsMobNoLabel.setForeground(Color.black);
	                parentsMobNoLabel.setFont(new Font("times new Roman",0,18));
	                parentsMobNoField.setForeground(Color.black);
	                parentsMobNoField.setFont(new Font("times new roman",0,18));
	                

	                JLabel collegeNameLabel = new JLabel("College Name:");
	                JTextField collegeNameField = new JTextField(result.getString("collegeName"));
	                collegeNameField.setEditable(false);
	                collegeNameLabel.setBounds(100,270,250,35);
	                collegeNameField.setBounds(250,270,200,35);
	                collegeNameLabel.setForeground(Color.black);
	                collegeNameLabel.setFont(new Font("times new Roman",0,18));
	                collegeNameField.setForeground(Color.black);
	                collegeNameField.setFont(new Font("times new roman",0,18));
	                

	                JLabel preferredTimeLabel = new JLabel("Preferred Time:");
	                JTextField preferredTimeField = new JTextField(result.getString("preferredTime"));
	                preferredTimeField.setEditable(false);
	                preferredTimeLabel.setBounds(100,310,250,35);
	                preferredTimeField.setBounds(250,310,200,35);
	                preferredTimeLabel.setForeground(Color.black);
	                preferredTimeLabel.setFont(new Font("times new Roman",0,18));
	                preferredTimeField.setForeground(Color.black);
	                preferredTimeField.setFont(new Font("times new roman",0,18));
	                
	                
	                

	                JLabel educationLabel = new JLabel("Education:");
	                JTextField educationField = new JTextField(result.getString("education"));
	                educationField.setEditable(false);
	                educationLabel.setBounds(100,350,250,35);
	                educationField.setBounds(250,350,200,35);
	                educationLabel.setForeground(Color.black);
	                educationLabel.setFont(new Font("times new Roman",0,18));
	                educationField.setForeground(Color.black);
	                educationField.setFont(new Font("times new roman",0,18));
	                
	                btnDone = new JButton("Done!!!");
	            	btnDone.setBounds(250, 450, 120, 35);
	            	btnDone.addActionListener(this);
	                
	                
	                

	                // Add the labels and text fields to the panel
	                jpInfo.add(userIDLabel);
	                jpInfo.add(userIDField);
	                jpInfo.add(nameLabel);
	                jpInfo.add(nameField);
	                jpInfo.add(emailLabel);
	                jpInfo.add(emailField);
	                jpInfo.add(mobnoLabel);
	                jpInfo.add(mobnoField);
	                jpInfo.add(parentsMobNoLabel);
	                jpInfo.add(parentsMobNoField);
	                jpInfo.add(collegeNameLabel);
	                jpInfo.add(collegeNameField);
	                jpInfo.add(preferredTimeLabel);
	                jpInfo.add(preferredTimeField);
	                jpInfo.add(educationLabel);
	                jpInfo.add(educationField);
	                jpInfo.add(btnDone);
	                btnDone.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        // close the window
	                        resultFrame.dispose();
	                    }
	                });
	                
	             
	                // Add the panel to the window
	                resultFrame.getContentPane().add(jpInfo);
	                resultFrame.setVisible(true);
	                resultFrame.setResizable(false);
	                
	             

	            } else {
	                // If no user was found, display an error message
	                JOptionPane.showMessageDialog(this, "No user with that mobile number found.");
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            }
	        }
		        
	    else if(e.getSource() == btnCancel) {
	        dispose();
	        
	    }
	}
}
