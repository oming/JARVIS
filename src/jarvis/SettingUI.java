package jarvis;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SettingUI {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public SettingUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel centerPanel = new JPanel();
		frame.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));

		JLabel jarvisInfomation = new JLabel(
				"<html><center><b>JARVIS</b><br><br>버전 1.0.0</center></html>");
		jarvisInfomation.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(jarvisInfomation);

		JPanel footerPanel = new JPanel();
		frame.add(footerPanel, BorderLayout.SOUTH);

		JLabel copyrightInfomaition = new JLabel(
				"<html><center>copyright &copy 2015 Hyosang-An.<br/>모든 권리 보유.</center></html>");
		footerPanel.add(copyrightInfomaition);
	}
}
