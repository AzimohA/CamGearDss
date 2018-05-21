package CameraGearProject.views;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CameraGearProject.classes.DatabaseConnection;
import net.proteanit.sql.DbUtils;

public class SearchBar extends CameraBodies{

public void Search(){
	
	if(txt_min.getText().isEmpty()){
		try{
			
			connection=DatabaseConnection.dbconector();
			String query = "SELECT * FROM Camerabodies where Manufacturer like'%"
			+getTxt_manufacturer().getText()
			+"%' OR Cameramodel like'%"+getTxt_manufacturer().getText()
	        +"%'OR Sensorsize like'%"+getTxt_manufacturer().getText()+ "%'"
	        + "ORDER by Manufacturer, Price";
	       
			 PreparedStatement statement = connection.prepareStatement(query);
			 ResultSet rs = statement.executeQuery();
			 
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 ob.modifyColumn();
				
			}catch(Exception e1){
				//error handler
				e1.printStackTrace();
			}  
		
	}else if (txt_min.getText()!=null){
		PriceRange.priceRange();
	}
		

	}

}
