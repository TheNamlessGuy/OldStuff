package nam.namless.KryoSlickGame.server;

import java.io.IOException;
import java.util.ArrayList;

import nam.namless.KryoSlickGame.network.Network;
import nam.namless.KryoSlickGame.network.Network.AnswerSendName;
import nam.namless.KryoSlickGame.network.Network.ChatMessage;
import nam.namless.KryoSlickGame.network.Network.UpdateNames;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class ServerTest {
	Server server;
		public ServerTest() throws IOException {
			server = new Server() {
				protected Connection newConnection() {
					return new Player();
				}
			};
			Network.register(server);
			server.addListener(new Listener() {
				public void recieved (Connection c, Object obj) {
					Player player = (Player)c;
					if (obj instanceof AnswerSendName) {
						if (player.name != null) {
							return;
						}
						String name = ((AnswerSendName)obj).name;
						if (name == null){
							return;
						}
						name = name.trim();
						if (name.length() == 0){
							return;
						}
						player.name = name;
						ChatMessage message = new ChatMessage();
						message.message = name + " now has a name!";
						server.sendToAllExceptTCP(player.getID(), message);
						updatePlayerList();
						return;
					}
					if (obj instanceof ChatMessage) {
						if (player.name == null) {
							return;
						}
						ChatMessage chatMessage = (ChatMessage)obj;
						String message = chatMessage.message;
						if (message == null){
							return;
						}
						chatMessage.message = Player.name + ": " + message;
						server.sendToAllTCP(chatMessage);
						return;
					}
				}
				public void disconnected(Connection c) {
					Player player = (Player)c;
					if (player.name != null){
						ChatMessage message = new ChatMessage();
						message.message = player.name + " disconnected.";
						server.sendToAllTCP(message);
						updatePlayerList();
					}
				}
			});
			server.bind(Network.port);
			server.start();
		}
	void updatePlayerList() {
		Connection[] connections = server.getConnections();
		ArrayList<String> names = new ArrayList<String>(connections.length);
		for (int i = connections.length - 1; i >=0; i--){
			Player player = (Player)connections[i];
			names.add(player.name);
		}
		UpdateNames updateNames = new UpdateNames();
		updateNames.playerNames = (String[])names.toArray(new String[names.size()]);
		server.sendToAllTCP(updateNames);
	}
	
	public static void main(String[] args) throws IOException{
		new ServerTest();
	}
}
