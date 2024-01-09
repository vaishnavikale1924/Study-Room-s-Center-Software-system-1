import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Add extends JFrame implements ActionListener{
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JPanel  jpInfo = new JPanel();
	JLabel Pinlbl,L1,L2,L3,L4,L5,L6,L7,L8,headingLabel;
	JButton btnOk, btnCancel;
	JCheckBox c1, c2; 
	JFrame frame = new JFrame();
	Connection con = null;
	PreparedStatement ps = null;
	String username = "root";
	String password = "tiger";
	String DB_URL = "jdbc:mysql://localhost:3306/studyroomdb";
	
	
	
	Add(){
		super("Add Enquiry");
		setSize(580,580);
		setLocationRelativeTo(null);
		setVisible(true);
		
		headingLabel = new JLabel("Add Enquiry");
		headingLabel.setFont(new Font("times new Roman", Font.BOLD, 24));
		headingLabel.setBounds(225,30,250,35);
		
		L1 = new JLabel("User ID");
		L1.setForeground(Color.black);
		L1.setFont(new Font("times new Roman",0,18));
		L1.setBounds(100,70,250,35);
		tf1 = new JTextField();
		tf1.setBounds(250,70,200,35);
		
		L2 = new JLabel("Name");
		L2.setForeground(Color.black);
		L2.setFont(new Font("times new Roman",0,18));
		L2.setBounds(100,110,250,35);
		tf2 = new JTextField();
		tf2.setBounds(250,110,200,35);
		
		L3 = new JLabel("Email");
		L3.setForeground(Color.black);
		L3.setFont(new Font("times new Roman",0,18));
		L3.setBounds(100,150,250,35);
		tf3 = new JTextField();
		tf3.setBounds(250,150,200,35);
		
		L4 = new JLabel("Mob No");
		L4.setForeground(Color.black);
		L4.setFont(new Font("times new Roman",0,18));
		L4.setBounds(100,190,250,35);
		tf4 = new JTextField();
		tf4.setBounds(250,190,200,35);
		
		L5 = new JLabel("Parent Mob No");
		L5.setForeground(Color.black);
		L5.setFont(new Font("times new Roman",0,18));
		L5.setBounds(100,230,250,35);
		tf5 = new JTextField();
		tf5.setBounds(250,230,200,35);
		
		L6 = new JLabel("College Name");
		L6.setForeground(Color.black);
		L6.setFont(new Font("times new Roman",0,18));
		L6.setBounds(100,270,250,35);
		tf6 = new JTextField();
		tf6.setBounds(250,270,200,35);
		
		L7 = new JLabel("Preferred Time");
		L7.setForeground(Color.black);
		L7.setFont(new Font("times new Roman",0,18));
		L7.setBounds(100,310,250,35);
		
		c1 = new JCheckBox("Morning 8am to 2pm");
		c1.setBounds(250,320,200,20);
		c1.setFont(new Font("times new Roman",0,14));
		
		c2 = new JCheckBox("Afternoon 2pm to 10pm");
		c2.setBounds(250,350,200,20);
		c2.setFont(new Font("times new Roman",0,14));
		
		
		L8 = new JLabel("Education");
		L8.setForeground(Color.black);
		L8.setFont(new Font("times new Roman",0,18));
		L8.setBounds(100,390,250,35);
		tf7 = new JTextField();
		tf7.setBounds(250,390,200,35);
		
		jpInfo.setBounds(0,0,500,115);
		jpInfo.setLayout(null);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(250,450,120,35);
		btnOk.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(380, 450, 120, 35);
		btnCancel.addActionListener(this);
		
		jpInfo.add(headingLabel);
		jpInfo.add(L1);
		jpInfo.add(L2);
		jpInfo.add(L3);
		jpInfo.add(L4);
		jpInfo.add(L5);
		jpInfo.add(L6);
		jpInfo.add(L7);
		jpInfo.add(L8);
		jpInfo.add(tf1);
		jpInfo.add(tf2);
		jpInfo.add(tf3);
		jpInfo.add(tf4);
		jpInfo.add(tf5);
		jpInfo.add(tf6);
		jpInfo.add(tf7);
		jpInfo.add(c1);
		jpInfo.add(c2);
		jpInfo.add(btnOk);
		jpInfo.add(btnCancel);

        getContentPane().add(jpInfo);	
	      
	}
	
	public static void main(String[] args) {
		Add obj = new Add();
		obj.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == btnOk) {
	        String userID = tf1.getText();
	        String name = tf2.getText();
	        String email = tf3.getText();
	        String mobNo = tf4.getText();
	        String parentMobNo = tf5.getText();
	        String collegeName = tf6.getText();
	        String preferredTime = "";
	        if (c1.isSelected()) {
	            preferredTime += "Morning 8am to 2pm, ";
	        }
	        if (c2.isSelected()) {
	            preferredTime += "Afternoon 2pm to 10pm";
	        }
	        String education = tf7.getText();

	        try {
	            
	        	DAO db = new DAO();
	    		Connection conn = db.getConnection();
	    		//String insertQuery="Add student Enquiry(?,?,?,?,?,?,?)";
	    		
				
				PreparedStatement preparedStatement;
				
				String insertQuery = "insert into studentdb values(?,?,?,?,?,?,?,?)";
				
				//String insertQuery = "insert into student values('" + tf1.getText() + "','" + tf2.getText() + "','" + tf3.getText() + "','" + tf4.getText() + "','" + tf5.getText() + "','" + tf6.getText() + "','" + tf7.getText() + "')";

				
				preparedStatement=(PreparedStatement)conn.prepareStatement(insertQuery);
				preparedStatement.setString(1,userID+"");
				preparedStatement.setString(2,name); 
				preparedStatement.setString(3,email);
				preparedStatement.setString(4,mobNo);
				preparedStatement.setString(5,parentMobNo);
				preparedStatement.setString(6,collegeName);
				preparedStatement.setString(7,preferredTime);
				preparedStatement.setString(8,education);
				int rowsAdded = preparedStatement.executeUpdate();
				
				 if (rowsAdded > 0) {
         	        JOptionPane.showMessageDialog(null, "Student :  " + name + " has been Added succesfully.");
         	       dispose();
         	        }
				 else {
         	        JOptionPane.showMessageDialog(null, "Cannot Add this user");
         	       dispose();
         	        }
				 }
				 catch (SQLException ex) {
	            ex.printStackTrace();
	           
	        } finally {
	            try {
	                if (ps != null)
	                    ps.close();
	                if (con != null)
	                    con.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	    else if(e.getSource() == btnCancel) {
	        dispose();
	}
}
}