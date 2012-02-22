package framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * reads the configurations
 * 
 * @author sholvar
 *
 */
public class CSVFileManager {

	/**
	 * how many values each line of CSV can have. Default there are 3 for a
	 * TokenType Object: name, regex, description
	 */
	public static final int VALUES_PER_LINE = 3;
	
	/**
	 * which character creates a comment
	 */
	public static final String COMMENT_MARK = "#";

	private CSVObject csv = new CSVObject(VALUES_PER_LINE);;

	/**
	 * opens a config file and reads it's values
	 * @param fileName - the javacompatible File name string
	 * @return itself, for further usage
	 * @throws IOException
	 */
	public CSVFileManager readFile(String fileName) throws IOException {

		BufferedReader buff = new BufferedReader(new InputStreamReader(
				new FileInputStream(new File(fileName))));
		csv = new CSVObject(VALUES_PER_LINE);
		for (String line = buff.readLine(); line != null; line = buff
				.readLine()) {
			//get rid of comment lines
			if(line.trim().startsWith(COMMENT_MARK)){
				continue;
			}
			String[] values = line.split(" *\" *, *\"?", VALUES_PER_LINE);
			csv.addLine();
			for (String s : values) {
				csv.addValueToLine(s.replaceAll("[^\\\\]\"", ""));
			}
		}
		System.out.println("CSVFileManager.readFile -> " + csv + ";");
		return this;
	}

	public CSVObject getCSVObject() {
		return this.csv;
	}

	public String toString() {
		return this.csv.toString();
	}

	/**
	 * demonstration and test
	 */
	public static void main(String[] args) throws IOException {
		CSVFileManager mgr = new CSVFileManager();
		System.out.println(mgr.readFile("res/types.txt"));
	}

}
