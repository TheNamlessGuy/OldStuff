import javax.swing.*;
public class nUtropstecken {
	/**
	 * Calculates "n!"
	 */
	public static void main(String[] args) {
		String h1 = JOptionPane.showInputDialog("Mata in ett värde!\nn!=1*2*3*...*(n-1)*n");
		int d1, d2, d3;
		d1 = Integer.parseInt(h1);
		d2 = 1;
		d3 = 1;
		while (d3 <= d1)
		{
			d2 = d2 * d3;
			d3 = d3 + 1;
		}
		JOptionPane.showMessageDialog(null, "Ditt värde blir: " + d2);
		System.exit(0);
	}

}
