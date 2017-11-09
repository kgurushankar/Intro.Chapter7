package kgurushankar.wages;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.text.DecimalFormat;

public class Wages extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField inputHours, inputRate, display;

	public Wages() {
		super("Wages Calculator");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("   Hours worked:"));
		inputHours = new JTextField(5);
		inputHours.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(inputHours);

		panel.add(new JLabel("   Hourly rate:"));
		inputRate = new JTextField(5);
		inputRate.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(inputRate);

		panel.add(new JLabel("   Total wages:"));
		display = new JTextField(20);
		display.setHorizontalAlignment(JTextField.RIGHT);
		display.setEditable(false);
		display.setBackground(Color.yellow);
		panel.add(display);

		Container c = getContentPane();
		c.add(panel, BorderLayout.CENTER);

		inputRate.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				update();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				update();
			}
		});

		inputHours.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				update();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				update();
			}
		});

	}

	/**
	 * Calculates total wages for a person<br />
	 * This does take overtime into account
	 * 
	 * @param hours
	 *            the hours worked in the week
	 * @param rate
	 *            the hourly rate paid
	 */
	public double totalWages(double hours, double rate) {
		double wages;
		wages = (hours * rate) + ((hours <= 40) ? 0 : (((hours - 40) * .5) * rate));
		wages = (rate < 0) ? (-1) : (wages);
		wages = (hours < 0) ? (-1) : (wages);
		return wages;
	}

	/** General method to update the values in the box */
	public void update() {
		DecimalFormat money = new DecimalFormat("$0.00");
		if (emptyField()) {
			String h = inputHours.getText();
			String r = inputRate.getText();
			try {
				double hours = Double.parseDouble(h);
				double rate = Double.parseDouble(r);
				double wages = totalWages(hours, rate);
				String text = (wages < 0) ? ("Invalid Input") : (money.format(wages));
				display.setText(text);
			} catch (Exception e) {
				display.setText("Invalid Input");
			}

		} else {
			display.setText("");
		}
	}

	public static void main(String[] args) {
		Wages window = new Wages();
		window.setBounds(300, 300, 200, 150);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	/** @return if either of the text-boxes are empty */
	private boolean emptyField() {
		boolean var = (inputHours.getText().equals("") || inputRate.getText().equals(""));
		return !var;
	}

}
