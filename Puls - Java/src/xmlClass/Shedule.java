package xmlClass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Shedule {

	private String dayName;
	private List<Day> days = new ArrayList<Day>();
	
	public String getDayName() {
		return dayName;
	}
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
	@XmlElement (name= "day")
	public List<Day> getDays() {
		return days;
	}
	public void setDays(List<Day> days) {
		this.days = days;
	}

	
	
}
