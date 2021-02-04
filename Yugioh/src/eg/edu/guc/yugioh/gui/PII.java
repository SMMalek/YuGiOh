package eg.edu.guc.yugioh.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.MenuItem;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class PII extends JFrame {

	Player play;

	ImageIcon MonsBG = new ImageIcon("Spell-Shadow-Acceptablecopy.jpg");
	ImageIcon SpellBG = new ImageIcon("Spell-Shadow-AcceptablecopyS.jpg");
	JButton x0 = new JButton(SpellBG);
	JButton x1 = new JButton(SpellBG);
	JButton x2 = new JButton(SpellBG);
	JButton x3 = new JButton(SpellBG);
	JButton x4 = new JButton(SpellBG);
	JButton x5 = new JButton();
	JButton x6 = new JButton();
	JButton x7 = new JButton();
	JButton x8 = new JButton();
	JButton x9 = new JButton();
	JButton y0 = new JButton(MonsBG);
	JButton y1 = new JButton(MonsBG);
	JButton y2 = new JButton(MonsBG);
	JButton y3 = new JButton(MonsBG);
	JButton y4 = new JButton(MonsBG);
	JButton y5 = new JButton();

	JPopupMenu HActs;
	JPopupMenu MActs;
	JPopupMenu SActs;
	JMenuItem SetSpell;
	JMenuItem ActSpell;
	JMenuItem SwitchMons;
	JMenuItem Attack;
	JMenuItem SAttack;
	JMenuItem Descr;
	JMenuItem Sum;
	JMenuItem SumS;

	ArrayList<String> HandDescriptions;
	int Decks = 30;
	JLabel DeckS;
	private JPanel PlayerMainPanel;
	private JPanel Centre;
	private JPanel Yemeen;
	private JPanel Shmal;
	private JPanel Foo2;
	private JPanel ta7t;
	private String LifePoint = "N/A";
	// private String Name = "N/A";
	private ArrayList<JButton> hand;

	private ArrayList<JButton> mons;
	private ArrayList<JButton> spells;

	private Font font = new Font("Courier New", Font.BOLD, 16);
	private JLabel LP;
	private JLabel Namee;
	private JButton GraveYard;
	private JButton Ending;
	JButton Deck;
	private String DeckSize = "N/A";
	private JPanel aha;
	protected JMenuItem JMenuItem;

	public PII(Player Cont) {
		play = Cont;

		PlayerMainPanel = new JPanel();
		PlayerMainPanel.setLayout(new BorderLayout());
		PlayerMainPanel.setVisible(true);

		aha = new JPanel();
		aha.setLayout(new GridLayout(3, 1));
		aha.setVisible(true);

		Centre = new JPanel();
		Centre.setVisible(true);
		Centre.setLayout(new GridLayout(1, 5));
		// SPELLS
		Centre.add(x0);
		Centre.add(x1);
		Centre.add(x2);
		Centre.add(x3);
		Centre.add(x4);
		Foo2 = new JPanel();
		Foo2.setVisible(true);
		Foo2.setLayout(new GridLayout(1, 5));
		// MONS
		Foo2.add(y0);
		Foo2.add(y1);
		Foo2.add(y2);
		Foo2.add(y3);
		Foo2.add(y4);

		ta7t = new JPanel();
		ta7t.setVisible(true);
		ta7t.setLayout(new GridLayout());

		DeckS = new JLabel("30");
		ImageIcon x = new ImageIcon("Copy of flower-of-life-Invblue - Copy.jpg");
		Deck = new JButton(x);
		// Deck.setIcon(x);
		// Deck.setBounds(new Rectangle(1000, 1000));
		// Deck.setSize(1000, 100);
		Deck.add(DeckS);

		GraveYard = new JButton("GraveYard");

		JPanel GandD = new JPanel();
		GandD.setVisible(true);
		GandD.setLayout(new GridLayout(2, 1));
		GandD.add(GraveYard);
		GandD.add(Deck);

		Yemeen = new JPanel();
		Yemeen.setVisible(true);
		Yemeen.setLayout(new BorderLayout());

		LP = new JLabel("8000");
		LP.setHorizontalAlignment(JLabel.CENTER);
		LP.setVisible(true);
		LP.setFont(font);
		Namee = new JLabel("N/A");
		Namee.setHorizontalAlignment(JLabel.CENTER);
		LP.setVisible(true);

		Yemeen.add(GandD, BorderLayout.CENTER);
		Yemeen.add(LP, (BorderLayout.NORTH));
		Yemeen.add(Namee, BorderLayout.SOUTH);

		aha.add(Foo2);
		aha.add(Centre);
		aha.add(ta7t);
		PlayerMainPanel.add(Yemeen, BorderLayout.EAST);
		PlayerMainPanel.add(aha, BorderLayout.CENTER);
		add(PlayerMainPanel);

		SetSpell = new JMenuItem("Set Spell");
		SetSpell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame xs = new JFrame();
				xs.setSize(500, 500);
				xs.setVisible(true);

			}
		});

		ActionListener Summm = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				for (int i = play.getField().getHand().size() - 1; i >= 0; i--) {
					if (play.getField().getHand().get(i).getName()
							.equals(Sum.getActionCommand())) {
						if (play.getField().getHand().get(i) instanceof MonsterCard)
							play.summonMonster((MonsterCard) play.getField()
									.getHand().get(i));
					}
				}
			}
		};

		ActionListener menuListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ref();
			}
		};
		Attack = new JMenuItem("test");
		Descr = new JMenuItem("Info");
		Sum = new JMenuItem("Su");
		HActs = new JPopupMenu("Hand Act");
		HActs.add(new JMenuItem("s1"));
		HActs.add(SetSpell);
		HActs.add(new JMenuItem("s12"));
		HActs.add(Attack);
		HActs.add(Sum);
		Attack.addActionListener(menuListener);
		Sum.addActionListener(Summm);

	}

	public void CardtoHand() {
		String ButtonName;
		ArrayList<Card> addthismons = new ArrayList<Card>();
		addthismons = play.getField().getHand();
		int dt = 0;
		for (int i = 0; i != addthismons.size(); i++) {
			String n = addthismons.get(i).getName();
			ButtonName = addthismons.get(i).getName();
			JButton addedmonsButton = new JButton(ButtonName);
			ImageIcon addedmonsimage = new ImageIcon(n + ".png");
			addedmonsimage.setImage(addedmonsimage.getImage()
					.getScaledInstance(170, 130, 20));
			addedmonsButton.setIcon(addedmonsimage);
			addedmonsimage.setDescription(addthismons.get(i).getDescription());

			ta7t.add(addedmonsButton);
			addedmonsButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					HActs.show(addedmonsButton, 15, 30);

				}
			});
			dt++;

		}

		DeckS.setText(String.valueOf(Decks - dt));
	}

	// UNDONE
	public void ref() {
		refH();
		refM();
		refS();

	}

	private void refS() {
		// TODO Auto-generated method stub

	}

	private void refM() {
		Foo2.removeAll();
		ArrayList<MonsterCard> x = new ArrayList<MonsterCard>();
		x = play.getField().getMonstersArea();
		for (int i = 0; i != x.size(); i++) {
			JButton t = new JButton();
			String n = x.get(i).getName();
			ImageIcon im = new ImageIcon(n + ".png");
			t.setIcon(im);
			im.setDescription(x.get(i).getDescription());

			Foo2.add(t);
			/*
			 * t.addActionListener(new ActionListener() {
			 * 
			 * @Override public void actionPerformed(ActionEvent e) {
			 * 
			 * HActs.show(t, 15, 30);
			 * 
			 * } });
			 */
		}
		Foo2.revalidate();

	}

	private void refH() {

		ta7t.removeAll();
		CardtoHand();
		ta7t.revalidate();

	}

	// GETTERS & SETTER START
	public Player getPlay() {
		return play;
	}

	public void setPlay(Player play) {
		this.play = play;
	}

	public JPanel getPlayerMainPanel() {
		return PlayerMainPanel;
	}

	public void setPlayerMainPanel(JPanel playerMainPanel) {
		PlayerMainPanel = playerMainPanel;
	}

	public JPanel getCentre() {
		return Centre;
	}

	public void setCentre(JPanel centre) {
		Centre = centre;
	}

	public JPanel getYemeen() {
		return Yemeen;
	}

	public void setYemeen(JPanel yemeen) {
		Yemeen = yemeen;
	}

	public JPanel getShmal() {
		return Shmal;
	}

	public void setShmal(JPanel shmal) {
		Shmal = shmal;
	}

	public JPanel getFoo2() {
		return Foo2;
	}

	public void setFoo2(JPanel foo2) {
		Foo2 = foo2;
	}

	public JPanel getTa7t() {
		return ta7t;
	}

	public void setTa7t(JPanel ta7t) {
		this.ta7t = ta7t;
	}

	public String getLifePoint() {
		return LifePoint;
	}

	public void setLifePoint(String lifePoint) {
		LifePoint = lifePoint;
	}

	public ArrayList<JButton> getHand() {
		return hand;
	}

	public void setHand(ArrayList<JButton> hand) {
		this.hand = hand;
	}

	public ArrayList<JButton> getMons() {
		return mons;
	}

	public void setMons(ArrayList<JButton> mons) {
		this.mons = mons;
	}

	public ArrayList<JButton> getSpells() {
		return spells;
	}

	public void setSpells(ArrayList<JButton> spells) {
		this.spells = spells;
	}

	public JButton getGraveYard() {
		return GraveYard;
	}

	public void setGraveYard(JButton graveYard) {
		GraveYard = graveYard;
	}

	public JButton getEnding() {
		return Ending;
	}

	public void setEnding(JButton ending) {
		Ending = ending;
	}

	public JButton getDeck() {
		return Deck;
	}

	public void setDeck(JButton deck) {
		Deck = deck;
	}

	public String getDeckSize() {
		return DeckSize;
	}

	public void setDeckSize(String deckSize) {
		DeckSize = deckSize;
	}

	public JPanel getAha() {
		return aha;
	}

	public void setAha(JPanel aha) {
		this.aha = aha;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public JLabel getLP() {
		return LP;
	}

	public void setLP(JLabel lP) {
		LP = lP;
	}

	public String getNamee() {
		return Namee.getText();
	}

	public void setNamee(String namee) {
		Namee.setText(namee);
	}

	// GETTERS & SETTETS END
	public static void main(String[] args) throws IOException,
			UnexpectedFormatException {

		JFrame x = new JFrame();
		x.setVisible(true);
		Player xx = new Player("som3a");
		x.add(new PII(xx));
		x.pack();
		x.setSize(1000, 600);

	}

}
