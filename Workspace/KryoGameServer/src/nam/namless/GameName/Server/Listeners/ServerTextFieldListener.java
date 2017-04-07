package nam.namless.GameName.Server.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import nam.namless.GameName.Server.PACKETSENDER;
import nam.namless.GameName.Server.Reader;
import nam.namless.GameName.Server.ServerMain;

public class ServerTextFieldListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JTextField textField = (JTextField)e.getSource();
		String input = textField.getText();
		if (input.startsWith("/")){
			input = input.substring(1, input.length());
			String[] inputSplit = input.split(" ");
			if (inputSplit[0].equalsIgnoreCase("sendPacket") && inputSplit.length == 3){
				if (inputSplit[1].length() == 1 && inputSplit[2].length() == 1){
					try{
						int numberOfClients = Integer.parseInt(inputSplit[1]);
						int numberOfPackages = Integer.parseInt(inputSplit[2]);
						new PACKETSENDER(numberOfClients, numberOfPackages);
					}catch(Exception exc){
						invalidInput(textField);
					}
				}else{
					invalidInput(textField);
				}
			}else if(inputSplit[0].equalsIgnoreCase("changeNameByName") && inputSplit.length == 3){
				try {
					ServerMain.addMessage(Reader.changeNameByName(inputSplit[1], inputSplit[2]));
				} catch (IOException e1) {}
			}else if(inputSplit[0].equalsIgnoreCase("changeNameByIP") && inputSplit.length == 3){
				try {
					ServerMain.addMessage(Reader.changeNameByIP(inputSplit[1], inputSplit[2]));
				} catch (IOException e1) {}
			}else if(inputSplit[0].equalsIgnoreCase("changeIPByIP") && inputSplit.length == 3){
				try {
					ServerMain.addMessage(Reader.changeIPByIP(inputSplit[1], inputSplit[2]));
				} catch (IOException e1) {}
			}else if(inputSplit[0].equalsIgnoreCase("changeIPByName") && inputSplit.length == 3){
				try {
					ServerMain.addMessage(Reader.changeIPByName(inputSplit[1], inputSplit[2]));
				} catch (IOException e1) {}
			}else{
				invalidInput(textField);
			}
		}else{
			ServerMain.sendServerMessage(input);
		}
		textField.setText("");
	}
	public static void invalidInput(JTextField t){
		ServerMain.addMessage("ERROR: Input invalid");
	}
}
