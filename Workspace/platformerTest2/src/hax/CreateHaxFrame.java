package hax;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class CreateHaxFrame {public static JFrame haxFrame(){
	JFrame f = new JFrame();
	f.setTitle("");
	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	f.setResizable(false);
	f.setVisible(true);
	JTextField t = new JTextField(10);
	t.addActionListener(new HaxListener());
	
	Dimension d = f.getSize();
    int w1 = (int)d.getWidth() / 2;
    int h1 = (int)d.getHeight() / 2;
    int w2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2;
    int h2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2;
    h2 = h2 - h1;
    w2 = w2 - w1;
    f.setLocation(w2, h2);
	
	f.add(t);
	f.pack();
	return f;
}
}
