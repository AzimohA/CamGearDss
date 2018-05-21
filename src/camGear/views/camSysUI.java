package camGear.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.UIManager;
import java.sql.*;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * @author AZIMOH A.B
 *
 * ${tags}
 */

public class camSysUI extends JFrame {
/////Declared VariableS///////
	
	private JPanel contentPane;
	private JTextField textFieldmin;
	private JTextField textFieldmax;
	private JTable table1;
	private JTable table2;
	private JComboBox comboBox;
	private JCheckBox fullBody;
	private JCheckBox apscBody;
	private JLabel lblMax;
	private JTabbedPane tabbedPane;
	private JPanel panelSelected;
	private JButton btnSearch;
	private JButton btnClear;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxLense;
	private JCheckBox apscLense;
	private JCheckBox fullLense;
	private JTextPane textPane;
	private JTextPane textPaneDetail;
	private JScrollPane scrollPane_2;
	private JTextField textField5;
	private JRadioButton showLense;
	private JComboBox MountType;
	private JTable table3;
	private JScrollPane scrollPane_3;
	private JLabel lblMountType;
	private JLabel lblImageSensorSize;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	Connection connect = null;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camSysUI frame = new camSysUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public camSysUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(camSysUI.class.getResource("/camGear/resources/cam128.png")));
		initComponents();
		CreateEvents();
		connect = connectDB.dbConnector();
        tabbedPane.remove(scrollPane2);
        
	}
	
