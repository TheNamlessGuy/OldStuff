package namless.slickRPG.core;

import org.newdawn.slick.Input;

public class TextInput {
	public static String check(Input in, String s){
		if (in.isKeyPressed(Input.KEY_0)){
			s += '0';
		}else if (in.isKeyPressed(Input.KEY_1)){
			s += '1';
		}else if (in.isKeyPressed(Input.KEY_2)){
			s += '2';
		}else if (in.isKeyPressed(Input.KEY_3)){
			s += '3';
		}else if (in.isKeyPressed(Input.KEY_4)){
			s += '4';
		}else if (in.isKeyPressed(Input.KEY_5)){
			s += '5';
		}else if (in.isKeyPressed(Input.KEY_6)){
			s += '6';
		}else if (in.isKeyPressed(Input.KEY_7)){
			s += '7';
		}else if (in.isKeyPressed(Input.KEY_8)){
			s += '8';
		}else if (in.isKeyPressed(Input.KEY_9)){
			s += '9';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD0)){
			s += '0';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD1)){
			s += '1';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD2)){
			s += '2';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD3)){
			s += '3';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD4)){
			s += '4';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD5)){
			s += '5';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD6)){
			s += '6';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD7)){
			s += '7';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD8)){
			s += '8';
		}else if(in.isKeyPressed(Input.KEY_NUMPAD9)){
			s += '9';
		}else if (in.isKeyPressed(Input.KEY_A)){
			s += 'A';
		}else if(in.isKeyPressed(Input.KEY_B)){
			s += 'B';
		}else if(in.isKeyPressed(Input.KEY_C)){
			s += 'C';
		}else if(in.isKeyPressed(Input.KEY_D)){
			s += 'D';
		}else if(in.isKeyPressed(Input.KEY_E)){
			s += 'E';
		}else if(in.isKeyPressed(Input.KEY_F)){
			s += 'F';
		}else if(in.isKeyPressed(Input.KEY_G)){
			s += 'G';
		}else if(in.isKeyPressed(Input.KEY_H)){
			s += 'H';
		}else if(in.isKeyPressed(Input.KEY_I)){
			s += 'I';
		}else if(in.isKeyPressed(Input.KEY_J)){
			s += 'J';
		}else if(in.isKeyPressed(Input.KEY_K)){
			s += 'K';
		}else if(in.isKeyPressed(Input.KEY_L)){
			s += 'L';
		}else if(in.isKeyPressed(Input.KEY_M)){
			s += 'M';
		}else if(in.isKeyPressed(Input.KEY_N)){
			s += 'N';
		}else if(in.isKeyPressed(Input.KEY_O)){
			s += 'O';
		}else if(in.isKeyPressed(Input.KEY_P)){
			s += 'P';
		}else if(in.isKeyPressed(Input.KEY_Q)){
			s += 'Q';
		}else if(in.isKeyPressed(Input.KEY_R)){
			s += 'R';
		}else if(in.isKeyPressed(Input.KEY_S)){
			s += 'S';
		}else if(in.isKeyPressed(Input.KEY_T)){
			s += 'T';
		}else if(in.isKeyPressed(Input.KEY_U)){
			s += 'U';
		}else if(in.isKeyPressed(Input.KEY_V)){
			s += 'V';
		}else if(in.isKeyPressed(Input.KEY_W)){
			s += 'W';
		}else if(in.isKeyPressed(Input.KEY_X)){
			s += 'X';
		}else if(in.isKeyPressed(Input.KEY_Y)){
			s += 'Y';
		}else if(in.isKeyPressed(Input.KEY_Z)){
			s += 'Z';
		}else if(in.isKeyPressed(Input.KEY_SPACE)){
			s += ' ';
		}else if(in.isKeyPressed(Input.KEY_PERIOD)){
			s += '.';
		}
		return s;
	}
}
