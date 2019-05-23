package edu.studyup.entity;

import java.util.Date;
import java.util.List;

/**
 * 
 * The Event class holds all attributes related to an event. There are few
 * restrictions applied on the attributes:
 * 
 * @name The length of event name has to be less than(<=) 20 characters.
 * @students There could at most be {@code 2 students} in an event.
 * @author shvz
 *
 */
public class Event {

	private int eventID;
	private String name;
	private Location location;
	private List<Student> students;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// comment
	public Date getDate() {

		if(date == null) {
			return null;
		} else {
			return new Date(date.getTime());
		}
	}

	public void setDate(Date date) {
		if(date == null) {
			this.date = null;
		} else {
			this.date = new Date(date.getTime());
		}

	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

}
