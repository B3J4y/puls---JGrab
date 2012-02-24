package parsers;

import java.io.File;
import java.util.List;

import readers.SimpleHttpReader;

import writers.SimpleTextWriter;

import framework.*;

public class pulsParser {
	String filename;
	public static final String OUTPUT_FILE = System.getProperty("user.home")
			+ "\\Documents\\results.txt";
	public pulsParser(String filename) {
		this.filename = filename;
		getObjects();
	}
	
	public List<Token> getObjects(){
		try{
			CSVFileManager csvMgr = new CSVFileManager();
			SimpleHttpReader reader = new SimpleHttpReader();
			SimpleMatchParser parser = new SimpleMatchParser(TokenType.parse(csvMgr
					.readFile("res/pulsSheduleObjects.txt").getCSVObject()));
			SimpleTextWriter writer = new SimpleTextWriter();
			List<Token> result = parser.parse(reader.readURL(filename));
			return result;
		} catch(Exception e){
			System.out.println(e.getMessage());
			
		}
		return null;
	}


}
