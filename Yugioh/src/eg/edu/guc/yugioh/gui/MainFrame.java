package eg.edu.guc.yugioh.gui;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.listeners.*;
import eg.edu.guc.yugioh.listeners.Action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.lang.Thread.State;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

//import org.omg.CORBA.Bounds;

public class MainFrame extends JFrame {
	static Board gameBoardoard;
	static Player POne;
	static Player PTwo;
	static JFrame Main;
	JLabel BG;

	static String O = "N/A";
	// Player One
	static JPanel Stat;
	static JLabel PlayerName;
	String PlayerNameVal;
	JLabel LifePoints;
	int LifePointVal = 8000;

	JPanel SpellArea;
	ImageIcon EmptySpell = new ImageIcon("Spell-Shadow-Acceptablecopy.jpg");

	JPanel MonstersArea;
	ImageIcon EmptyMonster = new ImageIcon("Spell-Shadow-AcceptablecopyS.jpg");

	static JPanel Hand;
	static int CopyHandCounter;
	ArrayList<Card> HandItems;
	JButton Deck;
	static int DeckSize = 20;
	static JLabel DeckString = new JLabel("20");

	ImageIcon GraveYardBG = new ImageIcon(
			"Copy of flower-of-life-Invblue - Copy.jpg");
	JButton GraveYard;
	JLabel GraveYardSize;
	ArrayList<Card> GraveYardCards = new ArrayList<Card>();

	static JPopupMenu HAct;
	JPopupMenu MAct;
	JPopupMenu SAct;

	JMenuItem summonM;
	JMenuItem setM;
	JMenuItem setS;
	JMenuItem actS;
	JMenuItem declareA;
	JMenuItem switchMM;
	JMenuItem descHM;
	JMenuItem descHS;
	JMenuItem descM;
	JMenuItem descS;

	static JPopupMenu oHmAct;
	static JPopupMenu oHsAct;
	JPopupMenu oMAct;
	JPopupMenu oSAct;

	JMenuItem osummonM;
	JMenuItem osetM;
	JMenuItem osetS;
	JMenuItem oactS;
	JMenuItem odeclareA;
	JMenuItem oswitchMM;
	JMenuItem odescHM;
	JMenuItem odescHS;
	JMenuItem odescM;
	JMenuItem odescS;

	// Player two
	static JPanel oStat;
	static JLabel oPlayerName;
	String oPlayerNameVal;
	JLabel oLifePoints;
	int oLifePointVal = 8000;

	JPanel oSpellArea;
	ImageIcon oEmptySpell = new ImageIcon("Spell-Shadow-Acceptablecopy.jpg");

	JPanel oMonstersArea;
	ImageIcon oEmptyMonster = new ImageIcon("Spell-Shadow-AcceptablecopyS.jpg");

	static JPanel oHand;
	ArrayList<Card> oHandItems;

	JButton oDeck = new JButton();
	static int oDeckSize = 20;
	static JLabel oDeckString = new JLabel("" + oDeckSize);

	ArrayList<Card> oDeckCards = new ArrayList<Card>();

	ImageIcon oGraveYardBG = new ImageIcon(
			"Copy of flower-of-life-Invblue - Copy.jpg");
	JButton oGraveYard;
	JLabel oGraveYardSize;
	ArrayList<Card> oGraveYardCards = new ArrayList<Card>();
	//
	// JPopupMenu oHmAct;
	// JPopupMenu oHsAct;
	// JPopupMenu oMAct;
	// JPopupMenu oSAct;
	//
	// JMenuItem osummonM;
	// JMenuItem osetM;
	// JMenuItem osetS;
	// JMenuItem oactS;
	// JMenuItem odeclareA;
	// JMenuItem oswitchMM;
	// JMenuItem odesc;

	// Screen
	static JPanel Screen;
	JLabel Phase;
	String PhaseVal;
	static JLabel playing;
	String playingVal;

	JButton EndPhase;
	JButton EndTurn;

