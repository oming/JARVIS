package jarvis;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainUI {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public MainUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("../jarvis/res/img/logo.png"));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
	}

}
