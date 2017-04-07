import java.util.Scanner;
public class MyCalculateConsole {
	public static void main(String[] args) {
		int i1, i2;
		String s;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("What do you want to do? (+ or -)\n");
		s = scanner.nextLine();
		if (s.equals("+") || s.equals("-"))
		{
		System.out.print ("Input x:\n");
		i1 = scanner.nextInt();
		System.out.print ("Input y:\n");
		i2 = scanner.nextInt();
		System.out.print("Answer:\n");
		if (s.equals("+")){
			i1 = MyAddition.Addition(i1, i2);
		}
		else {
			i1 = MyAddition.Subtraction(i1, i2);
		}
		System.out.print(i1);
		scanner.close();
		System.exit(0);
		}
		else 
		{
			System.out.print("Ellol");
			scanner.close();
			System.exit(0);
		}
	}
}