	public MainFrame(String PlayerOneName, String PlayerTwoName)
			throws Exception {
		// Main = new MainFrame(PlayerOneName, PlayerTwoName);
		// Screen

		Screen = new JPanel();
		Screen.setLayout(new BorderLayout());

		Phase = new JLabel("Main Phase I");
		EndPhase = new JButton("END PHASE");
		EndPhase.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				gameBoardoard.getActivePlayer().endPhase();
				PhaseVal = gameBoardoard.getActivePlayer().getField()
						.getPhase().name();

				refScreen();
				refHand();
			}
		});

		EndTurn = new JButton("END TURN");

		EndTurn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				gameBoardoard.getActivePlayer().endTurn();
				PhaseVal = gameBoardoard.getActivePlayer().getField()
						.getPhase().name();
				playingVal = gameBoardoard.getActivePlayer().getName();
				refScreen();
				refHand();

			}
		});

		ActionListener desc = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource().equals(HAct)) {
					for (int i = 0; i != gameBoardoard.getActivePlayer()
							.getField().getHand().size(); i++) {

					}
				}
			}
		};

		ActionListener osumL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {
					System.out.println("looooop");
					System.out.println(gameBoardoard.getActivePlayer()
							.getField().getHand().get(i).getName());
					System.out.println(O + "--");

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof MonsterCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().summonMonster(
									(MonsterCard) gameBoardoard
											.getActivePlayer().getField()
											.getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				refresh();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener sumL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MonsterCard a;
				Card aa;

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {
					System.out.println("looooop");
					System.out.println(gameBoardoard.getActivePlayer()
							.getField().getHand().get(i).getName());
					System.out.println(O + "--");

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof MonsterCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().summonMonster(
									(MonsterCard) gameBoardoard
											.getActivePlayer().getField()
											.getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				reMonsterArea();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener setm = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MonsterCard a;
				Card aa;

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof MonsterCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().setMonster(
									(MonsterCard) gameBoardoard
											.getActivePlayer().getField()
											.getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				reMonsterArea();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener osetm = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MonsterCard a;
				Card aa;

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof MonsterCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().setMonster(
									(MonsterCard) gameBoardoard
											.getActivePlayer().getField()
											.getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				reMonsterArea();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener sets = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MonsterCard a;
				Card aa;

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof SpellCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().setSpell(
									(SpellCard) gameBoardoard.getActivePlayer()
											.getField().getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				reSpellArea();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener osets = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				MonsterCard a;
				Card aa;

				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getHand().size(); i++) {

					if (gameBoardoard.getActivePlayer().getField().getHand()
							.get(i).getName().equals(O)) {
						System.out.println("1------------------");
						if (gameBoardoard.getActivePlayer().getField()
								.getHand().get(i) instanceof SpellCard) {
							System.out.println("----------------------------");
							gameBoardoard.getActivePlayer().setSpell(
									(SpellCard) gameBoardoard.getActivePlayer()
											.getField().getHand().get(i));
						} else {
							System.out.println("OUT");
						}
						break;
					}

				}
				reSpellArea();
				System.out.println(gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size());
			}
		};

		ActionListener decA = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
						.getMonstersArea().size(); i++) {
					gameBoardoard.getActivePlayer().declareAttack(
							gameBoardoard.getActivePlayer().getField()
									.getMonstersArea().get(i));
				}
				refresh();
			}
		};
		// omartEtA@hotmail.com

		// MENUS

		HAct = new JPopupMenu();

		summonM = new JMenuItem("Summon this");
		setM = new JMenuItem("Set this mons");
		descHM = new JMenuItem("show info");
		setS = new JMenuItem("Set this spell");
		descHS = new JMenuItem("show info");

		HAct.add(descHM);
		HAct.add(setM);
		HAct.add(summonM);
		HAct.add(setS);
		HAct.add(descHS);

		summonM.addActionListener(sumL);
		setM.addActionListener(setm);
		setS.addActionListener(sets);
		SAct = new JPopupMenu();
		actS = new JMenuItem("Activate this");
		descS = new JMenuItem("show info");

		SAct.add(actS);
		SAct.add(descS);

		MAct = new JPopupMenu();
		declareA = new JMenuItem("Attack");
		switchMM = new JMenuItem("Switch Mode");
		descM = new JMenuItem("show info");
		declareA.addActionListener(decA);

		MAct.add(declareA);
		MAct.add(switchMM);
		MAct.add(descM);

		oMAct = new JPopupMenu();
		odeclareA = new JMenuItem("Attack");
		oswitchMM = new JMenuItem("Switch Mode");
		odescM = new JMenuItem("show info");
		odeclareA.addActionListener(decA);

		oMAct.add(odeclareA);
		oMAct.add(oswitchMM);
		oMAct.add(odescM);

		osummonM = new JMenuItem("Summon this");
		osetM = new JMenuItem("Set this mons");
		odescHM = new JMenuItem("show info");

		osummonM.addActionListener(osumL);
		osetM.addActionListener(osetm);

		oHsAct = new JPopupMenu();

		osetS = new JMenuItem("Set this spell");
		odescHS = new JMenuItem("show info");

		oHsAct.add(osetS);
		oHsAct.add(odescHS);

		oSAct = new JPopupMenu();
		oactS = new JMenuItem("Activate this");
		odescS = new JMenuItem("show info");

		oSAct.add(oactS);
		oSAct.add(odescS);

		oMAct = new JPopupMenu();
		odeclareA = new JMenuItem("Attack");
		oswitchMM = new JMenuItem("Switch Mode");
		odescM = new JMenuItem("show info");

		oMAct.add(odeclareA);
		oMAct.add(oswitchMM);
		oMAct.add(odescM);

		// MAct.add(desc);

		/*
		 * oHmAct = new JPopupMenu(); oHsAct = new JPopupMenu();
		 * 
		 * osummonM = new JMenuItem("Summon this"); osetM = new
		 * JMenuItem("Set this mons"); osetS = new JMenuItem("Set this spell");
		 * odesc = new JMenuItem("show info");
		 * 
		 * oHmAct.add(osummonM); oHmAct.add(osetM); oHmAct.add(odesc);
		 * 
		 * oHsAct.add(osetS); oHsAct.add(odesc);
		 * 
		 * oSAct = new JPopupMenu(); oactS = new JMenuItem("Activate this");
		 * 
		 * oSAct.add(oactS); oSAct.add(odesc);
		 * 
		 * oMAct = new JPopupMenu(); odeclareA = new JMenuItem("Attack");
		 * oswitchMM = new JMenuItem("Switch Mode");
		 * 
		 * oMAct.add(odeclareA); oMAct.add(odesc);
		 */
		// Players
		POne = new Player(PlayerOneName);
		PTwo = new Player(PlayerTwoName);

		PlayerName = new JLabel(PlayerOneName);
		oPlayerName = new JLabel(PlayerTwoName);

		LifePoints = new JLabel("8000");
		oLifePoints = new JLabel("8000");

		// monsareas
		MonstersArea = new JPanel(new GridLayout(1, 5));
		for (int i = 5; i != 0; i--) {
			MonstersArea.add(new JButton(EmptyMonster));
		}
		oMonstersArea = new JPanel(new GridLayout(1, 5));
		for (int i = 5; i != 0; i--) {
			oMonstersArea.add(new JButton(oEmptyMonster));
		}

		// spellarea
		SpellArea = new JPanel(new GridLayout(1, 5));
		for (int i = 5; i != 0; i--) {
			SpellArea.add(new JButton(EmptySpell));
		}

		oSpellArea = new JPanel(new GridLayout(1, 5));
		for (int i = 5; i != 0; i--) {
			oSpellArea.add(new JButton(oEmptySpell));
		}

		// HandS
		Hand = new JPanel(new GridLayout(5, 4, 20, 10));
		oHand = new JPanel(new GridLayout(5, 4, 20, 10));

		// GRAVES

		GraveYard = new JButton(String.valueOf(GraveYardCards));
		oGraveYard = new JButton(String.valueOf(oGraveYardCards));
		GraveYard.setIcon(GraveYardBG);
		oGraveYard.setIcon(oGraveYardBG);

		// Deck
		Deck = new JButton(new ImageIcon("flower-of-life-blue.jpg"));
		Deck.add(DeckString);

		oDeck = new JButton(new ImageIcon("flower-of-life-blue.jpg"));
		oDeck.add(oDeckString);

		// Players stats (name and Life point
		Stat = new JPanel(new GridLayout(2, 1));
		Stat.add(LifePoints);
		oStat = new JPanel(new GridLayout(2, 1));
		oStat.add(oLifePoints);
		oLifePoints.setAlignmentX(CENTER_ALIGNMENT);

		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon(
				"Spell-Shadow-AcceptablecopySS.jpg"));
		add(background);
		background.setLayout(new FlowLayout());

		setTitle("yu");
		// setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(Stat);
		add(SpellArea);
		add(MonstersArea);
		add(Deck);
		add(GraveYard);
		add(PlayerName);
		// add(LifePoints);

		Screen.add(Phase, BorderLayout.WEST);
		Screen.add(EndPhase, BorderLayout.NORTH);
		Screen.add(EndTurn, BorderLayout.SOUTH);

		add(Screen);
		add(oStat);
		add(oSpellArea);
		add(oMonstersArea);
		add(oDeck);
		add(oGraveYard);
		add(oPlayerName);
		// add(oLifePoints);

		Stat.setBounds(1300, 500, 200, 50);
		MonstersArea.setBounds(500, 500, 800, 200);
		SpellArea.setBounds(500, 700, 800, 200);
		Hand.setBounds(0, 500, 500, 400);
		GraveYard.setBounds(1300, 550, 200, 175);
		Deck.setBounds(1300, 725, 200, 175);

		Screen.setBounds(0, 400, 1500, 100);

		oStat.setBounds(1300, 0, 200, 50);
		oMonstersArea.setBounds(500, 200, 800, 200);
		oSpellArea.setBounds(500, 0, 800, 200);
		oHand.setBounds(0, 0, 500, 400);
		oGraveYard.setBounds(1300, 50, 200, 175);
		oDeck.setBounds(1300, 225, 200, 175);

		pack();
		setSize(1550, 900);
	}

	public static void GamePush(String I, String II) throws Exception {

		Main = new MainFrame(I, II);
		gameBoardoard = new Board();

		gameBoardoard.startGame(POne, PTwo);
		CopyHand();

		PlayerName.setText(POne.getName());
		oPlayerName.setText(PTwo.getName());

		playing = new JLabel(gameBoardoard.getActivePlayer().getName());
		Screen.add(playing, BorderLayout.EAST);
		Stat.add(PlayerName);
		oStat.add(oPlayerName);
		Main.add(Hand);
		Main.add(oHand);
		System.out.println(PlayerName.getText());
		System.out.println(oPlayerName.getText());
	}

	public void refresh() {

		refScreen();
		refHand();
		reSpellArea();
		reMonsterArea();

	}

	private void reSpellArea() {
		if (gameBoardoard.getActivePlayer().equals(POne)) {
			SpellArea.removeAll();

			ArrayList<SpellCard> addthisspell = new ArrayList<SpellCard>();
			addthisspell = gameBoardoard.getActivePlayer().getField()
					.getSpellArea();

			for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
					.getSpellArea().size(); i++) {

				String ButtonName;
				String n = addthisspell.get(i).getName();
				ButtonName = addthisspell.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthisspell.get(i)
						.getDescription());

				SpellArea.add(addedmonsButton);

			}
			SpellArea.revalidate();

			oSpellArea.removeAll();

			addthisspell = new ArrayList<SpellCard>();
			addthisspell = gameBoardoard.getOpponentPlayer().getField()
					.getSpellArea();

			for (int i = 0; i != gameBoardoard.getOpponentPlayer().getField()
					.getSpellArea().size(); i++) {

				String ButtonName;
				String n = addthisspell.get(i).getName();
				ButtonName = addthisspell.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthisspell.get(i)
						.getDescription());

				oSpellArea.add(addedmonsButton);

			}
			oSpellArea.revalidate();

		} else {
			ArrayList<SpellCard> addthismons = new ArrayList<SpellCard>();
			addthismons = gameBoardoard.getActivePlayer().getField()
					.getSpellArea();

			for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
					.getSpellArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);
				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());

				oSpellArea.add(addedmonsButton);

			}
			oSpellArea.revalidate();

			SpellArea.removeAll();

			addthismons = new ArrayList<SpellCard>();
			addthismons = gameBoardoard.getOpponentPlayer().getField()
					.getSpellArea();

			for (int i = 0; i != gameBoardoard.getOpponentPlayer().getField()
					.getSpellArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon();
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());

				SpellArea.add(addedmonsButton);

			}
			SpellArea.revalidate();

		}

	}

	private void reMonsterArea() {
		MonstersArea.removeAll();
		oMonstersArea.removeAll();
		if (gameBoardoard.getActivePlayer().equals(POne)) {
			ArrayList<MonsterCard> addthismons = new ArrayList<MonsterCard>();
			addthismons = gameBoardoard.getActivePlayer().getField()
					.getMonstersArea();

			for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
					.getMonstersArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				if (addthismons.get(i).getMode().equals(Mode.ATTACK))
					addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription()
						+ "lvl"
						+ addthismons.get(i).getLevel());

				MonstersArea.add(addedmonsButton);
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						MAct.show(addedmonsButton, 30, 30);
					}
				});
			}
			MonstersArea.revalidate();

			oMonstersArea.removeAll();

			addthismons = new ArrayList<MonsterCard>();
			addthismons = gameBoardoard.getOpponentPlayer().getField()
					.getMonstersArea();

			for (int i = 0; i != gameBoardoard.getOpponentPlayer().getField()
					.getMonstersArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				if (addthismons.get(i).getMode().equals(Mode.ATTACK))
					;
				addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription()
						+ "lvl"
						+ addthismons.get(i).getLevel());

				oMonstersArea.add(addedmonsButton);
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						oMAct.show(addedmonsButton, 30, 30);
					}
				});
			}
			oMonstersArea.revalidate();

		} else {
			ArrayList<MonsterCard> addthismons = new ArrayList<MonsterCard>();
			addthismons = gameBoardoard.getActivePlayer().getField()
					.getMonstersArea();

			oMonstersArea.removeAll();
			MonstersArea.removeAll();

			for (int i = 0; i != gameBoardoard.getActivePlayer().getField()
					.getMonstersArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);
				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				if (addthismons.get(i).getMode().equals(Mode.ATTACK))
					addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription()
						+ "lvl"
						+ addthismons.get(i).getLevel());

				oMonstersArea.add(addedmonsButton);
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						oMAct.show(addedmonsButton, 30, 30);
					}
				});
			}
			oMonstersArea.revalidate();

			MonstersArea.removeAll();

			addthismons = new ArrayList<MonsterCard>();
			addthismons = gameBoardoard.getOpponentPlayer().getField()
					.getMonstersArea();

			for (int i = 0; i != gameBoardoard.getOpponentPlayer().getField()
					.getMonstersArea().size(); i++) {

				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(
						"flower-of-life-blue.jpg");
				if (addthismons.get(i).getMode().equals(Mode.ATTACK))
					addedmonsimage = new ImageIcon(n + ".png");

				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription()
						+ "lvl"
						+ addthismons.get(i).getLevel());

				MonstersArea.add(addedmonsButton);
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						MAct.show(addedmonsButton, 30, 30);
					}
				});
			}
			MonstersArea.revalidate();

		}
	}

	private void refHand() {
		if (gameBoardoard.getActivePlayer().equals(POne)) {
			Hand.removeAll();
			oCopyHand();
		} else {
			oHand.removeAll();
			oCopyHand();
			oHand.revalidate();
		}
		oCopyHand();
		// Hand.invalidate();
		// Hand.revalidate();
		// oHand.invalidate();
		// oHand.revalidate();

		Hand.revalidate();

		oHand.revalidate();
		// Main.revalidate();

		// Main.pack();

	}

	private void refScreen() {
		playing.setText(playingVal);
		Phase.setText(PhaseVal);

	}

	public static void CopyHand() {

		ArrayList<Card> addthismons;

		if (gameBoardoard.getActivePlayer().equals(POne)) {
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getOpponentPlayer().getField()
					.getHand();

			int dd = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());

				oHand.add(addedmonsButton);

				System.out.println(i);
				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}
				});
				dd++;

			}

			oDeckString.setText(String.valueOf(oDeckSize - dd));
			oDeckString.revalidate();
			// Main.add(oHand);
			oHand.revalidate();
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getActivePlayer().getField().getHand();
			int ds = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);
				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());
				Hand.add(addedmonsButton);

				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}
				});
				ds++;

			}

			DeckString.setText(String.valueOf(DeckSize - ds));
			DeckString.revalidate();
			Hand.revalidate();
			oHand.revalidate();
			// Main.add(Hand);
		} else {
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getOpponentPlayer().getField()
					.getHand();

			int dd = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());

				Hand.add(addedmonsButton);

				System.out.println(i);
				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}
				});
				dd++;

			}

			DeckString.setText(String.valueOf(oDeckSize - dd));
			DeckString.revalidate();
			// Main.add(oHand);
			Hand.revalidate();
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getActivePlayer().getField().getHand();
			int ds = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);
				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());
				oHand.add(addedmonsButton);

				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}

				});
				ds++;

			}

			oDeckString.setText(String.valueOf(DeckSize - ds));
			oDeckString.revalidate();
			oHand.revalidate();
			oHand.revalidate();
			// Main.add(Hand);
		}
	}

	/*
	 * public static void CopyHand() { ArrayList<Card> addthismons = new
	 * ArrayList<Card>(); addthismons =
	 * gameBoardoard.getActivePlayer().getField().getHand();
	 * 
	 * if (gameBoardoard.getActivePlayer().getName() == POne.getName()) {
	 * 
	 * int dd = 0; for (int i = 0; i != addthismons.size(); i++) { String
	 * ButtonName; String n = addthismons.get(i).getName(); ButtonName =
	 * addthismons.get(i).getName(); JButton addedmonsButton = new
	 * JButton(ButtonName); ImageIcon addedmonsimage = new ImageIcon(n +
	 * ".png"); addedmonsimage.setImage(addedmonsimage.getImage()
	 * .getScaledInstance(170, 130, 20));
	 * addedmonsButton.setIcon(addedmonsimage);
	 * addedmonsimage.setDescription(addthismons.get(i) .getDescription());
	 * 
	 * Hand.add(addedmonsButton);
	 * 
	 * CopyHandCounter = i; addedmonsButton.addActionListener(new
	 * ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (gameBoardoard.getActivePlayer().getField()
	 * .getHand().get(CopyHandCounter) instanceof MonsterCard) {
	 * HmAct.show(addedmonsButton, 15, 30); } else { HsAct.show(addedmonsButton,
	 * 15, 30); }
	 * 
	 * } }); dd++;
	 * 
	 * }
	 * 
	 * DeckString.setText(String.valueOf(DeckSize - dd));
	 * DeckString.revalidate(); Main.add(Hand); Hand.revalidate(); } else { int
	 * dd = 0; for (int i = 0; i != addthismons.size(); i++) { String
	 * ButtonName; String n = addthismons.get(i).getName(); ButtonName =
	 * addthismons.get(i).getName(); JButton addedmonsButton = new
	 * JButton(ButtonName); ImageIcon addedmonsimage = new ImageIcon(n +
	 * ".png"); addedmonsimage.setImage(addedmonsimage.getImage()
	 * .getScaledInstance(170, 130, 20));
	 * addedmonsButton.setIcon(addedmonsimage);
	 * addedmonsimage.setDescription(addthismons.get(i) .getDescription());
	 * 
	 * oHand.add(addedmonsButton);
	 * 
	 * CopyHandCounter = i; addedmonsButton.addActionListener(new
	 * ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { //if
	 * (gameBoardoard.getActivePlayer().getField() //
	 * .getHand().get(CopyHandCounter) instanceof MonsterCard) {
	 * HmAct.show(addedmonsButton, 80, 80); //} else { //
	 * HsAct.show(addedmonsButton, 80, 80); // }
	 * 
	 * } }); dd++;
	 * 
	 * }
	 * 
	 * oDeckString.setText(String.valueOf(oDeckSize - dd));
	 * oDeckString.revalidate(); Main.add(oHand); oHand.revalidate(); } }
	 */
	public static void oCopyHand() {

		ArrayList<Card> addthismons;
		if (gameBoardoard.getActivePlayer().equals(PTwo)) {
			oHand.removeAll();
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getActivePlayer().getField().getHand();

			int dd = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);

				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());

				oHand.add(addedmonsButton);

				System.out.println(i);
				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}
				});
				dd++;

			}

			oDeckString.setText(String.valueOf(oDeckSize - dd));
			oDeckString.revalidate();
			// Main.add(oHand);
			oHand.revalidate();
		} else {
			Hand.removeAll();
			addthismons = new ArrayList<Card>();
			addthismons = gameBoardoard.getActivePlayer().getField().getHand();
			int ds = 0;
			for (int i = 0; i != addthismons.size(); i++) {
				String ButtonName;
				String n = addthismons.get(i).getName();
				ButtonName = addthismons.get(i).getName();
				JButton addedmonsButton = new JButton(ButtonName);
				ImageIcon addedmonsimage = new ImageIcon(n + ".png");
				addedmonsimage.setImage(addedmonsimage.getImage()
						.getScaledInstance(170, 130, 20));
				addedmonsButton.setIcon(addedmonsimage);
				addedmonsimage.setDescription(addthismons.get(i)
						.getDescription());

				addedmonsButton.setToolTipText(addthismons.get(i)
						.getDescription());
				Hand.add(addedmonsButton);

				CopyHandCounter = i;
				addedmonsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						O = e.getActionCommand();
						HAct.show(addedmonsButton, 30, 30);
					}
				});
				ds++;

			}

			DeckString.setText(String.valueOf(DeckSize - ds));
			DeckString.revalidate();
			Hand.revalidate();
			// Main.add(Hand);
		}
	}

	// GETTERS AND SETTERS END

	public static void main(String[] args) throws IOException,
			UnexpectedFormatException {
		JFrame x = new JFrame();
		x.setVisible(true);
		x.setSize(1000, 1000);

		JButton xx = new JButton("Empty");
		JButton xx2 = new JButton("Empty");

		JPanel xxx = new JPanel();
		xxx.setLayout(new GridLayout(10, 4));

		xxx.add(xx);
		xxx.add(xx2);
		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));
		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));
		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));

		xxx.add(new JButton("sooso"));

		xxx.setBounds(50, 50, 100, 100);

		JScrollPane p = new JScrollPane();
		p.setPreferredSize(new Dimension(250, 80));
		p.setAlignmentX(LEFT_ALIGNMENT);
		xxx.add(p);

		// xxx.add(xx);
		// xxx.add(xx2);
		// int i = 0;
		// while (i != 5) {
		//
		// xxx.add(new JButton(""));
		// i++;

		// x1.add(xxx);
	}
}
