package nam.namless.KryoSlickGame.network;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
	public static final int port = 54555;
	public static void register(EndPoint endPoint) {
		Kryo kryo = endPoint.getKryo();
		kryo.register(AnswerSendName.class);
		kryo.register(ChatMessage.class);
	}
	public static class AnswerSendName{public String name;}
	public static class ChatMessage{public String message;}
	public static class UpdateNames{public String[] playerNames;}
}
