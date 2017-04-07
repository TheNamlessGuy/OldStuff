import javax.swing.*;
import java.text.*;
public class TriangleSideCalc {
	/**
	 * Writes out the side c, and what type of triangle it is.
	 */
	public static void main(String[] args) {
		String h1, h2, h3, hTriangelTyp;
		Double a, b, c, dAlpha;
		DecimalFormat dF = new DecimalFormat("#.###");
		h1 = JOptionPane.showInputDialog("Mata in a");
		//Gets the value of a
		a = Double.parseDouble(h1);
		//Converts a to double
		if (a <= 0)
			{JOptionPane.showMessageDialog(null, "En sida kan inte vara 0 eller mindre");
			System.exit(0);};
		//Checks if a is less than 0
		h2 = JOptionPane.showInputDialog("Mata in b");
		//Gets the value of b
		b = Double.parseDouble(h2);
		//Converts b to double
		if (b <= 0)
			{JOptionPane.showMessageDialog(null, "En sida kan inte vara 0 eller mindre");
			System.exit(0);}
		//Checks if b is less than 0
		h3 = JOptionPane.showInputDialog("Mata in alpha i grader");
		//Gets the value of alpha
		dAlpha = Double.parseDouble(h3);
		//Converts alpha to Double
		if (dAlpha <= 0 || dAlpha >= 180)
			{JOptionPane.showMessageDialog(null, "Din vinkel kan inte vara större än 180 grader, \neller mindre än 0 grader");
			System.exit(0);}
		//Checks if alpha is between 0 and 180 degrees
		dAlpha = dAlpha * (Math.PI / 180);
		//Sets alpha as a computer angle
		c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2) - (2 * a * b * Math.cos(dAlpha)));
		//Calculates c
		if (a == b || a == c)
			{hTriangelTyp = "likbent.";}
		//Checks the triangle type
		else if (a == b && a == c)
			{hTriangelTyp = "liksidig.";}
		//Checks for another triangle type
		else if (dAlpha == (Math.PI / 2))
			{hTriangelTyp = "rätvinklig.";}
		//Checks for a third triangle type
		else
			{hTriangelTyp = "varken liksidig eller likbent.";}
		//What to write if all the others fail
		JOptionPane.showMessageDialog(null, "Din triangel har sidan c = " + dF.format(c) + ".\nTriangeln är " + hTriangelTyp);
		//Writes out the answer
		System.exit(0);
	}
}
