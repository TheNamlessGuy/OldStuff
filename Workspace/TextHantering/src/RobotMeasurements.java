import javax.swing.*;
public class RobotMeasurements {
	/**
	 * Writes out where a package will be send depending on length, thickness and width
	 */
	public static void main(String[] args) {
		String l = JOptionPane.showInputDialog("Mata in längd");
		Double dl = Double.parseDouble(l);
		//Gets the length and converts to Double
		String t = JOptionPane.showInputDialog("Mata in tjocklek");
		Double dt = Double.parseDouble(t);
		//Gets the thickness and converts to Double
		String b = JOptionPane.showInputDialog("Mata in bredd");
		Double db = Double.parseDouble(b);
		//Gets the width and converts to Double
		String betyg = "Går till Örebro";
		//The value it prints if the IF fails
		if (140 <= dl && dl <= 600 && dt <= 100 && 90 <= db && db + dl + dt <= 900)
			/**
			 * Checks if the package length is between 140mm and 600mm
			 * if the thickness is equal to or greater than 100mm
			 * if the width is less than 90mm
			 * and if the length+width+thickness is less than 900
			 */
			betyg = "Går till Linköping";
		//The value it prints if the IF succeeds 
		JOptionPane.showMessageDialog(null, betyg);
		System.exit(0);
	}
}