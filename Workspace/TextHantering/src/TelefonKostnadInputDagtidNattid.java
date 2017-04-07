import javax.swing.*;
public class TelefonKostnadInputDagtidNattid {
	/**
	 * Calculates the price you talked for on your phone
	 */
	public static void main(String[] args) {
		String h1 = JOptionPane.showInputDialog("Antal minuter?");
		//Gets the number of minutes spoken
		Double d1 = Double.parseDouble(h1);
		//Converts h1 do Double
		int knappNr = JOptionPane.showConfirmDialog(null, "Dagtid?");
		//Asks if you talk during the Daytime
		if (knappNr == 0)
			d1 = d1 * 2.5;
		//When you pick "Ja", it sets d1 to the full price
		else
			d1 = d1 * 1.5;
		//When you pick "Nej", it sets d1 to the full price
		JOptionPane.showMessageDialog(null, "Du betalar " + d1 + " kr");
		//Writes out your price
	System.exit(0);
	}
}
