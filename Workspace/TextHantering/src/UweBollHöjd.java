import javax.swing.*;
public class UweBollHöjd {
	/**
	 * Counts how many times you bounced a ball depending on the original height and the procentage loss every bounce
	 */
	public static void main(String[] args) {
	String h1 = JOptionPane.showInputDialog("Mata in höjden");
	//Gets the height
	double h = Double.parseDouble(h1);
	//Converts height to double
	String proc1 = JOptionPane.showInputDialog("Mata in hur många procent den förlorar per studs");
	//Gets the percentage loss
	double proc = Double.parseDouble(proc1);
	//Converts the percentage to double
	proc = proc / 100;
	//Recalcs percentage to a normal number
	proc = 1 - proc;
	//Gets the reverse value of percentage
	int studs = 0;
	//Creates the number of bounces
	while (h > 0.0001)
	{
	h = h*proc;
	studs = studs + 1;
	}
	//Calculates the calculation
	JOptionPane.showMessageDialog(null, "Din boll studsar " + studs + " gånger!");
	//Reveals the amazing answer!
	System.exit(0);
	}
}
