package hangman;

public class Get {
	public static String output(char[] c, char c1, boolean[] guessed) {
		String s = "";
		int index = 0;
		for(char c2: c){
			if(c2 == ' ' || c2 == 39 || c2 == '!' || c2 == '?'){
				s += c2 + " ";
			}else if(Character.toLowerCase(c2) == Character.toLowerCase(c1)){
				s += c2;
				guessed[index] = true;
			}else if(guessed[index] == true){
				s += c2;
			}else{
				s += "_ ";
			}
			index++;
		}
		return s;
	}
	public static boolean wins(boolean[] guessed, char[] c){
		boolean success = true;
		int index = 0;
		for(boolean b: guessed){
			if (c[index] == ' ' || c[index] == '!' || c[index] == 39 || c[index] == '?'){
				
			}else if (b == false){
				success = false;
				break;
			}
			index++;
		}
		return success;
	}
	public static String theHangMan(int guessesLeft){
		String s = "<html>";
		switch(guessesLeft){
		case 9: s += "<br><br><br><br><br><br><br><br>";
				break;
		case 8: s += "<br><br><br><br><br><br><br>######";
				break;
		case 7: s += "<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 6: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 5: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 4: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 3: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 2: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|<br>&nbsp&nbsp|<br>######";
				break;
		case 1: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>######";
				break;
		case 0: s += "&nbsp&nbsp ______<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp O<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |<br>&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp |&nbsp |<br>######";
				break;
		}
		s += "</html>";
		return s;
	}
	public static boolean contains(String guessedLetters, char c1){
		boolean b = false;
		char[] c = guessedLetters.toCharArray();
		for (char c2: c){
			if (c2 == c1){
				b = true;
				break;
			}
		}
		return b;
	}
	public static String c(char[] c){
		String s = "";
		for (char c1: c){
			s += c1;
		}
		return s;
	}
}