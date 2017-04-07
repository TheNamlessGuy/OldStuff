package debug;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Bedug{
	static JLabel l = new JLabel("<html>Welcome to chess!</html>");
	static JFrame frame = new JFrame();
	public Bedug () {
		
		frame.setTitle("Debugz");
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocation(0,0);
		
		frame.add(l);
		frame.pack();
	}
	public static void update(String s){
		String s1 = l.getText();
		s1 = s1.substring(0,s1.length() - 7);
		s1 += "<br>" + s + "</html>";
		l.setText(s1);
		frame.pack();
	}
}