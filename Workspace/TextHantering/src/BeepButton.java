import java.awt.Toolkit;
import javax.swing.JOptionPane;
public class BeepButton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int response = 0;
		String[] beepButton = {"Beep"};
		while (response == 0)
		{
			response = JOptionPane.showOptionDialog(
					null,
					"",
					"",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					beepButton,
					"Wut?");
			switch (response) {
			case 0: Toolkit.getDefaultToolkit().beep();
					break;
			default: break;
			}
			
		}
		System.exit(0);
	}

}
