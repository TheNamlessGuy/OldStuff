import java.awt.Toolkit;
public class ArrayTest {
	public static void main(String[] args) {
		int[] arrayTest = {10, 20, 30, 40};
		//System.out.println(arrayTest[0]);
		int sum=0;
		for (int counter = 0; counter < arrayTest.length; counter++)
		{
			sum = sum + arrayTest[counter];
		}
		if (sum > 90)
		{
			Toolkit.getDefaultToolkit().beep();
		}
		System.exit(0);
	}

}
