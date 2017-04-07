package hangman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
public class Hangman {
	
	static char[] c = new char[1];
	static String sOutput = "";
	static String guessedLetters = "";
	static boolean[] guessed = new boolean[1];
	static boolean wins = false;
	static int guessesLeft = 9;
	static int r = 0;
	
	public static void main(String[] args) {
		
		final JLabel theHangMan = new JLabel();
		theHangMan.setText(Get.theHangMan(guessesLeft));
		
		final String[] words = {"Hangman", "lolwut", "Cocoon", "Fig", "Dyslexia", "Valve", "Brother", "Defining", "Sport", "Valuable", "Consent", "Market", "Value", "Eagle", "Pillow", "Fridge", "Cry"};
		final Random random = new Random();
		final JLabel result = new JLabel("<html><center></center></html>");
		final JLabel winLose = new JLabel();
		final JLabel warningLabel = new JLabel();
		final JLabel output = new JLabel();
		final JLabel guessedLettersLabel = new JLabel("<html><center>Guessed letters: </center></html>");
		final JButton randomize = new JButton("Randomize");
		final JButton ok1 = new JButton("OK");
		final JButton ok2 = new JButton("OK");
		final JButton replay1 = new JButton("Play Again");
		final JButton quit1 = new JButton("Quit");
		final JPasswordField inputfield = new JPasswordField(20);
		final JTextField field = new JTextField(20);
		final JFrame inputFrame = Create.inputFrame(ok1, inputfield, warningLabel, randomize);
		final JFrame frame = Create.frame(field, ok2, result, theHangMan, output, guessedLettersLabel);
		final JFrame winLoseFrame = Create.winLoseFrame(replay1, quit1, winLose);
		final JRootPane rootPane = winLoseFrame.getRootPane();
		rootPane.setDefaultButton(replay1);
		
		ActionListener inputListener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == ok1 || e.getSource() == inputfield){
				c = inputfield.getPassword();
				if(c.length < 1 || c[0] == 39 || c[0] == '!' || c[0] == ' ' || c[0] == '?' || c.length > 22){
					warningLabel.setText("<html><center>Input a proper word!</center></html>");
					inputfield.setText("");
				}else{
				guessed = new boolean[c.length];
				guessed = Create.guessed(guessed);
				inputfield.setText("");
				sOutput = Create.output(c);
				output.setText(sOutput);				
				inputFrame.setVisible(false);
				frame.setVisible(true);
				}
				}else{
					r = random.nextInt(words.length);
					c = words[r].toCharArray();
					guessed = new boolean[c.length];
					guessed = Create.guessed(guessed);
					inputfield.setText("");
					sOutput = Create.output(c);
					output.setText(sOutput);				
					inputFrame.setVisible(false);
					frame.setVisible(true);
				}
			}
		};
		ok1.addActionListener(inputListener);
		inputfield.addActionListener(inputListener);
		randomize.addActionListener(inputListener);
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = field.getText();
				char c1;
				boolean success = false;
				field.setText("");
				if(s.equalsIgnoreCase(Get.c(c))){
					winLose.setText("<html><center>Congratulations, you won!<br>Would you like to play again or quit?</center></html>");
					winLoseFrame.setVisible(true);
					output.setText(Get.c(c));
					field.setEnabled(false);
					ok2.setEnabled(false);
				}else if(s.equalsIgnoreCase("HAX")){ //HAX
					result.setText("<html><center>The word is '" + Get.c(c) + "'</center></html>");
				}else if(s.equalsIgnoreCase("il")){ //INSTANT LOSS
					guessesLeft = 0;
					theHangMan.setText(Get.theHangMan(guessesLeft));
					output.setText(Get.c(c));
					winLose.setText("<html><center>Oh no, you lost! Too bad!<br>Would you like to play again or quit?</center></html>");
					winLoseFrame.setVisible(true);
					guessedLettersLabel.setText("<html><center>Guessed letters: </center></html>");
					field.setEnabled(false);
					ok2.setEnabled(false);
				}else if(s.length() > 1){ //MORE THAN ONE LETTER
					result.setText("<html><center>You can only input one letter!</center></html>");
				}else if(s.equals(null) || s.equals("")){ //IF SPACE
					result.setText("<html><center>Input something!</center></html>");
				}else{
					c1 = s.charAt(0);
					for (char c2: c){
						if (Character.toLowerCase(c2) == Character.toLowerCase(c1)){
							success = true;
							break;
						}
					}
					if(success){
						output.setText(Get.output(c, c1, guessed));
						if (Get.contains(Get.output(c,c1,guessed), c1)){ //IF C1 IS IN GUESSEDLETTERS
							result.setText("<html><center>You already guessed that letter!</center></html>");
							System.out.println("a");
						}else{
							result.setText("<html><center>The input was found</center></html>");
						}
						wins = Get.wins(guessed, c);
						if (wins){
							winLose.setText("<html><center>Congratulations, you won!<br>Would you like to play again or quit?</center></html>");
							winLoseFrame.setVisible(true);
							field.setEnabled(false);
							ok2.setEnabled(false);
						}
					}else{
						if(Get.contains(guessedLetters, c1)){
							result.setText("<html><center>You already guessed that letter!</center></html>");
							}else if (!Get.contains(guessedLetters, c1)){
								guessedLetters += "" + c1 + " ";
								guessedLettersLabel.setText("<html><center>Guessed letters: " + guessedLetters + "</center></html>");
								guessesLeft--;
								result.setText("<html><center>The input was not found.<br>You have " + guessesLeft + " guesses left</center></html>");
							}
						if(guessesLeft == 0){ //LOSE
						winLose.setText("<html><center>Oh no, you lost! Too bad!<br>Would you like to play again or quit?</center></html>");
						output.setText(Get.c(c));
						winLoseFrame.setVisible(true);
						field.setEnabled(false);
						ok2.setEnabled(false);
						}
						theHangMan.setText(Get.theHangMan(guessesLeft));
					}
				}
			}
		};
		ok2.addActionListener(listener);
		field.addActionListener(listener);
		ActionListener winLoseListener = new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == quit1){
					winLoseFrame.dispose();
					frame.dispose();
					System.exit(0);
				}else{
					guessesLeft = 9;
					frame.setVisible(false);
					inputFrame.setVisible(true);
					winLoseFrame.dispose();
					field.setEnabled(true);
					ok2.setEnabled(true);
					guessedLettersLabel.setText("<html><center>Guessed letters: </center></html>");
					theHangMan.setText(Get.theHangMan(guessesLeft));
					guessedLetters = "";
					rootPane.setDefaultButton(replay1);
				}
			}
		};
		replay1.addActionListener(winLoseListener);
		quit1.addActionListener(winLoseListener);
	}
}