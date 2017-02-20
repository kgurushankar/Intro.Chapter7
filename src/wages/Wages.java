package wages;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.text.DecimalFormat;

public class Wages extends JFrame
    //implements ActionListener
{
	private static final long serialVersionUID = 1L;
private JTextField inputHours, inputRate, display;
  private DecimalFormat money = new DecimalFormat("$0.00");

  public Wages()
  {
    super("Wages Calculator");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(3,2));

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

    //JButton calc = new JButton("Calculate wages");
    //calc.addActionListener(this);

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
    //c.add(calc, BorderLayout.SOUTH);
    
    
    inputRate.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			trigger();
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			trigger();
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			trigger();
			
		}
    });
    
    inputHours.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			trigger();
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			trigger();
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			trigger();
			
		}
    });
    
  	  
  }

  public double totalWages(double hours, double rate)
  {
    double wages;
    wages = (hours<=40)? (hours*rate) : ((((hours-40)*1.5)+40)*rate);
    wages = (rate<0)? (-1) : (wages);
    wages = (hours<0) ? (-1) : (wages);
    return wages;
  }

  public void trigger()
  {
	  if (emptyField()){
    String s = inputHours.getText();
    double hours = Double.parseDouble(s);
    s = inputRate.getText();
    double rate = Double.parseDouble(s);
    double wages = totalWages(hours, rate);
    String text = (wages<0) ? ("Invalid Input") : (money.format(wages));
    display.setText(text);}
	  else {
		  display.setText(money.format(0));
	  }
  }

  /*
  public void actionPerformed(ActionEvent e){
	  trigger();
  }
  */
  
  public static void main(String[] args)
  {
    Wages window = new Wages();
    window.setBounds(300, 300, 200, 150);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
  }
  
  private boolean emptyField (){
	  boolean var = (inputHours.getText().equals("") || inputRate.getText().equals(""));
	  return !var;
  }

  
}

