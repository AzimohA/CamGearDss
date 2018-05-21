package CameraGearProject.views;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelectItem extends CameraBodies {
	public SelectItem(){
		// item details
		selectItem();
	}

	public static void selectItem() {
		// TODO Auto-generated method stub
	
		CameraBodies.table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//if(!e.getValueIsAdjusting() && table.getSelectedIndex() >= 0){	 
				if(!e.getValueIsAdjusting() && table.getSelectedRow() >= 0){	
						nextPage.setVisible(true);
						
				if(rdbtnRadioButton.isSelected()==false){
					nextPage.paneHeader.setText("Manufacturer \n"
  		                    + "Cameramodel \n"
  	                     	+ "Mount \n"
  		                    + "Sensor size \n"
  		                    + "ISO \n"    
  		                    + "Max shutter speed \n"
  		                    + "Weight \n"
  		                    + "Price");
					CameraBodies.nextPage.paneHeader.setEditable(false);
					
	CameraBodies.nextPage.textPane.setText(table.getValueAt(CameraBodies.table.getSelectedRow(), 0).toString() +
    		"\n"+ table.getValueAt(table.getSelectedRow(), 1).toString()+
    		"\n"+ table.getValueAt(table.getSelectedRow(), 2).toString()+
    		"\n"+ table.getValueAt(table.getSelectedRow(), 3).toString()+		    		
    		"\n"+ table.getValueAt(table.getSelectedRow(), 4).toString()+
    		"\n"+ table.getValueAt(table.getSelectedRow(), 5).toString()+
    		"\n"+ table.getValueAt(table.getSelectedRow(), 6).toString()+
            "\n"+ table.getValueAt(table.getSelectedRow(), 7).toString());
	CameraBodies.nextPage.textPane.setEditable(true);
				}
				else if(rdbtnRadioButton.isSelected()==true){
					nextPage.paneHeader.setText("Manufacturer \n"
  		                    + "Cameramodel \n"
  	                     	+ "Mount \n"
  	                     	+ "Lense Model \n"
  		                    + "Sensor size \n"
  		                    + "Price");
					CameraBodies.nextPage.textPane.setText("...");
				    		//"\n"+ table.getValueAt(table.getSelectedRow(), 5).toString());
				}
			
			}
          }
		});
	}

}
