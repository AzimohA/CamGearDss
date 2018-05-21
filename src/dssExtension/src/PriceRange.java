package CameraGearProject.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import CameraGearProject.classes.DatabaseConnection;
import net.proteanit.sql.DbUtils;

public class PriceRange extends CameraBodies {
	public PriceRange(){
		priceRange();
			
	}

public static void priceRange(){
	
			connection=DatabaseConnection.dbconector();
			//declare the string variable for min, max and Price
			 minpr=txt_min.getText();
		     maxpr=txt_max.getText();
		
			//Show all camera	models	with min-max price. ordered by manufacturer and by price
			try{
				String query = "SELECT * FROM Camerabodies where Price between '"+minpr+"' and '"+maxpr+"'"
						+ "AND Manufacturer like'%"+getTxt_manufacturer().getText()+"%'" 
					    + "ORDER by Manufacturer, Price";
				
          		PreparedStatement statement = connection.prepareStatement(query);
          		ResultSet rs = statement.executeQuery();
          		table.setModel(DbUtils.resultSetToTableModel(rs));
          		ob.modifyColumn();
          	
				
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}

}
