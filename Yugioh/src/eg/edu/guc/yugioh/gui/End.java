package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class End {
	public End() {
		JFrame last = new JFrame("YUGIOH");
		last.setSize(1200, 700);
		last.setVisible(true);
		last.setLayout(new BorderLayout());

		JLabel winner = new JLabel("winner");
		winner.setVisible(true);
		last.add(winner, BorderLayout.NORTH);

		JButton playAgain = new JButton("playAgain");
		playAgain.setVisible(true);
		last.add(playAgain, BorderLayout.SOUTH);

	}
}
