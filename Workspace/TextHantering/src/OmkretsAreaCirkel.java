import javax.swing.*;
import java.text.DecimalFormat;
public class OmkretsAreaCirkel {
	public static void main(String[] args) {
		String radie;
		double r1;
		double area;
		double omkrets;
		DecimalFormat dF=new DecimalFormat("##.##");
		radie=JOptionPane.showInputDialog("Mata in cirkelns radie");
		r1 = Double.parseDouble(radie);
		area=OmkretsAreaCirkelCalc.area(r1);
		omkrets=OmkretsAreaCirkelCalc.omkrets(r1);
		JOptionPane.showMessageDialog(null, "Radie: " + r1 + "\nArea: " + dF.format(area) + "\nOmkrets: " + dF.format(omkrets));
		System.exit(0);
	}

}
