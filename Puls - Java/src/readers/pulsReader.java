package readers;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import parsers.pulsParser;

import framework.Token;

import xmlClass.*;

public class pulsReader {
	private String inputFilePath;
	private List<Event> events;
	private List<Day> days;
	private List<Token> tokenList;
	
	public pulsReader(String filePath) {
		inputFilePath = filePath;
		tokenList= new pulsParser(filePath).getObjects();
		events = new ArrayList<Event>();
		days = new ArrayList<Day>();
	}
	
	public Shedule getShedule(){
		Shedule shedule = new Shedule();
		
		return shedule;
	}
	
	// TODO getDay
	//TODO getEvent - alle Event auslesen, wenn doppelt/gleiche events, wegschmei�en
	//TODO getEvent - Funktion schaffen, die nur nach der heutigen Woche ausw�hlt

	public List<Event> getEvent(){
		List<Event> events = new ArrayList<Event>();
		for (Token tkn : tokenList){
			//TODO KursTitel - Kurstitel und URL der noch ausgeschnitten werden muss
			if (tkn.type.name.contains("KursTitel")){
				System.out.println(tkn.content);
			}
			//TODO Notiz - Anfangs + Endzeit, Häufigkeit der Termine
			//TODO Note - Einrichtung und SWS
		}
		return events;
	}
	
	public static void main(String[] args) {
		new pulsReader("https://puls.uni-potsdam.de/qisserver/rds;jsessionid=B38BB6B89631738AE3B815E8E75629D7.node11?state=wplan&value=43_2011&act=show&pool=&show=plan&P.vx=lang&P.subc=plan&week=51_2011").getEvent();
	}
}
