package nam.namless.GameName.Server;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import nam.namless.GameName.Server.Listeners.ServerListener;
import nam.namless.GameName.Server.Listeners.ServerTextFieldListener;
import nam.namless.GameName.Server.Network.Network;
import nam.namless.GameName.Server.Network.Network.ChatMessage;
import nam.namless.GameName.Server.Player.Player;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class ServerMain {
	public static Server server;
	static JList<String> JPanelMessageList = new JList<String>();
	public ServerMain() throws IOException{
		server = new Server(){
			protected Connection newConnection(){
				return new Player();
			}
		};
		Network.register(server);
		Reader.readSettings();
		Reader.readWorld();
		server.addListener(new ServerListener());
		server.bind(Reader.port);
		server.start();
		createFrame();
		addMessage("Server started");
	}
	public static void main(String[] args) throws IOException{
		Log.set(Log.LEVEL_NONE);
		new ServerMain();
	}
	public static void stopServer(){
		server.stop();
	}
	public static void startServer(){
		server.start();
	}
	@SuppressWarnings("serial")
	public void createFrame(){
		JFrame frame = new JFrame("Server");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.addWindowListener(new WindowAdapter() {
    		public void windowClosed (WindowEvent evt) {
    			server.stop();
    			addMessage("[SERVER] Server closed");
    		}
    	});
    	JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(2,1));
    	final JTextField textField = new JTextField();
    	textField.addActionListener(new ServerTextFieldListener());
    	JPanelMessageList.setModel(new DefaultListModel<String>());
    	JPanelMessageList.setSelectionModel(new DefaultListSelectionModel(){
			public void setSelectionInterval (int index0, int index1) {
			}
    	});
    	panel.add(new JScrollPane(JPanelMessageList));
    	panel.add(textField);
    	frame.add(panel);
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
	}
	public static void addMessage(String message){
		DefaultListModel<String> model = (DefaultListModel<String>)JPanelMessageList.getModel();
		model.addElement(message);
		JPanelMessageList.ensureIndexIsVisible(model.size() - 1);
	}
	public static void sendServerMessage(String message){
		ChatMessage cm = new ChatMessage();
		cm.message = "SERVERADMIN: " + message;
		server.sendToAllTCP(cm);
		addMessage(cm.message);
	}
}