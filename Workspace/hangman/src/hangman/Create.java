package hangman;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Create {
	public static JFrame inputFrame(JButton ok, JPasswordField field, JLabel warningLabel, JButton randomize) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("<html><center>Welcome to hangman<br>Please input the word which will<br>be guessed (between 1 and 22 characters),<br>or click the randomize button to randomize the word!</center></html>");
		
		frame.setVisible(true);
		frame.setSize(400,155);
		frame.setTitle("Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		
		frame.add(label);
		frame.add(field);
		frame.add(ok);
		frame.add(randomize);
		frame.add(warningLabel);
		
		return frame;
	}
	public static JFrame frame(JTextField field, JButton ok, JLabel result, JLabel theHangMan, JLabel output, JLabel guessedLettersLabel){
		JFrame frame = new JFrame();
		
		frame.setVisible(false);
		frame.setSize(240,340);
		frame.setTitle("Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		
		frame.add(theHangMan);
		frame.add(new JLabel("********************************************"));
		frame.add(output);
		frame.add(field);
		frame.add(ok);
		frame.add(result);
		frame.add(new JLabel("********************************************"));
		frame.add(guessedLettersLabel);
		
		return frame;
	}
	public static String output(char[] c){
		String s = "";
		for (char c1: c){
			if(c1 == ' ' || c1 == 39 || c1 == '!' || c1 == '?'){
				s += c1 + " ";
			}else{
				s += "_ ";
			}
		}
		return s;
	}
	public static boolean[] guessed(boolean[] guessed){
		int index = 0;
		while(index != guessed.length){
			guessed[index] = false;
			index++;
		}
		return guessed;
	}
	public static JFrame winLoseFrame(JButton replay, JButton quit, JLabel winLose){
		JFrame frame = new JFrame();
		
		frame.setVisible(false);
		frame.setSize(300,100);
		frame.setTitle("Hangman");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		
		frame.add(winLose);
		frame.add(replay);
		frame.add(quit);
		
		return frame;
	}
}