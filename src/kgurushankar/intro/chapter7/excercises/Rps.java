package kgurushankar.intro.chapter7.excercises;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rps extends JFrame implements ActionListener {
	private final char moves[] = { 'R', 'P', 'S' };
	private JRadioButton rock, paper, scissors;
	private JTextField display;

	public Rps() {
		super("Rock, Paper, Scissors");

		rock = new JRadioButton("   Rock   ", true);
		paper = new JRadioButton("   Paper  ");
		scissors = new JRadioButton(" Scissors ");

		ButtonGroup rpsButtons = new ButtonGroup();
		rpsButtons.add(rock);
		rpsButtons.add(paper);
		rpsButtons.add(scissors);

		JButton go = new JButton("         Go         ");
		go.addActionListener(this);

		display = new JTextField(25);
		display.setEditable(false);
		display.setBackground(Color.yellow);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(rock);
		c.add(paper);
		c.add(scissors);
		c.add(go);
		c.add(display);
	}

	/**
	 * Determines the outcome of a Rock Paper Scissors game
	 * 
	 * @param computerMove
	 *            value of the computers move
	 * @param playerMove
	 *            value of the players move
	 * @pre both moves must be in format </br>
	 *      <html>
	 *      <table>
	 *      <tr>
	 *      <th>Value</th>
	 *      <th>Meaning</th>
	 *      </tr>
	 *      <tr>
	 *      <td>R</td>
	 *      <td>Rock</td>
	 *      </tr>
	 *      <tr>
	 *      <td>P</td>
	 *      <td>Paper</td>
	 *      </tr>
	 *      <tr>
	 *      <td>S</td>
	 *      <td>Scissors</td>
	 *      </tr>
	 *      </table>
	 *      </html>
	 * @return <html>
	 *         <table>
	 *         <tr>
	 *         <th>Value</th>
	 *         <th>Case/Meaning</th>
	 *         </tr>
	 *         <tr>
	 *         <td>-1</td>
	 *         <td>Player Wins</td>
	 *         </tr>
	 *         <tr>
	 *         <td>0</td>
	 *         <td>Tie</td>
	 *         </tr>
	 *         <tr>
	 *         <td>1</td>
	 *         <td>Computer Wins</td>
	 *         </tr>
	 *         </table>
	 *         </html>
	 */
	private int nextPlay(char computerMove, char playerMove) {
		computerMove = (char) ((Character.isUpperCase(computerMove)) ? computerMove : (computerMove + 32));
		playerMove = (char) ((Character.isUpperCase(playerMove)) ? playerMove : (playerMove + 32));

		switch (computerMove) {
		case 'R':
			switch (playerMove) {
			case 'S':
				return 1;
			case 'P':
				return -1;
			default:
				return 0;
			}
		case 'P':
			switch (playerMove) {
			case 'R':
				return 1;
			case 'S':
				return -1;
			default:
				return 0;
			}
		default:
			switch (playerMove) {
			case 'P':
				return 1;
			case 'R':
				return -1;
			default:
				return 0;
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		char playerMove, computerMove;
		if (rock.isSelected())
			playerMove = 'R';
		else if (paper.isSelected())
			playerMove = 'P';
		else // if (scissors.isSelected())
			playerMove = 'S';

		int k = (int) (Math.random() * 3);
		computerMove = moves[k];
		int result = nextPlay(computerMove, playerMove);

		String msg = "  You said " + makeWord(playerMove) + ", I said " + makeWord(computerMove);
		if (result < 0)
			msg += " -- you win.";
		else if (result == 0)
			msg += " -- tie.";
		else // if (result > 0)
			msg += " -- I win.";
		display.setText(msg);
	}

	private String makeWord(char move) {
		String word = "";

		switch (move) {
		case 'R':
			word = "ROCK";
			break;
		case 'P':
			word = "PAPER";
			break;
		case 'S':
			word = "SCISSORS";
			break;
		}
		return word;
	}

	public static void main(String[] args) {
		Rps window = new Rps();
		window.setBounds(300, 300, 300, 140);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
