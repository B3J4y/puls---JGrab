package readers;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xmlClass.*;

public class pulsReader {
	private String inputFilePath;
	private List<Event> events;
	private List<Day> days;
	
	public pulsReader(String filePath) {
		inputFilePath = filePath;
		events = new ArrayList<Event>();
		days = new ArrayList<Day>();
	}
	
	public Shedule getShedule(){
		Shedule shedule = new Shedule();
		
		return shedule;
	}
	
	// TODO getDay
	//TODO getEvent - alle Event auslesen, wenn doppelt/gleiche events, wegschmeiﬂen
	//TODO getEvent - Funktion schaffen, die nur nach der heutigen Woche ausw‰hlt

	public List<Event> getEvent(){
		List<Event> events = new ArrayList<Event>();
		
		return events;
	}
}
