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
		jsr.startCaptureAudio();	// 오디오 캡쳐 시작

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

		try {
			jp = new JsonParser();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RequestGoogleTextToSpeech rtts = new RequestGoogleTextToSpeech();
		String message;
		message = jp.getParserString();

		RunningApplications ra = new RunningApplications();
		ra.webBrowser("http://search.naver.com/search.naver?query=", message);
		
		rtts.TTSPlayer(message);


		// Scanner scan = new Scanner(System.in);

		Komoran komoran = new Komoran("./models/models-full/");

		// message = scan.nextLine();

		List<List<Pair<String, String>>> result = komoran.analyze(message);
		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				System.out.println("1"+wordMorph + "\n");
			}
			System.out.println();
		}
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
