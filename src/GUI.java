
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements MouseListener, ActionListener {

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

	}
}
