import javax.swing.*;
public class PersonNr {
	/**
	 * Checks if two people share the same birthday
	 */
	public static void main(String[] args) {
		String datum1, datum2;
		datum1 = JOptionPane.showInputDialog("Mata in det första personnummret (10 siffror)");
		//Gets the first date
		datum1 = datum1.trim();
		//trims away any additional spaces
		datum1 = datum1.substring(2,6);
		//Sets datum1 as the 3rd, 4th, 5th, 6th number
		datum2 = JOptionPane.showInputDialog("Mata in det andra personnumret (10 siffror)");
		//Gets the second date
		datum2 = datum2.trim();
		//trims away any additional spaces
		datum2 = datum2.substring(2,6);
		//Sets datum2 as the 3rd, 4th, 5th, 6th number
		if  (datum1.equals (datum2))
			JOptionPane.showMessageDialog(null, "De fyller på samma datum!");
		else 
			JOptionPane.showMessageDialog(null, "De fyller inte år på samma dag...");
			//Checks if the dates are the same, and writes out the answer
	System.exit(0);
	}

}
