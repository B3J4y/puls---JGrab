package applePlist;

import java.io.File;

import com.dd.plist.*;

public class CreatePlist {
	public static final String OUTPUT_FILE = System.getProperty("user.home")
			+ "\\Documents\\bsp.plist";
	public CreatePlist() {
		try {
		NSDictionary root = new NSDictionary();
		
		NSDictionary event = new NSDictionary();
		event.put("name", "EWI");
		event.put("time_begin", new NSDate("2011-09-23T12:32:42Z"));
		event.put("time_end", new NSDate("2011-09-23T14:32:42Z"));
		event.put("room", "2.06");
		event.put("instructor", "Icke");
		event.put("note", "1,0");
		
		NSArray events = new NSArray(2);
		events.setValue(0, event);
		
		NSDictionary day = new NSDictionary();
		day.put("date", new NSDate("2011-09-23T12:32:42Z"));
		day.put("name", "Montag");
		day.put("events", events);
		NSArray days = new NSArray(1);
		days.setValue(0, event);
		
		root.put("monday", days);
		
		PropertyListParser.saveAsXML(root, new File(OUTPUT_FILE ));
		
		
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new CreatePlist();

	}

}
