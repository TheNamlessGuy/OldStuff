package __TESTING;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class WriteUTF8File {
	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
		
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("output.txt"), "UTF-8"));
			out.write("( ͡° ͜ʖ ͡°)");
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("output.txt"), "UTF-8"));
			System.out.println(in.readLine());
			in.close();
			
			Desktop.getDesktop().open(new File("."));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
