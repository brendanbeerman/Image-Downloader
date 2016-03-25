/**
TO DO

need to check if a new filename is taken
find the image tags on a web page, and store them
 
 */


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class driver {
	
	public static String main_directory = "images";
	public static String temp_directory = "temp";
	
	public static void main (String args[]) throws IOException {
		//String word = "http://s.4cdn.org/image/fp/atlantis_longcat2.png";
		String word = "http://=www.4chan.org/";
		
		checkDirectory(main_directory);
		checkDirectory(temp_directory);
		
		//Scanner sc = new Scanner(System.in);
		//String address = get_url(sc); 
		//sc.close();
		
		findImageURLs(word);
		//downloadImage(word);
	}
	
	/*
	 * Checks if a directory exists or not
	 * If so return to the main 
	 * If not make the directory
	 */
	public static void checkDirectory (String dir) {
		File directory = new File(dir);
		
		if (directory.exists()) return;
		
		directory.mkdir();		
	}
	
	/*
	 * Takes in a scanner
	 * Asks the user for a web site that they want to download images from
	 * then uses the testConnection function to see if it is valid
	 * returns a valid URL as a string
	 */
	public static String getURL (Scanner sc) {
		System.out.print("\nThe URL needs a 'http://' or 'https://' in the front.");
		String result;
		
		while (true) {
			System.out.print("\nEnter the desired URL: ");
			result = sc.nextLine();
			
			if (testConnection(result)) {
				return result;
			}
		}	
	}
	
	/* 
	 * Takes a string
	 * uses the string to test if a URL is valid
	 * if it works, returns true
	 * else false
	 */
	public static boolean testConnection (String s) {
		try {
			URL url = new URL(s);
			URLConnection connection = url.openConnection();
			connection.connect();
			return true;
		}
		catch (MalformedURLException e) {
			System.out.print("\nError with the URL try again.");
			return false;
		} 
		catch (IOException e) { 
			System.out.print("\nError with the URL try again.");
			return false;
		}
	}
	
	/* 
	 * 
	 */
	public static void findImageURLs (String address) throws MalformedURLException {
		URL url = new URL(address);
	}
	
	/*
	 * Takes in a string, that is a URL for an image
	 * Reads from the input stream 
	 * Then saves to the output stream, which is a pathway to a file
	 */
	public static void downloadImage(String address) throws IOException {				
		URL url = new URL(address);
		String image_name = url.getFile();
		String destination_path = "./Images/" +image_name.substring(image_name.lastIndexOf("/"));
		
		InputStream input = url.openStream();
		OutputStream output = new FileOutputStream(destination_path);
		
		int length;
		byte []b = new byte[2048];
		
		while ((length = input.read(b)) != -1) output.write(b, 0, length);
		
		input.close();
		output.close();
	}
}
