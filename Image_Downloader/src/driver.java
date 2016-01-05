
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class driver {
	
	
	public static void main (String args[]) {
		check_directory();
		
		Scanner sc = new Scanner(System.in);
		String address = get_url(sc); 
		sc.close();
		
		find_images(address);
	}
	
	/* */
	public static void check_directory () {
		File directory = new File("images");
		
		if (directory.exists()) return;
		
		directory.mkdir();
	}
	
	/* */
	public static String get_url (Scanner sc) {
		System.out.print("\nThe URL needs a 'http://' or 'https://' in the front.");
		String result;
		
		while (true) {
			System.out.print("\nEnter the desired URL: ");
			result = sc.nextLine();
			
			try {
				URL url = new URL(result);
				URLConnection connection = url.openConnection();
				connection.connect();
				return result;
			}
			catch (MalformedURLException e) {
				System.out.print("\nError with the URL try again.");
			} 
			catch (IOException e) { 
				System.out.print("\nError with the URL try again.");
			}
		}	
	}
	
	/* */
	public static void find_images (String address) throws IOException {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		connection.connect();
		// add input stream
	}
}
