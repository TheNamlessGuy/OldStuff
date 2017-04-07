package guessMyNumberJFrameEdition;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Method {
	public static int randomizer(){
		Random random = new Random();
		int i = 0;
		i = random.nextInt(11);
		return i;
	}
	public static JFrame createFrame(JTextField field, JButton button, JLabel beginningText, JLabel guessThatNumber, JLabel answer, JLabel guessedNumbers) {
		JFrame frame = new JFrame();
		
		frame.setTitle("Guess that number!");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(400,180);
		frame.setLocationRelativeTo(null);
		
		frame.add(beginningText);
		frame.add(guessThatNumber);
		frame.add(field);
		frame.add(button);
		frame.add(guessedNumbers);
		frame.add(answer);
		return frame;
	}
	public static String indexCheck(int[] i){
		String s;
		if (i[0] < 0){
			s = "<html><center>You need to input a bigger number!</center></html>";
		}else if(i[0] > 10){
			s = "<html><center>You need to input a smaller number!</center></html>";
		}else{
			s = "ok";
		}
		return s;
	}
	public static JFrame createFinishFrame(JButton yes, JButton no, JLabel hubbaBubba, JLabel timer){
		JLabel wonner = new JLabel("<html><center>You guessed the right number, congratulations!<br>Would you like to play again?</center></html>");
		JFrame frame = new JFrame();
		
		frame.setTitle("A winner is you!");
		frame.setSize(300,150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		frame.setVisible(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.add(wonner);
		frame.add(hubbaBubba);
		frame.add(timer);
		frame.add(yes);
		frame.add(no);
		return frame;
	}
	public static String statistics(ArrayList<Integer> s){
		String s1 = "<html><center>It took you this long to find the number earlier: ";
		for(Integer i : s){
			s1 += Integer.toString(i) + ", ";
		}
		s1 += "</center></html>";
		return s1;
	}
	public static String average(ArrayList<Integer> s){
		String s1 = "<html><center>This is your average this session: ";
		int tot = 0;
		for(int i: s){
			tot += i;
		}
		tot = (int)Math.floor(tot/s.size());
		s1 += Integer.toString(tot) + "</center></html>";
		return s1;
	}
	public static String median(ArrayList<Integer> s){
		String s1 = "<html><center>This is your median this session: ";
		int value = 0;
		value = (int)Math.floor(s.size()/2);
		value = s.get(value);
		s1 += Integer.toString(value) + "</center></html>";
		return s1;
	}
}
