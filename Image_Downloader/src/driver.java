
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class driver {
	
	
	public static void main (String args[]) throws IOException {
		check_directory();
		
		Scanner sc = new Scanner(System.in);
		String address = get_url(sc); 
		sc.close();
		
		find_images(address);
	}
	
	/*
	 * Simply checks if a directory exists or not
	 * If so return to the main 
	 * If not make the directory
	 */
	public static void check_directory () {
		File directory = new File("images");
		
		if (directory.exists()) return;
		
		directory.mkdir();
	}
	
	/* 
	 * 
	 */
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
	public static void find_images (String address) throws IOException {
		URLConnection connection = make_connection(address);
		
		InputStream stream = connection.getInputStream();
		InputStreamReader stream_reader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(stream_reader);
		
		
	}
}
