package nam.namless.GameName.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import nam.namless.GameName.Server.Network.Network;

import com.esotericsoftware.kryonet.Connection;

public class Reader {
	public static int port = 54555;
	public static int maxPlayers = 5;
	public static String password = "";
	static String path = Network.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	public static int[][] world;
	public static void readSettings() throws IOException{
		path = path.substring(0, path.length()-4);
		File file = new File(path + "//settings.txt");
		if (file.exists()){
			String readLine;
			String[] readLineSplit;
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((readLine = br.readLine()) != null){
				readLineSplit = readLine.split(":");
				switch(readLineSplit[0]){
				case "PORT":
					try{
						port = Integer.parseInt(readLineSplit[1]);
					}catch(Exception e){
						port = 54555;
					}
					break;
				case "MAX PLAYERS":
					try{
						maxPlayers = Integer.parseInt(readLineSplit[1]);
					}catch(Exception e){
						maxPlayers = 5;
					}
					break;
				case "PASSWORD":
					if (readLineSplit.length != 1){
						password = readLineSplit[1];
					}
					break;
				default:
					break;
				}
			}
			br.close();
		}else{
			PrintWriter w = new PrintWriter(path + "//settings.txt", "UTF-8");
			w.println("PORT:54555");
			w.println("MAX PLAYERS:5");
			w.println("PASSWORD:");
			w.close();
		}
	}
	public static void readWorld() throws IOException{
		File file = new File(path + "//world.txt");
		int[][] rWorld = null;
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = "";
			String[] sSplit;
			int x = 0; 
			int y = 0;
			boolean boolX = true;
			while ((s = br.readLine()) != null){
				sSplit = s.split(":");
				if (sSplit[0].equals("SIZE X")){
					try{
						x = Integer.parseInt(sSplit[1]);
					}catch(Exception e){
						boolX = false;
					}
				}else if(sSplit[0].equals("SIZE Y")){
					try{
						y = Integer.parseInt(sSplit[1]);
						if (boolX){
							rWorld = new int[x][y];
						}
					}catch(Exception e){}
				}else{
					rWorld[Integer.parseInt(sSplit[1])][Integer.parseInt(sSplit[2])] = Integer.parseInt(sSplit[0]);
				}
			}
			br.close();
			world = rWorld;
		}else{
			int[][] i = {{0, 0}, {0, 0}};
			PrintWriter w = new PrintWriter(file, "UTF-8");
			w.println("SIZE X:"+i.length);
			w.println("SIZE Y:"+i[0].length);
			for (int i1 = 0; i1 < i.length; i1++){
				for (int i2 = 0; i2 < i[0].length; i2++){
					w.println(i[i1][i2] + ":" + i1 + ":" + i2);
				}
			}
			w.close();
		}
	}
	public static String getName(Connection c) throws IOException{
		File file = new File(path + "//players.txt");
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<String> previousPlayers = new ArrayList<String>();
			String previousPlayer;
			while ((previousPlayer = br.readLine()) != null){
				previousPlayers.add(previousPlayer);
			}
			br.close();
			for (int i = 0; i < previousPlayers.size(); i++){
				String[] s = previousPlayers.get(i).split(":");
				if (s[0].equals(c.getRemoteAddressTCP().toString().substring(0, c.getRemoteAddressTCP().toString().indexOf(':')))){
					return s[1];
				}
			}
			String newName = "User"+ServerMain.server.getConnections().length;
			previousPlayers.add(c.getRemoteAddressTCP().toString().substring(0, c.getRemoteAddressTCP().toString().indexOf(':'))+":" + newName);
			PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
			for (int i = 0; i < previousPlayers.size(); i++){
				if (previousPlayers.get(i) != null){
					w.println(previousPlayers.get(i));
				}
			}
			w.close();
			return newName;
		}else{
			PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
			w.println();
			w.close();
			return "FileUnexistant";
		}
	}
	public static String changeNameByName(String oldName, String newName) throws IOException{
		ArrayList<String> entries = new ArrayList<String>();
		String entry;
		File file = new File(path + "//players.txt");
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((entry = br.readLine()) != null){
				entries.add(entry);
			}
			br.close();
			boolean found = false;
			for (int i = 0; i < entries.size(); i++){
				String[] entrySplit = entries.get(i).split(":");
				if (entrySplit[1].equals(oldName)){
					entries.remove(i);
					entries.add(i, entrySplit[0] + ":" + newName);
					found = true;
				}
			}
			if (found){
				PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
				for (int i = 0; i < entries.size(); i++){
					w.println(entries.get(i));
				}
				w.close();
				return "Name change successful";
			}else{
				return "ERROR: Name not in database";
			}
		}else{
			return "ERROR: File not present";
		}
	}
	public static String changeIPByIP(String oldIP, String newIP) throws IOException{
		oldIP = "/" + oldIP;
		newIP = "/" + newIP;
		ArrayList<String> entries = new ArrayList<String>();
		String entry;
		File file = new File(path + "//players.txt");
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((entry = br.readLine()) != null){
				entries.add(entry);
			}
			br.close();
			boolean found = false;
			for (int i = 0; i < entries.size(); i++){
				String[] entrySplit = entries.get(i).split(":");
				if (entrySplit[0].equals(oldIP)){
					entries.remove(i);
					entries.add(i, newIP + ":" + entrySplit[1]);
					found = true;
				}
			}
			if (found){
				PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
				for (int i = 0; i < entries.size(); i++){
					w.println(entries.get(i));
				}
				w.close();
				return "IP change successful";
			}else{
				return "ERROR: IP not in database";
			}
		}else{
			return "ERROR: File not present";
		}
	}
	public static String changeIPByName(String name, String newIP) throws IOException{
		newIP = "/" + newIP;
		ArrayList<String> entries = new ArrayList<String>();
		String entry;
		File file = new File(path + "//players.txt");
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((entry = br.readLine()) != null){
				entries.add(entry);
			}
			br.close();
			boolean found = false;
			for (int i = 0; i < entries.size(); i++){
				String[] entrySplit = entries.get(i).split(":");
				if (entrySplit[1].equals(name)){
					entries.remove(i);
					entries.add(i, newIP + ":" + entrySplit[1]);
					found = true;
				}
			}
			if (found){
				PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
				for (int i = 0; i < entries.size(); i++){
					w.println(entries.get(i));
				}
				w.close();
				return "IP change successful";
			}else{
				return "ERROR: IP or name not in database";
			}
		}else{
			return "ERROR: File not present";
		}
	}
	public static String changeNameByIP(String IP, String newName) throws IOException{
		IP = "/" + IP;
		ArrayList<String> entries = new ArrayList<String>();
		String entry;
		File file = new File(path + "//players.txt");
		if (file.exists()){
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((entry = br.readLine()) != null){
				entries.add(entry);
			}
			br.close();
			boolean found = false;
			for (int i = 0; i < entries.size(); i++){
				String[] entrySplit = entries.get(i).split(":");
				if (entrySplit[0].equals(IP)){
					entries.remove(i);
					entries.add(i, entrySplit[0] + ":" + newName);
					found = true;
				}
			}
			if (found){
				PrintWriter w = new PrintWriter(path + "//players.txt", "UTF-8");
				for (int i = 0; i < entries.size(); i++){
					w.println(entries.get(i));
				}
				w.close();
				return "Name change successful";
			}else{
				return "ERROR: Name not in database";
			}
		}else{
			return "ERROR: File not present";
		}
	}
}
