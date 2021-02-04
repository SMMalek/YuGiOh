package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Screen {
	public JPanel common;
	String Phase;
	String Turn;
	JButton EndPhase;
	JButton EndTurn;
	JLabel JPhase;
	JLabel JTurn;

	public Screen() {

		EndPhase = new JButton("End Phase");
		EndTurn = new JButton("EndTurn");
		
		JPhase = new JLabel(Phase);
		JTurn = new JLabel(Turn);
		
		common = new JPanel();
		common.setLayout(new BorderLayout());
		common.setVisible(true);
		
		common.add(EndPhase , BorderLayout.NORTH);
		common.add(EndTurn , BorderLayout.SOUTH);
		common.add(JPhase , BorderLayout.EAST);
		common.add(JTurn , BorderLayout.WEST);
		
		

	}

	public void refScreen(){
		
	}
	public String getPhase() {
		return Phase;
	}

	public void setPhase(String phase) {
		Phase = phase;
	}

	public String getTurn() {
		return Turn;
	}

	public void setTurn(String turn) {
		JTurn.setText(turn);
	}

	public JButton getEndPhase() {
		return EndPhase;
	}

	public void setEndPhase(JButton endPhase) {
		EndPhase = endPhase;
	}

	public JButton getEndTurn() {
		return EndTurn;
	}

	public void setEndTurn(JButton endTurn) {
		EndTurn = endTurn;
	}

	public JLabel getJPhase() {
		return JPhase;
	}

	public void setJPhase(String jPhase) {
		JPhase.setText(jPhase);
	}

	public JLabel getJTurn() {
		return JTurn;
	}

	public void setJTurn(String jTurn) {
		JTurn.setText(jTurn);
	}

	public JPanel getCommon() {
		return common;
	}

	public void setCommon(JPanel common) {
		this.common = common;
	}

}
