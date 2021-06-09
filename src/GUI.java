import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GUI extends JLabel implements MouseListener, ActionListener {

	//global variables
	Board board;
	JFrame frame;
	Music bgm;
	GridLayout layout;

	//timer
	Timer timer = new Timer(16, this);

	//time label stuff
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	 
	 
	public GUI() {
		//Stopwatch stopwatch = new Stopwatch();
		
		//initializing board and label storage  
		board = new Board();
		
		//music
		bgm = new Music("backgroundmusic.wav",true);
		bgm.play();

		//JFrame setup
		frame = new JFrame("Minesweeper");
		frame.setPreferredSize(new Dimension(750, 900));
		
		// timer
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100,100,200,100);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		// start timer
		timer.start();

		frame.pack();	
		layout = new GridLayout(0, board.getL());
		layout.setHgap(3);
		layout.setVgap(3);
		frame.setLayout(layout);
		frame.getContentPane().setBackground(Color.gray);
		frame.add(this);

		//loop to create all labels based on board and add them to frame
		for (int i = 0; i < board.getL(); i++) {
			for (int j = 0; j < board.getW(); j++) {
				frame.add(board.getBoard()[i][j], i);
			}
		}

		frame.add(timeLabel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minesweeper");
		frame.setVisible(true);
	}

	 Timer timer1 = new Timer(1000, new ActionListener() {
		  
		  public void actionPerformed(ActionEvent e) {
		   
		   elapsedTime=elapsedTime+1000;
		   hours = (elapsedTime/3600000);
		   minutes = (elapsedTime/60000) % 60;
		   seconds = (elapsedTime/1000) % 60;
		   seconds_string = String.format("%02d", seconds);
		   minutes_string = String.format("%02d", minutes);
		   hours_string = String.format("%02d", hours);
		   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		   
		  }
		  
		 });

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GUI();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	 
	 void start() {
	  timer.start();
	 }
	 
	 void stop() {
	  timer.stop();
	 }
	 
	 void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	 }
	
	
	public void paint(Graphics g) {
		if (board.lost()) {
			//frame = new JFrame();
			frame.getContentPane().removeAll();
			
			frame.getContentPane().setBackground(Color.black);
			g.drawRect(0, 0, 750, 900);
			g.setFont(Font.getFont(Font.SANS_SERIF));
			g.setColor(Color.gray);
			g.drawString("You Lost!", 50, 50);
			//frame.revalidate();
		}
	}

}