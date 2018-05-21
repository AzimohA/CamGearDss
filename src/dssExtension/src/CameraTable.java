package CameraGearProject.views;

import javax.swing.JTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CameraGearProject.classes.DatabaseConnection;
import javafx.scene.control.TableFocusModel;
import net.proteanit.sql.DbUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;

public class CameraTable extends CameraBodies{
	
	 
		public void modifyColumn(){
	    
			// manages the camera body table
			table.getColumnModel().getColumn(4).setWidth(0);
			table.getColumnModel().getColumn(4).setMinWidth(0);
	        table.getColumnModel().getColumn(4).setMaxWidth(0);
	         
	        table.getColumnModel().getColumn(5).setWidth(0);
	        table.getColumnModel().getColumn(5).setMinWidth(0);
	        table.getColumnModel().getColumn(5).setMaxWidth(0);
	         
	        table.getColumnModel().getColumn(6).setWidth(0);
	        table.getColumnModel().getColumn(6).setMinWidth(0);
	        table.getColumnModel().getColumn(6).setMaxWidth(0);
	         
//	        table.getColumnModel().getColumn(7).setWidth(0);
//	        table.getColumnModel().getColumn(7).setMinWidth(0);
//	        table.getColumnModel().getColumn(7).setMaxWidth(0);
		}
		
		public void pricecol(){
			//manages price
		}

	

}
