package guessMyNumberJFrameEdition;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
public class GuessThatNumberJFrame extends Thread{

	static JLabel timer = new JLabel("");
	static boolean timerBoolean = false;
	static int timerInt = 0;
	final static JButton yes = new JButton("Yes");
	final static JButton no = new JButton("No");
	static JLabel hubbaBubba = new JLabel("");
	static JFrame guessedRightFrame = new JFrame();
	
	public static void main(String[] args) {
		final String[] s = {"","",""};
		final int[] i = {1,2};
		final int[] numberOfGuesses = {0};
		final ArrayList<Integer> statistics = new ArrayList<Integer>();
		i[1] = Method.randomizer();
		JLabel beginningText = new JLabel("<html><center>Welcome to Guess That Number!<br>Your objective is to guess the number the computer has chosen!<br>The number is between 0 and 10</center></html>");
		JLabel guessThatNumber = new JLabel("<html><center>Guess that number:</center></html>");
		final JLabel answer = new JLabel("");
		final JLabel guessedNumbers = new JLabel("<html><center>******************************************************************<br>Guessed numbers: </center></html>");
		final JTextField field = new JTextField(10);
		JButton button = new JButton("OK");
		guessedRightFrame = Method.createFinishFrame(yes, no, hubbaBubba, timer);
		final JFrame frame = Method.createFrame(field, button, beginningText, guessThatNumber, answer, guessedNumbers);
		
		final Thread th = new GuessThatNumberJFrame();
		th.start();
		timerBoolean = true;
		ActionListener actions = new ActionListener(){
			public void actionPerformed (ActionEvent e){
				s[0] = field.getText();
				if (s[0].equalsIgnoreCase("HAX")){
					answer.setText("The computers number: " + i[1]);
				}else if(s[0].equalsIgnoreCase("you suck")){
					answer.setText("<html><center>No, you suck!</center></html>");
				}else if(s[0].equalsIgnoreCase("reset")){
					answer.setText("");
					i[1] = Method.randomizer();
					guessedNumbers.setText("<html><center>******************************************************************<br>Guessed numbers: </center></html>");
					statistics.add(numberOfGuesses[0]);
					numberOfGuesses[0] = 0;
				}else if(s[0].equalsIgnoreCase("stats")){
					answer.setText(Method.statistics(statistics));
				}else if(s[0].equalsIgnoreCase("average")){
					answer.setText(Method.average(statistics));
				}else if(s[0].equalsIgnoreCase("median")){
					answer.setText(Method.median(statistics));
				}else{
				try{
					i[0] = Integer.parseInt(s[0]);
				}catch(Exception exception){
					s[1] = "That wasn't a number!";
				}
				if (s[1].equals("That wasn't a number!")){
					answer.setText(s[1]);
					s[1] = "";
				}else{
					s[0] = Method.indexCheck(i);
					s[2] = guessedNumbers.getText();
					s[2] = s[2].substring(0,s[2].length()-16);
					if(!(s[2].contains(Integer.toString(i[0])))){
					guessedNumbers.setText(s[2] + Integer.toString(i[0]) + ", </center></html>");
					}
					numberOfGuesses[0]++;
					hubbaBubba.setText("You guessed " + numberOfGuesses[0] + " times!");
					if (s[0].equals("ok")){
						if (i[0] == i[1]){
							answer.setText("");
							timerBoolean = false;
							guessedRightFrame = Method.createFinishFrame(yes, no, hubbaBubba, timer);
							guessedRightFrame.setVisible(true);
						}else if(i[0] > i[1]){
							answer.setText("<html><center>Your number is bigger than the computers</center></html>");
						}else if(i[0] < i[1]){
							answer.setText("<html><center>Your number is smaller than the computers</center></html>");
						}
					}else{
						answer.setText(s[0]);
					}
				}
				}
				field.setText("");
			}
		};
		ActionListener yesNoListener = new ActionListener(){
			public void actionPerformed (ActionEvent e){
				if (e.getSource() == yes){
					i[1] = Method.randomizer();
					guessedRightFrame.dispose();
					guessedNumbers.setText("<html><center>******************************************************************<br>Guessed numbers: </center></html>");
					statistics.add(numberOfGuesses[0]);
					timerBoolean = true;
					timerInt = 0;
					Thread th = new GuessThatNumberJFrame();
					th.start();
					numberOfGuesses[0] = 0;
				}else if(e.getSource() == no){
					guessedRightFrame.dispose();
					frame.dispose();
				}
			}
		};
		field.addActionListener(actions);
		button.addActionListener(actions);
		yes.addActionListener(yesNoListener);
		no.addActionListener(yesNoListener);
	}
	public void run(){
		while(timerBoolean == true){
			timerInt++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			timer.setText("<html><center>You took " + timerInt + " seconds to find the correct answer!</center></html>");
		}
	}
}
