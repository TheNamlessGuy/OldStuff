import javax.swing.*;
import java.text.*;
public class BankRent {
	/**
	 * Calculates your rent depending of your 
	 */
	public static void main(String[] args) {
		DecimalFormat dF = new DecimalFormat ("#.###");
		String h1 = JOptionPane.showInputDialog("Mata in hur mycket du lånade");
		String h2 = JOptionPane.showInputDialog("Mata in den fasta räntan per år");
		String h3 = JOptionPane.showInputDialog("Mata in hur många år du vill betala under");
		double pengar = Double.parseDouble(h1);
		double rent = Double.parseDouble(h2);
		rent = rent / 100;
		rent = 1 + rent;
		int years = Integer.parseInt(h3);
		int months = years * 12;
		int yearCount = 0;
		while (yearCount <= years)
			{
			pengar = pengar * rent;
			yearCount = yearCount + 1;
			}
		pengar = pengar / months;
		JOptionPane.showMessageDialog(null, "Lån = " + h1 + "\nRänta = " + h2 + "\nAntal år = " + years + "\nDu betalar " + dF.format(pengar) + " per månad!");
		System.exit(0);
	}
}
