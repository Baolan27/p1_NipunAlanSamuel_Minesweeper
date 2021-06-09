import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Stopwatch {
	 
	 JFrame frame = new JFrame();
	 JLabel timeLabel = new JLabel();
	 int elapsedTime = 0;
	 int seconds =0;
	 int minutes =0;
	 int hours =0;
	 boolean started = false;
	 String seconds_string = String.format("%02d", seconds);
	 String minutes_string = String.format("%02d", minutes);
	 String hours_string = String.format("%02d", hours);
	 
	 Timer timer = new Timer(1000, new ActionListener() {
	  
	  public void actionPerformed(ActionEvent e) {
	   
	   elapsedTime=elapsedTime+1000;
	   hours = (elapsedTime/3600000);
	   minutes = (elapsedTime/60000) % 60;
	   seconds = (elapsedTime/1000) % 60;
	   seconds_string = String.format("%02d", seconds);
	   minutes_string = String.format("%02d", minutes);
	   hours_string = String.format("%02d", hours);
	   timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	   if (seconds%5==0) {System.out.println("1");}
	  }
	  
	 });
	 
	 
	 public Stopwatch(){
	  
	  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	  timeLabel.setBounds(100,100,200,100);
	  timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
	  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
	  timeLabel.setOpaque(true);
	  timeLabel.setHorizontalAlignment(JTextField.CENTER);
	  
	  
	  frame.add(timeLabel);
	  
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(420,420);
	  	frame.setLayout(null);
	  frame.setVisible(true);
	  timer.start();
	 }
	 
	 void start() {
	  timer.start();
	 }
	 
	 void stop() {
	  timer.stop();
	 }
	 
	 void reset() {
	  timer.stop();
	  elapsedTime=0;
	  seconds =0;
	  minutes=0;
	  hours=0;
	  seconds_string = String.format("%02d", seconds);
	  minutes_string = String.format("%02d", minutes);
	  hours_string = String.format("%02d", hours);       timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	 }

	 

}