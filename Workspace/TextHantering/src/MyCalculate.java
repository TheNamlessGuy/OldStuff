import javax.swing.*;
public class MyCalculate {
	public static void main(String[] args) {
		String s, s1;
		int i1, i2;
		
		s1 = JOptionPane.showInputDialog("What would you like to do? (+ or -)");
		if (s1 != "+" || s1 != "-")
		{
			System.out.print("Error");
			System.exit(0);
		}
		s = JOptionPane.showInputDialog("Input x");
		i1 = Integer.parseInt(s);
		s = JOptionPane.showInputDialog("Input y");
		i2 = Integer.parseInt(s);
		if (s1 == "+"){
			i1 = MyAddition.Addition(i1, i2);
		}
		else
		{
			i1 = MyAddition.Subtraction(i1, i2);
		}
		JOptionPane.showMessageDialog(null, "Svaret blir " + i1);
		System.exit(0);
	}
}
