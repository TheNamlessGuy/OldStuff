package nam.namless.KryoSlickGame.client;

import java.io.IOException;

import nam.namless.KryoSlickGame.Core.ChatBox;
import nam.namless.KryoSlickGame.Core.PlayerBox;
import nam.namless.KryoSlickGame.network.Network;
import nam.namless.KryoSlickGame.network.Network.AnswerSendName;
import nam.namless.KryoSlickGame.network.Network.ChatMessage;
import nam.namless.KryoSlickGame.network.Network.UpdateNames;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class TestClient {
	private Client client;
	private String name;
	public TestClient (final PlayerBox playerBox, final ChatBox chatBox) throws IOException {
		client = new Client();
		client.start();
		Network.register(client);
		client.addListener(new Listener() {
			public void connected (Connection c) {
				AnswerSendName answerSendName = new AnswerSendName();
				answerSendName.name = name;
				client.sendTCP(answerSendName);
			}
			public void recieved (Connection c, Object obj) {
				if (obj instanceof UpdateNames) {
					UpdateNames updateNames = (UpdateNames)obj;
					playerBox.updatePlayers(updateNames.playerNames);
					return;
				}
				if (obj instanceof ChatMessage) {
					ChatMessage chatMessage = (ChatMessage)obj;
					chatBox.addMessage(chatMessage.message);
					return;
				}
			}
			public void disconnected (Connection c) {
				
			}
		});
	}
	public void setName(String name){
		this.name = name;
	}
	public void connect(String host, int port) throws IOException{
		client.connect(6000, host, port);
	}
	public void sendMessage(String message){
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.message = message;
		client.sendTCP(chatMessage);
	}
}
