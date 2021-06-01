import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class GUI implements MouseListener, ActionListener {

	//global variables
	Board board;
	JFrame frame;

	public GUI() {
		//initializing board and label storage
		board = new Board();

		//JFrame setup
		frame = new JFrame("Minesweeper");
		JPanel panel = new JPanel();
		JPanel extraPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		frame.setPreferredSize(new Dimension(750, 800));
		frame.pack();
		GridLayout layout = new GridLayout(0, board.getL());
		layout.setHgap(3);
		layout.setVgap(3);
		frame.setLayout(layout);
		frame.getContentPane().setBackground(Color.gray);

		//loop to create all labels based on board and add them to frame
		for (int i = 0; i < board.getL(); i++) {
			for (int j = 0; j < board.getW(); j++) {
				frame.add(board.getBoard()[i][j], i);
			}
		}

		extraPanel.add(panel);
		frame.add(extraPanel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Minesweeper");
		frame.setVisible(true);

		//timer stuff
		Timer t = new Timer(16, this);
		t.start();
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