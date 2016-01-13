
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
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
	
	public static void main (String args[]) throws IOException, BadLocationException {
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
		File directory = new File(directory_name);
		
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
	public static void find_images (String address) throws IOException, BadLocationException {
		URLConnection connection = make_connection(address);
		
		InputStream stream = connection.getInputStream();
		InputStreamReader stream_reader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(stream_reader);
		
		HTMLEditorKit kit = new HTMLEditorKit();
		HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
		kit.read(reader, doc, 0);
		
		for (HTMLDocument.Iterator iterator = doc.getIterator(HTML.Tag.A); iterator.isValid(); iterator.next()) {
			AttributeSet attribute = iterator.getAttributes();
			String image = (String) attribute.getAttribute(HTML.Attribute.HREF);
			
			System.out.print("\n"+image);
			
			if (image != null && (image.endsWith("png") || image.endsWith("jpg") || image.endsWith("jpeg") || image.endsWith("gif"))) {
				System.out.print("\n"+address);
				System.out.print("\n"+image);
				download_image(address, image);
			}
		}
	}
	
	/*
	 * 
	 */
	public static void download_image(String address, String image_source) throws IOException {				
		if (image_source.startsWith("http")) { // also cover https
			address = image_source;
		} else {
			address += image_source;
		}
		
		image_source = image_source.substring(image_source.lastIndexOf("/") +1);
		String file_format = image_source.substring(image_source.lastIndexOf(".") +1);
		
		URL image_url = new URL(address);
		
		BufferedImage image = ImageIO.read(image_url);
		
		File directory = new File(directory_name + "/" + image_source);
		ImageIO.write(image, file_format, directory);
	}
}
