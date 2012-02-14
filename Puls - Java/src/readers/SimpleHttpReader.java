package readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Creates a simple HTTP Connection and returns the String. Not the best solution for very big websites.
 * 
 * @author sholvar
 *
 */
public class SimpleHttpReader {

	/**
	 * takes an url and returns the Response from the Server without Headers
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String readURL(String url) throws MalformedURLException, IOException {
		String txt = "";

		BufferedReader rd = new BufferedReader(new InputStreamReader((new URL(url)).openStream()));

		String line = null;
		int linecount = 0;
	    for(line = rd.readLine(); line != null;line = rd.readLine()){
			txt += line + "\n";	
			linecount++;
		};
		System.out.println("SimpleHttpReader.readUrl() -> (length:" + txt.length() + ", linecount: " + linecount + ")");
		return txt;
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.out.println((new SimpleHttpReader())
				.readURL("http://de.wikipedia.org/wiki/Wikipedia:Hauptseite"));
	}

}