//////////////////////////////////////////////////////////////////////////////////
//////this method contains all the code for creating  and initializing events/////
//////////////////////////////////////////////////////////////////////////////////
	
	private void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 688);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSearch = new JButton("Search");
		btnSearch.setIconTextGap(10);
		btnSearch.setIcon(new ImageIcon(camSysUI.class.getResource("/camGear/resources/search24.png")));
		btnSearch.setToolTipText("Click this button to search.");
		
		btnClear = new JButton("Clear");
		btnClear.setToolTipText("Clear search filters");
		
		JLabel lblCameraBody = new JLabel("CAMERA BODY");
		lblCameraBody.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblLenses = new JLabel("LENSES");
		lblLenses.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Canon", "Sony", "Nikon", "Pentax"}));
		
		fullBody = new JCheckBox("Full-Frame");
		fullBody.setBackground(Color.WHITE);
		
		apscBody = new JCheckBox("APS-C");
		apscBody.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Price $");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblMin = new JLabel("min");
		
		textFieldmin = new JTextField();
		textFieldmin.setColumns(10);
		
		lblMax = new JLabel("max");
		
		textFieldmax = new JTextField();
		textFieldmax.setColumns(10);
		
		comboBoxLense = new JComboBox();
		
		comboBoxLense.setModel(new DefaultComboBoxModel(new String[] {"", "Canon", "Nikon", "Sony", "Sigma", "Tamaron"}));
		comboBoxLense.setName("");
		
		fullLense = new JCheckBox("Full-frame");
		fullLense.setBackground(Color.WHITE);
		
		apscLense = new JCheckBox("APS-C");
		apscLense.setBackground(Color.WHITE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		panelSelected = new JPanel();
		panelSelected.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "SELECTED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSelected.setBackground(Color.LIGHT_GRAY);
		
		lblNewLabel_1 = new JLabel("CAMERA GEAR DSS");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.ITALIC, 17));
		
		scrollPane_2 = new JScrollPane();
		
		JLabel lblSuggestItembodylense = new JLabel("suggested Lense attachment");
		lblSuggestItembodylense.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		textField5 = new JTextField();
		textField5.setColumns(10);
		
		showLense = new JRadioButton("Lense tab");
		showLense.setToolTipText("show lense table");
		
		MountType = new JComboBox();
		
		MountType.setModel(new DefaultComboBoxModel(new String[] {"", "EF", "EF-S", "Nikon F", "Pentax KAF2", "Sony E", "Sony/Minolta Alpha"}));
		
		table3 = new JTable();
		table3.setFillsViewportHeight(true);
		scrollPane_2.setViewportView(table3);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		JLabel lblProductDescription = new JLabel("Product description");
		lblProductDescription.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Specification");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		scrollPane_3 = new JScrollPane();
		GroupLayout gl_panelSelected = new GroupLayout(panelSelected);
		
		
		textPaneDetail = new JTextPane();
		scrollPane_3.setViewportView(textPaneDetail);
		textPaneDetail.setEditable(false);
		panelSelected.setLayout(gl_panelSelected);
		
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Camera Body", null, scrollPane, null);
		
		table1 = new JTable();
		table1.setFillsViewportHeight(true);
		//table1.putClientProperty("terminateEditOnFocusLost", Boolean.FALSE);
		scrollPane.setViewportView(table1);
		//table1.getTableHeader().getColumnModel().getColumn(0).setToolTipText("asdf");
		
		scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Camera Lenses", null, scrollPane2, null);
		
		table2 = new JTable();
		table2.setFillsViewportHeight(true);
		scrollPane2.setViewportView(table2);
		
		lblMountType = new JLabel("Mount Type");
		
		lblImageSensorSize = new JLabel("Image Sensor size");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
	
		
		gl_panelSelected.setHorizontalGroup(
				gl_panelSelected.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelSelected.createSequentialGroup()
						.addGroup(gl_panelSelected.createParallelGroup(Alignment.TRAILING)
							.addComponent(scrollPane_3, Alignment.LEADING)
							.addGroup(Alignment.LEADING, gl_panelSelected.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblNewLabel_2))
							.addComponent(lblProductDescription, Alignment.LEADING)
							.addComponent(textPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
						.addGap(0))
			);
			gl_panelSelected.setVerticalGroup(
				gl_panelSelected.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelSelected.createSequentialGroup()
						.addComponent(lblNewLabel_2)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
						.addGap(29)
						.addComponent(lblProductDescription)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
						.addContainerGap())
			);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(797, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCameraBody)
								.addComponent(lblLenses)
								.addComponent(comboBoxLense, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMountType)
								.addComponent(MountType, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(apscLense)
								.addComponent(fullLense)
								.addComponent(lblImageSensorSize)
								.addComponent(apscBody)
								.addComponent(fullBody, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblMin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldmin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMax)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldmax, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
							.addGap(60)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)))
												.addGap(10))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblSuggestItembodylense)
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addComponent(panelSelected, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnClear)
										.addGap(20)
										.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(showLense)
										.addContainerGap()))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(17)
					.addComponent(btnSearch)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnClear)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(showLense))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCameraBody)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblImageSensorSize)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(apscBody)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fullBody)
							.addGap(18)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldmin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblMin))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblMax)
									.addComponent(textFieldmax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(20)
							.addComponent(lblLenses)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxLense, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMountType)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(MountType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(apscLense)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fullLense))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblSuggestItembodylense)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
						.addComponent(panelSelected, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
      /////////////////////////////////////////////////
      //method contains all code for creating events.//
      /////////////////////////////////////////////////	
	
	
	private void CreateEvents(){
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showLense.isSelected()== false){
				
				
				try{
					////// sort table by name, image sensor size= APS-C and price range
				   if( textField5.getText()!= null && apscBody.isSelected()&&fullBody.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false ){
						 String query3 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'APS-C'"+"AND MSRP >= '"+textFieldmin.getText()+"'"+"AND MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, MSRP";
						    try {
							PreparedStatement ps3t = connect.prepareStatement(query3);
							ResultSet rs3 = ps3t.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs3));
						    } catch (SQLException e1) {e1.printStackTrace();} 
					 }
				   ///////sort table by name, image sensor size = Full frame and price if a given range 
				   else if( textField5.getText()!= null && apscBody.isSelected()==false&&fullBody.isSelected()&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false ){
						 String query3 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'Full frame'"+"AND MSRP >= '"+textFieldmin.getText()+"'"+"AND MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, MSRP";
						    try {
							PreparedStatement ps3t = connect.prepareStatement(query3);
							ResultSet rs3 = ps3t.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs3));
						    } catch (SQLException e1) {e1.printStackTrace();} 
					 }

					/////sort by name and image sensor size APS-C////
					else if ( textField5.getText()!= null && apscBody.isSelected()&&fullBody.isSelected()==false ){
						  
						 String query3 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'APS-C'"+"ORDER BY Manufacturer, MSRP";
						    try {
							PreparedStatement ps3t = connect.prepareStatement(query3);
							ResultSet rs3 = ps3t.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs3));
							
						    } catch (SQLException e1) {e1.printStackTrace();}
						    
					 }
					  
					/////sort by name and image sensor size Full frame////
					 else if ( textField5.getText()!= null && apscBody.isSelected()==false&&fullBody.isSelected()){
						   String query3 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'Full frame'"+"ORDER BY Manufacturer, MSRP";
						    try {
							PreparedStatement ps3t = connect.prepareStatement(query3);
							ResultSet rs3 = ps3t.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs3));
						} catch (SQLException e1) {e1.printStackTrace();}
					 }
					 //////filter table given name
					else if ( textField5.getText() != null && textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty() ){
						   String query4 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+"ORDER BY Manufacturer, MSRP";
						  // String query2 = "SELECT * FROM CameraLenses where Lense_MSRP = 0";
						    try {
							PreparedStatement ps4t = connect.prepareStatement(query4);
						//	PreparedStatement pst2 = connect.prepareStatement(query2);
							ResultSet rs4 = ps4t.executeQuery();
						//	ResultSet rs2 = pst2.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs4));
						//	table2.setModel(DbUtils.resultSetToTableModel(rs2));
						} catch (SQLException e1) {e1.printStackTrace();}
						
					 }
					//////filter table by name and a given price range
					else if ( textField5.getText()!= null && textFieldmin.getText() != null && textFieldmax.getText() != null ){
						   String query3 = "select * from CameraBody where Manufacturer like '%" + textField5.getText() + "%'"+ "AND MSRP >= '"+textFieldmin.getText()+"'"+"AND MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, MSRP";
						    try {
							PreparedStatement ps3t = connect.prepareStatement(query3);
							ResultSet rs3 = ps3t.executeQuery();
							table1.setModel(DbUtils.resultSetToTableModel(rs3));
							 
						    } catch (SQLException e1) {e1.printStackTrace();}
					 }
				
				}catch(Exception er){
					System.err.println(er+"error");
				}
			}
			 ///
             /// queries for displaying filtered lenses table//
			 ///	
				else {
					try{
						///////////filter by name, mount and sensor size APS-C 
						      if ( textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()&&fullLense.isSelected()==false && textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query813 ="select * from CameraLenses where MountType like'" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'APS-C'"+"ORDER BY Manufacturer, Lense_MSRP";   
								 try {
									PreparedStatement ps3t113 = connect.prepareStatement(query813);
									ResultSet rs813 = ps3t113.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs813));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
                   //////filter by  name, mount type and sensor size full frame
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
							//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
							 String query81 ="select * from CameraLenses where MountType like'" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'Full Frame'"+"ORDER BY Manufacturer, Lense_MSRP";
							 try {
								PreparedStatement ps3t11 = connect.prepareStatement(query81);
								ResultSet rs81 = ps3t11.executeQuery();
								table2.setModel(DbUtils.resultSetToTableModel(rs81));
							} catch (SQLException e1) {e1.printStackTrace();}
				//////filter lenses table by name,Mount type and all sensor size	 		 
						 } 
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()&&fullLense.isSelected()&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
							//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
							 String query812 ="select * from CameraLenses where MountType like'" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"ORDER BY Manufacturer, Lense_MSRP";
							 try {
								PreparedStatement ps3t112 = connect.prepareStatement(query812);
								ResultSet rs812 = ps3t112.executeQuery();
								table2.setModel(DbUtils.resultSetToTableModel(rs812));
							} catch (SQLException e1) {e1.printStackTrace();}
						 }
				///////////filter by name, mount type		 
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query813 ="select * from CameraLenses where MountType like'" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"ORDER BY Manufacturer, Lense_MSRP";  
								 try {
									PreparedStatement ps3t113 = connect.prepareStatement(query813);
									ResultSet rs813 = ps3t113.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs813));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		//////filter only by image sensor size = APS-C
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'APS-C'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
	////////////filter by image sensor= APSC and price range					      
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'APS-C'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		///////filter by image sensor size = Full Frame				      
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()==false&&fullLense.isSelected()&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'Full Frame'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		/////filter by image sensor size =full frmae and price range				      
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()==false&&fullLense.isSelected()&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND ImageSensorSize == 'Full Frame'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		////filter by a given price range				
						 else if (textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
	 ////////sort lense by mount
						 else if ( textField5.getText()== null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where MountType like '" + MountType.getSelectedItem() + "'"+"ORDER BY Manufacturer, Lense_MSRP";   
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
	//////filter lense by mount and price range					      
						 else if (textField5.getText()== null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query812 ="select * from CameraLenses where MountType like '" + MountType.getSelectedItem() + "'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP";  
								 try {
									PreparedStatement ps3t112 = connect.prepareStatement(query812);
									ResultSet rs812 = ps3t112.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs812));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		////filter lenses by name				
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty() && textFieldmax.getText().isEmpty()){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		////filter by name and price of a given range				      
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()=="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
		////////sort by name, mount and price				      
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where MountType like '" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP";   
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }  
	////////sort by name, mount, price and sensor size =APS-C					      
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()&&fullLense.isSelected()==false&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where MountType like '" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'%" + textField5.getText() + "%'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"AND ImageSensorSize == 'APS-C'"+"ORDER BY Manufacturer, Lense_MSRP";   
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
 ///////////sort by name, mount, price and sensor size =Full Frame						      
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()==false&&fullLense.isSelected()&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where MountType like '" + MountType.getSelectedItem() + "'"+"AND Manufacturer like'" + textField5.getText() + "'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"AND ImageSensorSize == 'Full Frame'"+"ORDER BY Manufacturer, Lense_MSRP";   
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
	/////////sort by name name,price,mount,image sensor size					
						 else if ( textField5.getText()!= null &&MountType.getSelectedItem()!="" && apscLense.isSelected()&&fullLense.isSelected()&& textFieldmin.getText().isEmpty()==false && textFieldmax.getText().isEmpty()==false){
								//   String query81 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"; 
								 String query814 ="select * from CameraLenses where Manufacturer like '%" + textField5.getText() + "%'"+"AND MountType like'" + MountType.getSelectedItem()+ "'"+"AND Lense_MSRP >= '"+textFieldmin.getText()+"'"+"AND Lense_MSRP <= '"+textFieldmax.getText()+"'"+"ORDER BY Manufacturer, Lense_MSRP"; 
								 try {
									PreparedStatement ps3t114 = connect.prepareStatement(query814);
									ResultSet rs814 = ps3t114.executeQuery();
									table2.setModel(DbUtils.resultSetToTableModel(rs814));
								} catch (SQLException e1) {e1.printStackTrace();}
							 }
					
					}catch(Exception er){
						System.err.println(er+"error");}
					
					
				}
			}
		});
		/////////////////////enable combo box when tab is focused
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showLense.isSelected()==false){
				try{
				   if(comboBox.getSelectedItem() != null){
					textField5.setText((String) comboBox.getSelectedItem());
				   }
			      }
				catch(Exception ex){}
				}else{
					try{
						if(comboBox.getSelectedItem() != null){
							textField5.setText((String) comboBoxLense.getSelectedItem());
						}
					}catch(Exception ex){}
				}
			}
		});
	
