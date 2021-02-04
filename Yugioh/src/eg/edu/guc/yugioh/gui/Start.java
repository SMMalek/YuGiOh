package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import eg.edu.guc.yugioh.gui.MainFrame;
import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class Start extends JFrame implements ActionListener {
	
	String P1;
	String P2;
	JTextArea oneText;
	JTextArea twoText;
	JButton startgame;
	JLabel BG;
	ImageIcon x = new ImageIcon("YGO-004_Shadow_Game.png");

	
	Start() {

		setTitle("Game ON");
		setVisible(true);
		setResizable(false);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Courier New", Font.BOLD, 16);
		oneText = new JTextArea("PLayerI");
		oneText.setVisible(true);
		oneText.setForeground(Color.DARK_GRAY);
		oneText.setBackground(Color.LIGHT_GRAY);
		oneText.setLineWrap(true);
		oneText.setWrapStyleWord(true);
		oneText.setFont(font);
		oneText.setBounds(50, 250, 80, 20);
		twoText = new JTextArea("PLayerII");
		twoText.setVisible(true);
		twoText.setForeground(Color.YELLOW);
		twoText.setBackground(Color.LIGHT_GRAY);
		twoText.setLineWrap(true);
		twoText.setWrapStyleWord(true);
		twoText.setFont(font);
		twoText.setBounds(300, 250, 80, 20);

		add(oneText);
		add(twoText);

		startgame = new JButton("Start Game");
		startgame.setVisible(true);
		startgame.setBackground(Color.BLACK);
		startgame.setForeground(Color.LIGHT_GRAY);
		add(startgame, BorderLayout.SOUTH);
		startgame.addActionListener(this);

		BG = new JLabel(x);	
		BG.setVisible(true);
		BG.setSize(436, 374);
		JPanel names = new JPanel();
		names.setVisible(true);
		names.setLayout(new BorderLayout());
		add(names);
		names.add(BG, BorderLayout.CENTER);

		pack();
		setBounds(550, 200, 436, 429);


	}

	public static void main(String[] args) throws IOException {
		// JLabel xx = new JLabel(o);
		new Start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startgame)) {
			P1 = oneText.getText();
			P2 = twoText.getText();
			try {
				MainFrame.GamePush(P1,P2);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public String getP1() {
		return P1;
	}

	public void setP1(String p1) {
		P1 = p1;
	}

	public String getP2() {
		return P2;
	}

	public void setP2(String p2) {
		P2 = p2;
	}

	public JTextArea getOne() {
		return oneText;
	}

	public void setOne(JTextArea oneText) {
		this.oneText = oneText;
	}

	public JTextArea getTwo() {
		return twoText;
	}

	public void setTwo(JTextArea twoText) {
		this.twoText = twoText;
	}

	public JButton getStartgame() {
		return startgame;
	}

	public void setStartgame(JButton startgame) {
		this.startgame = startgame;
	}

	public JLabel getBG() {
		return BG;
	}

	public void setBG(JLabel bG) {
		BG = bG;
	}

	public void setX(ImageIcon x) {
		this.x = x;
	}
}
