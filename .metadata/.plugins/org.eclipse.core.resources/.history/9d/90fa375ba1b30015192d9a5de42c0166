
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
		URL url = get_url(sc); 
		sc.close();
		
		System.out.print("worked");
	}
	
	public static void check_directory () {
		File directory = new File("images");
		
		if (directory.exists()) return;
		
		directory.mkdir();
	}
	
	public static URL get_url (Scanner sc) {
		System.out.print("\nThe URL needs a 'http://' in the front.");
		String result;
		
		while (true) {
			System.out.print("\nEnter the desired URL: ");
			result = sc.nextLine();
			
			try {
				URL url = new URL(result);
				URLConnection connection = url.openConnection();
				connection.connect();
				return url;
			}
			catch (MalformedURLException e) {
				System.out.print("\nError with the URL try again.");
			} 
			catch (IOException e) { 
				System.out.print("\nError with the URL try again.");
			}
		}	
	}
}
