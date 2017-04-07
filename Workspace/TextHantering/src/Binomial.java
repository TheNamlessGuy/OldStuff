import javax.swing.*;
public class Binomial {
	/**
	 * Beräknar en binomialkoefficient för
	 * n och k (n!/(k!*(n-k)!)
	 */
	public static void main(String[] args) {
		String input;
		//Får alla inputs som en string
		int n;
		//Håller talet n
		int k;
		//Håller talet k;
		int svar;
		//Håller svaret som man får ut efter beräkning
		input = JOptionPane.showInputDialog("Mata in n");
		//Man matar in talet n som en String
		n = Integer.parseInt(input);
		//konverterar n till integer
		if (n < 0) //kollar om n är mindre än 0, och avslutar programmet om den är det
		{
			JOptionPane.showMessageDialog(null, "Ditt tal kan inte vara mindre än 0");
			System.exit(0);
		}
		input = JOptionPane.showInputDialog("Mata in k");
		//Man matar in talet k som en String
		k = Integer.parseInt(input);
		//konverterar k till integer
		if (k < 0) //kollar om k är mindre än 0 och avslutar programmet om den är det
		{
			JOptionPane.showMessageDialog(null, "Ditt tal kan inte vara mindre än 0");
			System.exit(0);
		}
		if (n < k)//Kollar om n är minder än k, då programmet inte fungerar om det är så
		{
			JOptionPane.showMessageDialog(null, "K kan inte vara större än n");
			System.exit(0);
		}
		svar = Binomialberakning.binomialkoeff(n, k);
		//Får svaret av uträkningen
		JOptionPane.showMessageDialog(null, "Svaret av vad du matade in blir: " + svar);
		//Ger ut svaret
		System.exit(0); //Avslutar programmet
	}
}
