import javax.swing.*;
public class Kaffemaskin {
	/**
	 * A program that gives you coffee depending on how 
	 * much money you put in.
	 * A cup will cost 2 kr, and you will get
	 * the money left in return
	 */
	public static void main(String[] args) {
		//Start of program
		int pengar = 0;
		//The variable for how much money you have
		int response1 = 0;
		//Your response for which coin to put in
		int koppantal1 = 0;
		//How many cups you get
		String koppantal;
		//How many cups you get in String
		String kaffetyp;
		//What coffeetype you want in String
		String kaffestorlek;
		//What coffeesize you want in String
		String[] mynttyp = {"Enkrona", "Femkrona", "Tiokrona", "Klar"};
		//The buttons on the window that asks which coin you want to put in
		String[] kaffesort = {"Latte", "Cappucino", "Svart"};
		//The buttons on the window that asks which type of coffee you want
		String[] storlek = {"Liten", "Medium", "Stor"};
		//The buttons on the window that asks which size of cup you want
		while (response1 != 3) {
			response1 = JOptionPane.showOptionDialog(
					null,
					"Vilket mynt vill du lägga in?\nDu har lagt in " + pengar + " kr redan.\nEn kopp kostar 2 kr",
					"Myntintag",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE,
					null,
					mynttyp,
					"Va?");
			//Asks you which coin you want to put in
		switch (response1){
		case 0: pengar = pengar + 1;
				break;
		case 1: pengar = pengar + 5;
				break;
		case 2: pengar = pengar + 10;
				break;
		case 3: pengar = pengar + 0;
				break;
		default: pengar = pengar + 0;
				 break;
		//Checks the coins value and adds it to "pengar"
		}
		}
		if (pengar <= 1) //Checks if you put in less money that required
		{
			JOptionPane.showMessageDialog(null, "Vill du inte ha kaffe? Ok!");
			//Asks you if you don't want coffee and exits
			System.exit(0);
			//Exits program
		}
		if (pengar >= 4) //Checks if you can buy more than one cup
		{
			koppantal1 = pengar/2; //calculates how many cups you can get
			koppantal = JOptionPane.showInputDialog("Hur många koppar vill du ha?\nDu kan köpa " + koppantal1 + " koppar");
			//Asks you how many cups you want
			koppantal1 = Integer.parseInt(koppantal);
			//Converts the cup total to int
			if (koppantal1 <= 0)
			//checks if you cheat the system and tries to get negative cups of coffee
			{
				JOptionPane.showMessageDialog(null, "Du kan inte beställa 0 eller mindre koppar!\nDu får " + pengar + " kr tillbaka");
				//tells you you can't get 0 or less cups
				System.exit(0);
				//Exits program
			}
			if (koppantal1 > (pengar/2)) //Checks if you ask for too many cups
			{
				JOptionPane.showMessageDialog(null, "Du begär för många koppar\nDu får " + pengar + " kr tillbaka");
				//Tells you you asked for too many cups
				System.exit(0);
				//Exits program
			}
		}
		else
		{
			if (pengar > 1) //Checks if you put in enough money for one cup
			koppantal1 = 1;//What it sets the cup total to if you put in enough money
			else
			koppantal1 = 0;//What it sets the cup total to if you didn't put in enough money
		}
		response1 = JOptionPane.showOptionDialog( //Asks what kind of coffee you want
				null,
				"Vilken kaffesort vill du ha?",
				"Kaffesort",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				kaffesort,
				"Va?");
		kaffetyp = KaffemaskinCalc.CoffeSort(response1);
		//Gets your type of coffee in the variable "kaffetyp"
		response1 = JOptionPane.showOptionDialog( //Asks which cupsize you want
				null,
				"Vilken koppstorlek vill du ha?",
				"Koppstorlek",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE,
				null,
				storlek,
				"Va?");
		kaffestorlek = KaffemaskinCalc.CoffeeSize(response1, koppantal1);
		//Gets the size of your coffee in the variable "kaffestorlek"
		int koppantal2 = koppantal1;
		//Koppantal2 gets the value as how many cups you get so it can
		//calculate it below
		while (koppantal2 > 0)//Asks you to put in a cup as many times as the number of cups you want
		{
			JOptionPane.showMessageDialog(null,"Sätt in en kopp");
			koppantal2--;
		}
		//Asks you to put in a cup
			pengar = pengar - (koppantal1*2);
			//Sets "pengar" as the amount of money you get in return
			JOptionPane.showMessageDialog(null, "Du har köpt " + koppantal1 + " " + kaffestorlek + kaffetyp + ".\nDu får " + pengar + " kr tillbaka.");
			//Writes out the answer
		System.exit(0); //Exits the program
	}

}
