public class HusVardeCalc {
	public static int egetCheck(int eget3, int husvarde2) {
		eget3 = husvarde2 / 100;
		eget3 = eget3 * 3;
		return eget3;
	}
	public static double rentCalc(double rent2)
	{
		rent2 = rent2 / 100;
		return (rent2);
	}
	public static double ManadsKostnadCalc(int husvarde2, int eget3, double hyra2, double rent2){
		double manadskostnad2;
		manadskostnad2 = husvarde2 - eget3;
		manadskostnad2 = manadskostnad2 + (manadskostnad2 * rent2);
		manadskostnad2 = manadskostnad2 / 12;
		manadskostnad2 = manadskostnad2 + hyra2;
		return (manadskostnad2);
	}
}
