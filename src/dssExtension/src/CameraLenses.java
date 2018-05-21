package CameraGearProject.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import CameraGearProject.classes.DatabaseConnection;
import net.proteanit.sql.DbUtils;

public class CameraLenses extends CameraBodies{
   public static void LenseSearch(){

		try{ 
		
			connection=DatabaseConnection.dbconector();
			 minpr=txt_min.getText();
		     maxpr=txt_max.getText();
		    
		     String query ="SELECT DISTINCT Camerabodies.Manufacturer, Camerabodies.Cameramodel, Lenses.Focallength, Lenses.Min_Aperture, Lenses.Price FROM Lenses "
		     		+ "JOIN Camerabodies ON Lenses.Mount = Camerabodies.Mount AND Lenses.Sensorsize = Camerabodies.Sensorsize";
		     
		     //String query= ("Select DISTINCT Camerabodies.Manufacturer, Lenses.Focallength, Lenses.Min_Aperture, Lenses.Price"
         	//		+ " FROM Lenses JOIN Camerabodies ON Lenses.Mount = Camerabodies.Mount");
	   	
			PreparedStatement pr = connection.prepareStatement(query);
			ResultSet rs = pr.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs)); 
		    //lenseTable.LenseColumn();
		    

		}catch(Exception e){
			
		}
		
   }
}
