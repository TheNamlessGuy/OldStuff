import javax.swing.*;
public class MomsSats {
	/**
	 * Writes out how much you payed excluding the MOMS
	 */
	public static void main(String[] args) {
		String h1 = JOptionPane.showInputDialog("Skriv in hur mycket du betalade inklusive moms");
		//h1 gets the amount you payed with MOMS
		double d1 = Double.parseDouble(h1);
		//d1 gets the value of h1
		double d2 = 0.75;
		//d2 is the percentage excluding MOMS
		double d3 = d1 * d2;
		//d3 calculates the sum
		JOptionPane.showMessageDialog(null,"Det kostade " + d3 + " kr utan moms.");
		//writes out the price afterwards
		System.exit(0);
	}
}
