package nam.namless.GameName.Server.Listeners;

import java.io.IOException;

import nam.namless.GameName.Server.Reader;
import nam.namless.GameName.Server.ServerMain;
import nam.namless.GameName.Server.Network.Network.AnswerSendPassword;
import nam.namless.GameName.Server.Network.Network.LayDownTile;
import nam.namless.GameName.Server.Network.Network.RequestSendPassword;
import nam.namless.GameName.Server.Network.Network.ServerFull;
import nam.namless.GameName.Server.Network.Network.WrongSendPassword;
import nam.namless.GameName.Server.Player.Player;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ServerListener extends Listener{
	public void received(Connection con, Object obj){
		Player c = (Player)con;
		if (obj instanceof LayDownTile){
			ServerMain.addMessage(c.name + " moves up");
		}
		if (obj instanceof AnswerSendPassword){
			String passwordInput = ((AnswerSendPassword)obj).passwordInput;
			if (passwordInput.equals(Reader.password)){
				if (ServerMain.server.getConnections().length < Reader.maxPlayers){
					c.xLocation = 2;
					c.yLocation = 2;
					try {
						c.name = Reader.getName(con);
					} catch (IOException e) {
						e.printStackTrace();
					}
					ServerMain.sendServerMessage(c.name + " connected");
				}else{
					ServerMain.server.sendToTCP(c.getID(), new ServerFull());
				}
			}else{
				ServerMain.server.sendToTCP(c.getID(), new WrongSendPassword());
			}
		}
	}
	public void connected(Connection con){
		if (ServerMain.server.getConnections().length < Reader.maxPlayers){
			if (!(Reader.password.equals(""))){
				ServerMain.server.sendToTCP(con.getID(), new RequestSendPassword());
			}else{
				Player c = (Player)con;
				c.xLocation = 2;
				c.yLocation = 2;
				try {
					c.name = Reader.getName(con);
				} catch (IOException e) {
					e.printStackTrace();
				}
				ServerMain.sendServerMessage(c.name + " connected");
			}
		}else{
			ServerMain.server.sendToTCP(con.getID(), new ServerFull());
		}
	}
	public void disconnected(Connection con){
		Player c = (Player)con;
		ServerMain.sendServerMessage(c.name + " disconnected");
	}
}
