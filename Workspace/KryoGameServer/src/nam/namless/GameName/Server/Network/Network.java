package nam.namless.GameName.Server.Network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public static void register(EndPoint endPoint){
		Kryo kryo = endPoint.getKryo();
		kryo.register(LayDownTile.class);
		kryo.register(RequestSendPassword.class);
		kryo.register(AnswerSendPassword.class);
		kryo.register(WrongSendPassword.class);
		kryo.register(ServerFull.class);
		kryo.register(ChatMessage.class);
	}
	public static class LayDownTile{}
	public static class RequestSendPassword{}
	public static class AnswerSendPassword{public String passwordInput;}
	public static class WrongSendPassword{}
	public static class ServerFull{}
	public static class ChatMessage{public String message = "";}
}
