package CameraGearProject.views;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CameraBodies extends JFrame {

	private JPanel contentPane;
	static DetailsFrame nextPage = new DetailsFrame();
	static JRadioButton rdbtnRadioButton = new JRadioButton("Lense");
	static CameraTable ob = new CameraTable();
	static SearchBar bar = new SearchBar();
	static CameraLenses ls = new CameraLenses();
	static SelectItem sl = new SelectItem();

	/**
	 * Launch the application.
	 */
	static CameraBodies frame1 = new CameraBodies();
	static Connection connection=null; 
	static JTextField txt_manufacturer;
	private JLabel lblMinPrice;
	public static JTextField txt_min;
	private JLabel lblMaxPrice;
	public static JTextField txt_max;
	public static String minpr, maxpr;
	public static JButton btnSearchBar;
	public static JTable table;
	private JScrollPane scrollPane;
	protected Component showHidedePanel;
	public static JComboBox mountCombox;
	
	/**
	 * Create the frame.
	 */

	
	public CameraBodies()
	{
		setTitle("Camera Gear APP");
		init_Components();
		create_Events();
		connection=DatabaseConnection.dbconector();	
		SelectItem.selectItem();
	}

	//.......................................................................................
	//creating and initialising events
	public void init_Components()
	{
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSearchBar = new JButton("Search");
			
		btnSearchBar.setBounds(61, 24, 97, 23);
		
		btnSearchBar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		setTxt_manufacturer(new JTextField());
		
		
		getTxt_manufacturer().setBounds(172, 24, 105, 20);
		getTxt_manufacturer().setColumns(10);
		
		txt_min = new JTextField();
		txt_min.setBounds(168, 69, 53, 20);
		txt_min.setColumns(10);
		
		lblMaxPrice = new JLabel("Max Price");
		lblMaxPrice.setBounds(231, 72, 53, 14);
		
		txt_max = new JTextField();
		txt_max.setBounds(285, 69, 53, 20);
		txt_max.setColumns(10);
		contentPane.setLayout(null);
		
		lblMinPrice = new JLabel("Min price");
		lblMinPrice.setBounds(105, 72, 53, 14);
		contentPane.add(lblMinPrice);
		contentPane.add(btnSearchBar);
		contentPane.add(getTxt_manufacturer());
		contentPane.add(txt_min);
		contentPane.add(lblMaxPrice);
		contentPane.add(txt_max);
	
		rdbtnRadioButton.setBounds(86, 112, 105, 23);
		contentPane.add(rdbtnRadioButton);
		
		scrollPane = new JScrollPane();
		
		
		scrollPane.setBounds(15, 141, 603, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setMountCombox(new JComboBox());
		getMountCombox().setModel(new DefaultComboBoxModel(new String[] {"","Canon EF-M","Canon EF-S","Canon  EF", "Nikon F", "Sony  F", "Sony FE","Pentax KAF3","Fujifilm G","Sony E"}));
		getMountCombox().setToolTipText("select mount type");
		getMountCombox().setBounds(459, 100, 130, 20);
		//contentPane.add(getMountCombox());
		
	}
	
//create Events
//...............................................................................
public void create_Events(){
	 // new Thread(()->{
	//   table.getSelectionModel().clearSelection();	
	// }).start();
	
	//search item given in textfield
	
		btnSearchBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
		
				if (rdbtnRadioButton.isSelected()){
				    ls.LenseSearch();
				    }
				else
		        {
					 bar.Search();
			    }     
		     }
		});
 
}


public static JTextField getTxt_manufacturer() {
		return txt_manufacturer;
	}

	public void setTxt_manufacturer(JTextField txt_manufacturer) {
		this.txt_manufacturer = txt_manufacturer;
	}

	public static JComboBox getMountCombox() {
		return mountCombox;
	}

	public void setMountCombox(JComboBox mountCombox) {
		this.mountCombox = mountCombox;
	}
}


