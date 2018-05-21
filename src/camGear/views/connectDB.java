package camGear.views;

import java.sql.*;

/**
 * @author AZIMOH A.B
 *
 * ${tags}
 */

public class connectDB{
	Connection connect = null;
//	public connectDB(){
//		dbConnector();
//		}
	public static Connection dbConnector(){
		try{
	      Class.forName("org.sqlite.JDBC");
	     // Connection connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Toshiba\\Downloads\\sqlitestudio-3.0.7\\SQLiteStudio\\CamerGearDssDB");
	      Connection connect = DriverManager.getConnection("jdbc:sqlite::resource:CamerGearDssDB");			
	      System.out.println("... ... Connection to the database succesfull!!");
	      return connect;
		}catch(Exception e){
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	     // return null;
		}
		
		return null;
	}
	
}
//{
//  public static void main( String args[] )
//  {
//    Connection connect = null;
//    try {
//      Class.forName("org.sqlite.JDBC");
//      connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Toshiba\\Downloads\\sqlitestudio-3.0.7\\SQLiteStudio\\CamerGearDssDB");
//    } catch ( Exception e ) {
//      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//      System.exit(0);
//    }
//    System.out.println("Opened database successfully");
//  }
//}