package xmlClass;

import java.util.Date;

import javax.xml.bind.annotation.*;


@XmlRootElement

public class Event {

	private Date time_begin;
	private Date time_end;
	private String room;
	private String instructor;
	private String note;
	
	
	public void setTime_Begin(Date time_begin) {
		this.time_begin = time_begin;
	}
	
	public Date getTime_Begin() {
		return time_begin;
	}

	public Date getTime_end() {
		return time_end;
	}

	public void setTime_end(Date time_end) {
		this.time_end = time_end;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}