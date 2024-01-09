

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Display {
static JFrame f = new JFrame("Student Database Records");
static DefaultTableModel dtmStudent;
static JTable tbStudent;
static JScrollPane jspTable;

static void populateArray (String rows[][])
{
	JPanel jpShow = new JPanel ();

	int row = 0;
	int total = 0;

	f.setSize (1000, 500);
	f.setLocation(200,200);

	tbStudent = makeTable (rows);
	jspTable = new JScrollPane (tbStudent);
	jspTable.setBounds (20, 20, 950, 500);
	
	
	

	jpShow.add (jspTable);
	jpShow.setLayout (null);

	f.getContentPane().add (jpShow);
    f.setAlwaysOnTop(true);
	f.setVisible (true);
}

private static JTable makeTable (String rowData[][])
{
	String cols[] = {"UserID", "Name", "Email", "Mobile No.", "Parents' Mobile No.", "College Name", "Preferred Time", "Education"};

	dtmStudent  = new DefaultTableModel (rowData, cols);

	tbStudent = new JTable (dtmStudent)
	{
		public boolean isCellEditable (int iRow, int iCol)
		{
			return false;	//Disable All Columns of Table.
		}
	};
	
	(tbStudent.getColumnModel().getColumn(0)).setPreferredWidth (80);
	(tbStudent.getColumnModel().getColumn(1)).setPreferredWidth (100);
	(tbStudent.getColumnModel().getColumn(2)).setPreferredWidth (120);
	(tbStudent.getColumnModel().getColumn(3)).setPreferredWidth (80);
	(tbStudent.getColumnModel().getColumn(4)).setPreferredWidth (120);
	(tbStudent.getColumnModel().getColumn(5)).setPreferredWidth (100);
	(tbStudent.getColumnModel().getColumn(6)).setPreferredWidth (100);
	(tbStudent.getColumnModel().getColumn(7)).setPreferredWidth (80);
	tbStudent.setRowHeight (25);
	tbStudent.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
	return tbStudent;
}

static String rows[][] = new String [100][8];
static int row = 0;

public static void display() 
{	  
   try
   {
	DAO db = new DAO();
	Connection conn = db.getConnection();
    String selectQuery = "select * from  studentdb";	    	    
    PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
    ResultSet result = preparedStatement.executeQuery();	      	      
    while (result.next())
    {	    	
		for (int i = 0; i < 8; i++)
			rows[row][i] =result.getString((i+1));
		row++;	
    }
    populateArray(rows);
  }
  catch(Exception e)
  {
	System.out.println(e);
  }	  
}

public static void main(String[] args) throws Exception 
{
	Display.display();
}
}