///////Reset frame components/////////
		
	btnClear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try {
					textPaneDetail.setText("...");
					textPane.setText("...");
					textField5.setText("");
					table1.setModel(new DefaultTableModel());
					table2.setModel(new DefaultTableModel());
					table3.setModel(new DefaultTableModel());
					textFieldmin.setText("");
					textFieldmax.setText("");
					comboBox.setSelectedIndex(0);
					comboBoxLense.setSelectedIndex(0);
					MountType.setSelectedIndex(0);
					apscBody.setSelected(false);
					fullBody.setSelected(false);
					apscLense.setSelected(false);
					fullLense.setSelected(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 	       }  
	});
	
	////// this event disables lense combo box when when lense tab is closed////// 
	
	comboBoxLense.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(showLense.isSelected()== false){
					try{
						if(comboBoxLense.getSelectedItem() != null){
					//textField5.setText((String) comboBox.getSelectedItem());
							
						}
						}catch(Exception ex){}		
			}else{
				try{
				if(comboBoxLense.getSelectedItem() != null){
			     textField5.setText((String) comboBoxLense.getSelectedItem());
				}
				}catch(Exception ex){}	
			}
		}
	});
	

	////////////////////////////////////////
	////sort
	table2.getTableHeader().addMouseListener(new MouseAdapter() {
		  public void mouseClicked(MouseEvent e) {
		        int col = table2.columnAtPoint(e.getPoint());
		        String name = table2.getColumnName(col);
		   //  System.out.println("Column index selected " + col + " " + name);
		        if(col == 5){
					try{
						 
						String query6 = "SELECT * FROM CameraLenses"+" ORDER BY Lense_MSRP";
						
						PreparedStatement pst3 = connect.prepareStatement(query6);
						ResultSet rs6 = pst3.executeQuery();
						JOptionPane.showMessageDialog(null, "sort by price");
						table2.setModel(DbUtils.resultSetToTableModel(rs6));
						
					}catch(Exception e1){
						e1.printStackTrace();
					}
		        }
		       
		    }
		});
	///// action listener for rows
	table1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
	if (!event.getValueIsAdjusting()) {//This line prevents double events
        		//System.out.println(table1.getValueAt(table1.getSelectedRow(), 10).toString());

        		  textPaneDetail.setText(table1.getValueAt(table1.getSelectedRow(), 10).toString());
        	      textPane.setText("Manufacturer:           "+table1.getValueAt(table1.getSelectedRow(), 0).toString()+"\n"
        		                  +"Model Name:           "+table1.getValueAt(table1.getSelectedRow(), 1).toString()+"\n"
        		                  +"Image sensor size: "+table1.getValueAt(table1.getSelectedRow(), 2).toString()+"\n"
        		                  +"Resolution:               "+table1.getValueAt(table1.getSelectedRow(), 3).toString()+" mp"+"\n"
        		                  +"Maximum Iso:           "+table1.getValueAt(table1.getSelectedRow(), 4).toString()+"\n"
        		                  +"Max shutter speed:  "+table1.getValueAt(table1.getSelectedRow(), 5).toString()+"\n"
        		                  +"Camera weight:        "+table1.getValueAt(table1.getSelectedRow(), 6).toString()+"\n"
        		                  +"Pop-up flash:            "+table1.getValueAt(table1.getSelectedRow(), 7).toString()+"\n"
        		                  +"Price(MSRP):            "+"$"+table1.getValueAt(table1.getSelectedRow(), 8).toString()+"\n"
        		                  +"Mount Type:              "+table1.getValueAt(table1.getSelectedRow(), 9).toString()+"\n"
                		          );
        	 
        	      try{
  					String query6 ="SELECT * FROM CameraLenses where MountType like '" +table1.getValueAt(table1.getSelectedRow(), 9)+ "'"+"AND ImageSensorSize like'" +table1.getValueAt(table1.getSelectedRow(), 2)+ "'"+"ORDER BY Manufacturer, Lense_MSRP";
        	    	PreparedStatement pst6 = connect.prepareStatement(query6);
  					ResultSet rs6 = pst6.executeQuery();
  					table3.setModel(DbUtils.resultSetToTableModel(rs6));
  				}catch(Exception e1){
  					e1.printStackTrace();
  				}

        	}
            
        }
    });

	///table2 sorting
	table2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
      public void valueChanged(ListSelectionEvent event) {
	   if (!event.getValueIsAdjusting()) {//This line prevents double events
        		//System.out.println(table2.getValueAt(table2.getSelectedRow(), 7).toString());
        		  textPaneDetail.setText(table2.getValueAt(table2.getSelectedRow(), 8).toString());
        	      textPane.setText("Manufacturer:     "+table2.getValueAt(table2.getSelectedRow(), 0).toString()+"\n"
        		                  +"Focal Length:     "+table2.getValueAt(table2.getSelectedRow(), 1).toString()+"\n"
        		                  +"Min Aperture:     "+table2.getValueAt(table2.getSelectedRow(), 2).toString()+"\n"
        		                  +"Max Aperture:     "+table2.getValueAt(table2.getSelectedRow(), 3).toString()+" mp"+"\n"
        		                  +"Lense Weight:   "+table2.getValueAt(table2.getSelectedRow(), 4).toString()+"\n"
        		                  +"Price:                   "+"$"+table2.getValueAt(table2.getSelectedRow(), 5).toString()+"\n"
        		                  +"Image Sensor size:"+table2.getValueAt(table2.getSelectedRow(), 6).toString()+"\n"
        		                  +"Mount Type:       "+table2.getValueAt(table2.getSelectedRow(), 7).toString()+"\n"
               		          );
        	}
            
        }
    });

	////table3 sorting
	table3.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	      public void valueChanged(ListSelectionEvent event) {
		   if (!event.getValueIsAdjusting()) {//This line prevents double events
	        		//System.out.println(table2.getValueAt(table2.getSelectedRow(), 7).toString());
	        		  textPaneDetail.setText(table3.getValueAt(table3.getSelectedRow(), 8).toString());
	        	      textPane.setText("Manufacturer:     "+table3.getValueAt(table3.getSelectedRow(), 0).toString()+"\n"
	        		                  +"Focal Length:     "+table3.getValueAt(table3.getSelectedRow(), 1).toString()+"\n"
	        		                  +"Min Aperture:     "+table3.getValueAt(table3.getSelectedRow(), 2).toString()+"\n"
	        		                  +"Max Aperture:     "+table3.getValueAt(table3.getSelectedRow(), 3).toString()+" mp"+"\n"
	        		                  +"Lense Weight:   "+table3.getValueAt(table3.getSelectedRow(), 4).toString()+"\n"
	        		                  +"Price:                   "+"$"+table3.getValueAt(table3.getSelectedRow(), 5).toString()+"\n"
	        		                  +"Image Sensor size:"+table3.getValueAt(table3.getSelectedRow(), 6).toString()+"\n"
	        		                  +"Mount Type:       "+table3.getValueAt(table3.getSelectedRow(), 7).toString()+"\n"
	               		          );
	        	}
	            
	        }
	    });
	
	
	///////*open lenses tab*/////
	showLense.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//if(showLense.isSelected()== false){
			if(showLense.isSelected()){
				try{
					tabbedPane.insertTab("Camera Lenses", null, scrollPane2, null, 1);
					//scrollPane2.add(table2);
					tabbedPane.setSelectedIndex(1);
					table2.setModel(new DefaultTableModel());
//					String query ="SELECT * FROM CameraLenses whe0";
//					PreparedStatement pst3 = connect.prepareStatement(query);
//					ResultSet rs = pst3.executeQuery();
//					table2.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}else{
				tabbedPane.remove(scrollPane2);
			}
		}
	});
	

   }
}
