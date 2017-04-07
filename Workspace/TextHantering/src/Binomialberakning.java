public class Binomialberakning {
	public static int fak (int n1) { //Räknar ut fakultet
		int ans = 1; //Håller svaret till beräkningen i den här klassen
		while (n1 > 0) //Fortsätter programmet tills talet som ska fakulteras blir 0
		{
		ans = ans * n1; //Räknar ut svaret, ett multiplikationssteg i taget
		n1 = n1 - 1;//Räknar ut nästa tal den ska mata in, och räknar ner till programmets avslutning
		}
		return ans;//Returnerar svaret
	}
	public static int nkfak (int n1, int k1) { //Räknar ut (n-k) fakultet
		int ans = 1; //Håller svaret till metoden
		int ans1 = 1; //Håller svaret till n-k
		ans1 = n1 - k1; //Beräknar n-k
		ans = Binomialberakning.fak(ans1); //Beräknar fakulteten av n-k
		return ans;//Returnerar svaret
	}
	public static int binomialkoeff (int n1, int k1){ //Räknar ut binomialsatsen
		int ans = 1; //Håller svaret till metoden
		int kfak1 = 1; //Håller vad k fakultet är
		int nfak1 = 1; //Håller vad n fakultet är
		int nkfak1 = 1; //Håller vad n-k fakultet är
		nfak1 = Binomialberakning.fak(n1); //Beräknar n fakultet
		kfak1 = Binomialberakning.fak(k1); //Beräknar k fakultet
		nkfak1 = Binomialberakning.nkfak(n1, k1); //Beräknar n-k fakultet
		ans = nkfak1 * kfak1; //Beräknar beräkningen under delat-med-sträcket i binomialsatsen
		ans = nfak1/ans; //Beräknar hela binomialsatsen
		return ans; //Returnerar svaret
	}
}
