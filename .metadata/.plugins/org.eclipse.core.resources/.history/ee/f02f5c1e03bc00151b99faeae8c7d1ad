
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class driver {
	
	public static String directory_name = "images";
	
	public static void main (String args[]) {
		check_directory();
		
		Scanner sc = new Scanner(System.in);
		String address = get_url(sc); 
		sc.close();
		
		//find_images(address);
	}
	
	/*
	 * Simply checks if a directory exists or not
	 * If so return to the main 
	 * If not make the directory
	 */
	public static void check_directory () {
		File directory = new File(directory_name);
		
		if (directory.exists()) return;
		
		directory.mkdir();
	}
	
	public static String get_url (Scanner sc) {
		System.out.print("\nThe URL needs a 'http://' or 'https://' in the front.");
		String result;
		
		while (true) {
			System.out.print("\nEnter the desired URL: ");
			result = sc.nextLine();
			
			if (make_connection(result) != null) {
				return result;
			}
		}	
	}
	
	/* 
	 * 
	 */
	public static URLConnection make_connection (String s) {
		try {
			URL url = new URL(s);
			URLConnection connection = url.openConnection();
			connection.connect();
			return connection;
		}
		catch (MalformedURLException e) {
			System.out.print("\nError with the URL try again.");
			return null;
		} 
		catch (IOException e) { 
			System.out.print("\nError with the URL try again.");
			return null;
		}
	}
	
	/* 
	 * 
	 */
	public static void find_images (String address) {

	}
	
	/*
	 * 
	 */
	public static void download_image() throws IOException {				
		String address = "http://s.4cdn.org/image/fp/atlantis_longcat2.png";
		try {
			URL url = new URL(address);
			InputStream input = new BufferedInputStream(url.openStream()); 
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			while (input.read(buffer) != -1) {
				
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
	}
}
