package jarvis;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

/**
 * A sample program is to demonstrate how to record sound in Java author:
 * www.codejava.net
 */
public class JavaSoundRecorder {
//	// record duration, in milliseconds
//	// static final long RECORD_TIME = 60000; // 1 minute
//	static final long RECORD_TIME = 5000; // 5 second
//
//	// path of the wav file
//	File wavFile = new File("./temp/RecordAudio.wav");
//
//	// format of audio file
//	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
//
//	// the line from which audio data is captured
//	TargetDataLine line;
//	
//	
//	/**
//	 * Defines an audio format
//	 */
//	AudioFormat getAudioFormat() {
//		float sampleRate = 16000;
//		int sampleSizeInBits = 16;
//		int channels = 1;
//		boolean signed = true;
//		boolean bigEndian = true;
//		AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
//		return format;
//	}
//
//	/**
//	 * Captures the sound and record into a WAV file
//	 */
//	void start() {
//		try {
//			AudioFormat format = getAudioFormat();
//			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
//
//			// checks if system supports the data line
//			if (!AudioSystem.isLineSupported(info)) {
//				System.out.println("Line not supported");
//				System.exit(0);
//			}
//			line = (TargetDataLine) AudioSystem.getLine(info);
//			line.open(format);
//			line.start(); // start capturing
//
//			System.out.println("Start capturing...");
//
//			AudioInputStream ais = new AudioInputStream(line);
//
//			System.out.println("Start recording...");
//
//			// start recording
//			AudioSystem.write(ais, fileType, wavFile);
//
//		} catch (LineUnavailableException ex) {
//			ex.printStackTrace();
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//	}
//
//	/**
//	 * Closes the target data line to finish capturing and recording
//	 */
//	void finish() {
//		line.stop();
//		line.close();
//		System.out.println("Finished");
//	}
//
//	/**
//	 * Entry to run the program
//	 */
////	 public static void main(String[] args) {
////	 final JavaSoundRecorder recorder = new JavaSoundRecorder();
////	
////	 // creates a new thread that waits for a specified
////	 // of time before stopping
////	 Thread stopper = new Thread(new Runnable() {
////	 public void run() {
////	 try {
////	 Thread.sleep(RECORD_TIME);
////	 } catch (InterruptedException ex) {
////	 ex.printStackTrace();
////	 }
////	 recorder.finish();
////	 }
////	 });
////	
////	 stopper.start();
////	
////	 // start recording
////	 recorder.start();
////	 }
//
//	public void setRecorder() {
//		final JavaSoundRecorder recorder = new JavaSoundRecorder();
//
//		// creates a new thread that waits for a specified
//		// of time before stopping
//		Thread stopper = new Thread(new Runnable() {
//			public void run() {
//				try {
//					Thread.sleep(RECORD_TIME);
//				} catch (InterruptedException ex) {
//					ex.printStackTrace();
//				}
//				recorder.finish();
//			}
//		});
//
//		stopper.start();
//
//		// start recording
//		recorder.start();
//	}
	
	AudioFormat audioFormat;
	TargetDataLine targetDataLine;
	
	// 오디오 캡쳐 시작
	public void startCaptureAudio() {
		captureAudio();
	}
	
	// 오디오 캡쳐 중지
	public void stopCaptureAudio() {
		targetDataLine.stop();
		targetDataLine.close();
	}
	
	
	// This method captures audio input from a
	// microphone and saves it in an audio file.
	private void captureAudio() {
		try {
			// Get things set up for capture
			audioFormat = getAudioFormat();
			DataLine.Info dataLineInfo = new DataLine.Info(
					TargetDataLine.class, audioFormat);
			targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);

			// Create a thread to capture the microphone
			// data into an audio file and start the
			// thread running. It will run until the
			// Stop button is clicked. This method
			// will return after starting the thread.
			new CaptureThread().start();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}// end catch
	}// end captureAudio method

	// This method creates and returns an
	// AudioFormat object for a given set of format
	// parameters. If these parameters don't work
	// well for you, try some of the other
	// allowable parameter values, which are shown
	// in comments following the declarations.
	private AudioFormat getAudioFormat() {
		float sampleRate = 16000.0F;
		// 8000,11025,16000,22050,44100
		int sampleSizeInBits = 16;
		// 8,16
		int channels = 1;
		// 1,2
		boolean signed = true;
		// true,false
		boolean bigEndian = true;
		// true,false
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
				bigEndian);
	}// end getAudioFormat
		// =============================================//

	// Inner class to capture data from microphone
	// and write it to an output audio file.
	class CaptureThread extends Thread {
		public void run() {
			AudioFileFormat.Type fileType = null;
			File audioFile = null;
			fileType = AudioFileFormat.Type.WAVE;
			audioFile = new File("./temp/RecordAudio.wav");

			try {
				targetDataLine.open(audioFormat);
				targetDataLine.start();
				AudioSystem.write(new AudioInputStream(targetDataLine),
						fileType, audioFile);
			} catch (Exception e) {
				e.printStackTrace();
			}// end catch

		}// end run
	}// end inner class CaptureThread
		// =============================================//

}

