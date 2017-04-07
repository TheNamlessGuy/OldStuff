import javax.swing.*;
public class HusVarde {
	public static void main(String[] args) {
		String Str;
		int husvarde1;
		int eget1;
		int eget2;
		double hyra1;
		double rent1;
		double manadskostnad1;
		Str=JOptionPane.showInputDialog("Mata in värdet på huset");
		husvarde1=Integer.parseInt(Str);
		Str=JOptionPane.showInputDialog("Mata in hur mycket du betalar på en gång");
		eget1=Integer.parseInt(Str);
		eget2 = HusVardeCalc.egetCheck(eget1, husvarde1);
		if (eget1 < eget2 || eget1 > husvarde1)
		{
			JOptionPane.showMessageDialog(null, "Din förbetalning är fel!");
			System.exit(0);
		}
		Str=JOptionPane.showInputDialog("Mata in hyran per månad");
		hyra1 = Double.parseDouble(Str);
		Str=JOptionPane.showInputDialog("Mata in räntan");
		rent1 = Double.parseDouble(Str);
		rent1 = HusVardeCalc.rentCalc(rent1);
		manadskostnad1 = HusVardeCalc.ManadsKostnadCalc(husvarde1, eget1, hyra1, rent1);
		JOptionPane.showMessageDialog(null, "Du betalar " + manadskostnad1 + " kr per månad!");
		System.exit(0);
	}

}
