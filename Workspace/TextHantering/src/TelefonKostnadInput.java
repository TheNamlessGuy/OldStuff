import javax.swing.*;
public class TelefonKostnadInput {
	/**
	 * Writes out how much money you waste on talking on the phone per month
	 */
	public static void main(String[] args) { 
		String h1 = JOptionPane.showInputDialog("Hur många minuter pratar du i telefonen per månad?");
		//h1 gets the number of minutes
		String h2 = JOptionPane.showInputDialog("Hur mycket är ditt minutpris?");
		//h2 gets the price of talking on the phone per minute
		double d1 = Double.parseDouble(h1);
		//d1 gets the number from h1 and converts it to Double
		double d2 = Double.parseDouble(h2);
		//d2 gets the amount from h2
		double d3 = d1 * d2;
		//d3 calculates the sum per minute
		JOptionPane.showMessageDialog(null,"Om du pratar i " + d1 + " minuter \nmed kostnaden " + d2 + " kr per minut \nkostar det " + d3 + " kr.");
		//Prints out the cost per minute
		System.exit(0);	
	}
}
