
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DatabaseConnection {
Connection connection=null;
	
	public static Connection dbconnector(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alemseged\\Desktop\\SQLiteStudio\\Cameragear");
			//JOptionPane.showMessageDialog(null, "WELCOME CAMERA GEAR APP");
			
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e); 
			return null;
			
		}
	}

}