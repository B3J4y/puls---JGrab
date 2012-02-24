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
	
	public void getObjects(){
		try{
			CSVFileManager csvMgr = new CSVFileManager();
			SimpleHttpReader reader = new SimpleHttpReader();
			SimpleMatchParser parser = new SimpleMatchParser(TokenType.parse(csvMgr
					.readFile("res/pulsSheduleObjects.txt").getCSVObject()));
			SimpleTextWriter writer = new SimpleTextWriter();
			List<Token> result = parser.parse(reader.readURL(filename));
			writer.writeFile(""+result, OUTPUT_FILE);
			for (Token tkn : result){
				if (tkn.type.name.contains("Notiz")){
					System.out.println(tkn.content);
				}
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new pulsParser("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=B38BB6B89631738AE3B815E8E75629D7.node11?state=wplan&value=43_2011&act=show&pool=&show=plan&P.vx=lang&P.subc=plan&week=51_2011");

	}

}
