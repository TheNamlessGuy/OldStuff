package nam.namless.GameName.Server;

import java.io.IOException;

import nam.namless.GameName.Server.Network.Network;
import nam.namless.GameName.Server.Network.Network.LayDownTile;

import com.esotericsoftware.kryonet.Client;

public class PACKETSENDER {
	public PACKETSENDER(int NOclients, int packets) throws IOException{
		Client[] clients = new Client[NOclients];
		for (int i = 0; i < NOclients; i++){
			clients[i] = new Client();
			clients[i].start();
			Network.register(clients[i]);
			clients[i].connect(5000, "localhost", Reader.port);
			for (int j = 0; j < packets; j++){
				clients[i].sendTCP(new LayDownTile());
			}
		}
		for (int i = 0; i < NOclients; i++){
			clients[i].stop();
		}
	}
}
