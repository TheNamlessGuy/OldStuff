import javax.swing.*;
public class GenderBender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pnr1;
		Double nr1;
		pnr1 = JOptionPane.showInputDialog("Mata in personnummer (≈≈MMDDXXXX)");
		pnr1 = pnr1.substring(8,9);
		nr1 = Double.parseDouble(pnr1);
		nr1 = nr1 % 2;
		if (nr1 != 0)
			pnr1 = "man.";
		else 
			pnr1 = "kvinna.";
		JOptionPane.showMessageDialog(null, "Du ‰r en " + pnr1);
		System.exit(0);
	}

}
