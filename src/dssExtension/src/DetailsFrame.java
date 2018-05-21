 package CameraGearProject.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class DetailsFrame extends JFrame{
	private JLabel lblDetaile;
	public JTextPane textPane;
	public JFrame frame;
	public JTextPane paneHeader;
	
	
	/**
	 * Launch the application.
	 */
	
	public void run(){
			try {
				DetailsFrame frame = new DetailsFrame();
				frame.setVisible(true);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	//});
	//FirstUI window = new FirstUI();
	
	/**
	 * Create the frame.
	 */
	public DetailsFrame() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 417);
		
		initC();
		createE();
	
	}

	
	public void initC(){
		

		lblDetaile = new JLabel("Camera Detail");
		lblDetaile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 textPane = new JTextPane();
		 paneHeader = new JTextPane();
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				CameraBodies.nextPage.dispose();
				CameraBodies.frame1.setVisible(true);
				CameraBodies.table.getSelectionModel().clearSelection();
				
			}  
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDetaile, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addComponent(paneHeader, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(59)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addGap(299))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDetaile, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(paneHeader, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnExit)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public void createE(){
	}
	protected void EXIT_ON_CLOSE() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
