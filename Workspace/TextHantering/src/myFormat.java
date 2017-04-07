import java.text.*;
public class myFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d = 1.23456789;
		DecimalFormat dF = new DecimalFormat ("#.##");		
		System.out.print(dF.format(d));
		System.exit(0);
	}

}
