package xmlClass;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXB;

public class TestXml {
	public static final String OUTPUT_FILE = System.getProperty("user.home")
			+ "\\Documents\\bsp.xml";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Event event = new Event();
		event.setInstructor("Ich");
		event.setNote("1,0");
		event.setRoom("2.06");
		event.setTime_Begin(new Date(new Date().getTime()));
		event.setTime_end(new Date(new Date().getTime()));
		List<Event> events = new ArrayList<Event>();
		events.add(event);
		
		Day day = new Day();
		day.setDate(new Date(new Date().getTime()));
		day.setDayName("Montag");
		day.setEvents(events);
		List<Day> days = new ArrayList<Day>();
		days.add(day);
		
		Shedule shedule = new Shedule();
		shedule.setDayName("Monday");
		shedule.setDays(days);

		File file = new File(OUTPUT_FILE);
		JAXB.marshal(shedule, file);
	}

}
