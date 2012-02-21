package applePlist;

import java.util.Date;
import java.util.List;

import com.dd.plist.NSDictionary;

public class pulsTemplate {
	
	
	public NSDictionary createEvent(String name,
							Date time_begin,
							Date time_end,
							String room,
							String instructor,
							String note,
							String course_type,
							String course_nr){
		NSDictionary event = new NSDictionary();
		event.put("name", name);
		event.put("time_begin", time_begin);
		event.put("time_end", time_end);
		event.put("room", room);
		event.put("instructor", instructor);
		event.put("note", note);
		event.put("course_type", course_type);
		event.put("course_nr", course_nr);
		return event;		
	}
	
	public NSDictionary createDay(Date date,
								  String name,
								  List<NSDictionary> events){
		NSDictionary day = new NSDictionary();
		day.put("date", date);
		day.put("name", name);
		Integer i = 0;
		for (NSDictionary nsd: events){
			day.put("events" + Integer.toString(i), nsd);
			i++;
		}
		return day;
	}
}
