import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.BooleanControl;

public class Music implements Runnable {
	
	private Thread t;
	private File audioFile ;
	private AudioInputStream audioStream;
	private Clip audioClip;
	private final String fn;
	private boolean loops = false;
	private BooleanControl muteControl;
	
	/**
	 * Create a music object from a given file name. 
	 * The music file should be stored outside of the src folder but in the same project.
	 * 
	 * @param fileName name of file such as "backgroundmusic.wav"
	 * @param loops Set to true if you want the sound to loop continuously
	 */
	public Music(String fileName, boolean loops) {
		fn = fileName;
		audioFile = new File(fileName);
		this.loops = loops;
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, format);
	        audioClip = (Clip) AudioSystem.getLine(info);
	        audioClip.open(audioStream);
	        //for muting
			muteControl = (BooleanControl) audioClip.getControl(BooleanControl.Type.MUTE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Stop the music
	 */
	public void stop() {
		audioClip.stop();
		audioClip.flush();
	}

	public void mute() {
		muteControl.setValue(true);
		audioClip.loop(0);
		audioClip.flush();
	}

	/*
	 * Start the music. If the object was created with loops set to true then
	 * it will loop otherwise it will be played once. 
	 */
	public void play() {		
		if(!loops) {
			audioClip.start();
		} else {
			start3();
		}
	}

	int count = 0;
	private void start3() {
	     t = new Thread (this, "run");
	     if(!audioClip.isActive() && loops || count == 0) {
	    	 count++;
	    	 start2();
	     }
	     t.start();
	}

	private void start() {
	     t = new Thread(this, "run");
	     t.start();
	}

	private void start2() {
		audioFile = new File(fn);
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
	        DataLine.Info info = new DataLine.Info(Clip.class, format);
	        audioClip = (Clip) AudioSystem.getLine(info);
	        audioClip.open(audioStream);
	        audioClip.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// audioClip.start();
		play();
	}

}