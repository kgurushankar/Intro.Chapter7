package kgurushankar.intro.chapter7.craps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// Represents a control panel for a craps "table"

public class ControlPanel extends JPanel implements ActionListener {
	private CrapsTable table;
	private JButton rollButton, betButton;

	// private JTextField betMode;
	// Constructor
	public ControlPanel(CrapsTable t) {
		table = t;
		rollButton = new JButton("Roll");
		rollButton.addActionListener(this);
		add(rollButton);

		betButton = new JButton("Bet on Don't Pass");
		betButton.addActionListener(this);
		betButton.setToolTipText("Will not work if a game is in progress!");
		add(betButton);
	}

	// Called when the roll button is clicked
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == rollButton) {
			if (!table.diceAreRolling()) {
				table.rollDice();
			}
		} else if (button == betButton) {
			if (table.getPoint() == 0) {
				if (table.getMode()) {
					betButton.setText("Bet on Pass");
					// betMode.setText("Current Betting Mode: Don't Pass");
					table.togglemode();
				} else {
					betButton.setText("Bet on Don't Pass");
					// betMode.setText("Current Betting Mode: Pass");
					table.togglemode();
				}
				// System.out.println(table.getMode());
			}
		}
	}
}
