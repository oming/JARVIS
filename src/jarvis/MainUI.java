package jarvis;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

import org.json.simple.parser.ParseException;

public class MainUI implements MouseListener {
	private static JsonParser jp;
	private static JavaSoundRecorder jsr;
	private static MorphemeAnalysis ma;
	JFrame frame;
	JButton btnNewButton;

	/**
	 * Create the application.
	 */

	public MainUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		btnNewButton = new JButton(new ImageIcon("./res/img/stoplogo.png"));
		panel.add(btnNewButton);

		btnNewButton.addMouseListener(this);
		frame.setVisible(true);
		jsr = new JavaSoundRecorder(); // 음성 녹음 실행
		ma = new MorphemeAnalysis();

		// MobiJARVIS 접속 가능하도록 함.
		TCPServer tcps = new TCPServer(ma);
		tcps.run();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseClicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mousePressed");
		btnNewButton.setIcon(new ImageIcon("./res/img/startlogo.png"));
		jsr.startCaptureAudio(); // 오디오 캡쳐 시작

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseReleased");
		btnNewButton.setIcon(new ImageIcon("./res/img/stoplogo.png"));
		jsr.stopCaptureAudio();
		try {
			RequestGoogleSpeechAPI rj = new RequestGoogleSpeechAPI();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		jp = new JsonParser();

		RequestGoogleTextToSpeech rtts = new RequestGoogleTextToSpeech();
		String message;
		message = jp.getParserString();
		System.out.println(message);
		// 메시지가 비었다면 아무것도 실행하지 않는다.
		if (message.equals(null))
			message = "명령을 내려주세요.";

		ma.analysis(ma.getParsing(message));

		// rtts.TTSPlayer(message + "합니다.");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mouseExited");
	}

}
