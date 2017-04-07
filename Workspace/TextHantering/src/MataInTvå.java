import javax.swing.*;
public class MataInTvå {
	public static void main(String[] args) {
		String s;
		int x1;
		int y1;
		int z1;
		s=JOptionPane.showInputDialog("Mata in x");
		x1=Integer.parseInt(s);
		s=JOptionPane.showInputDialog("Mata in y");
		y1=Integer.parseInt(s);
		/*z=x1+y1;*/
		z1 = MataInTvåUträckning.Sum(x1, y1);
		JOptionPane.showMessageDialog(null, "x + y = " + z1);
		System.exit(0);
	}

}
