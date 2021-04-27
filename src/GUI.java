
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI {
		public GUI() {
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createEmptyBorder(400,400,400,400));
			panel.setLayout(new GridLayout());
			
			frame.add(panel, BorderLayout.CENTER);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setTitle("Minesweeper");
			frame.pack();
			frame.setVisible(true);
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new GUI();
		}
}
