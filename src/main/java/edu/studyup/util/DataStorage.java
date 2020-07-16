package edu.studyup.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import edu.studyup.entity.Event;

/***
 * 
 * This class is a temporary class to be used in place of a database. The static
 * variable eventList holds all the event data.
 * 
 * @author Shivani
 * 
 */
public class DataStorage {
	public static final Map<Integer, Event> eventData = new HashMap<Integer, Event>();

}
