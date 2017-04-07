package nam.namless.GameName.Client.Listeners;

import javax.swing.JOptionPane;

import nam.namless.GameName.Client.Play;
import nam.namless.GameName.Client.Network.Network.AnswerSendPassword;
import nam.namless.GameName.Client.Network.Network.RequestSendPassword;
import nam.namless.GameName.Client.Network.Network.ServerFull;
import nam.namless.GameName.Client.Network.Network.WrongSendPassword;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientListener extends Listener{
	public void received(Connection con, Object obj){
		if (obj instanceof ServerFull){
			
		}
		if (obj instanceof RequestSendPassword){
			AnswerSendPassword asp = new AnswerSendPassword();
			asp.passwordInput = JOptionPane.showInputDialog("What is the password?");
			Play.client.sendTCP(asp);
		}
		if (obj instanceof WrongSendPassword){
			AnswerSendPassword asp = new AnswerSendPassword();
			asp.passwordInput = JOptionPane.showInputDialog("Wrong password!\nTry again");
			Play.client.sendTCP(asp);
		}
	}
}
