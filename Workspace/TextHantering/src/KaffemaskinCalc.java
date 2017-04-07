
public class KaffemaskinCalc {
	public static String CoffeSort(int input) {
		String kaffetyp; //What type of coffee you want in String
		switch(input) //Checks what you chose in the OptionDialog
		{
		case 0: kaffetyp = "latte";
				break;
		case 1: kaffetyp = "cappucino";
				break;
		case 2: kaffetyp = "svart";
				break;
		default: kaffetyp = "ingen";
				 break;
		}
		return kaffetyp;
	}
	public static String CoffeeSize(int input, int koppantal1) {
		String kaffestorlek; //What size of coffee you want
		switch (input) //Checks what you put in the OptionPane
		{
		case 0: if (koppantal1 > 1)
				{kaffestorlek = "små koppar ";}
				else
				{kaffestorlek = "liten kopp ";}
				break;
		case 1: if (koppantal1 > 1)
				{kaffestorlek = "medium koppar ";}
				else
				{kaffestorlek = "medium kopp ";}
				break;
		case 2: if (koppantal1 > 1)
				{kaffestorlek = "stora koppar ";}
				else
				{kaffestorlek = "stor kopp ";}
				break;
		default: kaffestorlek = "ingen kopp ";
				 break;
		}
		return kaffestorlek;
	}

}
