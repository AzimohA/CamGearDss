package CameraGearProject.views;

import java.awt.EventQueue;

public class Main extends CameraBodies {
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	FirstUI window = new FirstUI();
					 frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
