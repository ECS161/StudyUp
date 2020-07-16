package edu.studyup.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.studyup.entity.Event;
import edu.studyup.entity.Student;
import edu.studyup.service.EventService;
import edu.studyup.util.DataStorage;
import edu.studyup.util.StudyUpException;

public class EventServiceImpl implements EventService {

	@Override
	public Event updateEventName(int eventID, String name) throws StudyUpException {
		Event event = DataStorage.eventData.get(eventID);
		if(event == null) {
			throw new StudyUpException("No event found.");
		}

		if(name.length() >= 20) {
			throw new StudyUpException("Length too long. Maximun is 20");
		}
		event.setName(name);
		DataStorage.eventData.put(eventID, event);
		event = DataStorage.eventData.get(event.getEventID());
		return event;
	}

	@Override
	public List<Event> getActiveEvents() {
		Map<Integer, Event> eventData = DataStorage.eventData;
		List<Event> activeEvents = new ArrayList<>();
		
		for (Map.Entry<Integer, Event> entry : eventData.entrySet()) {
			Event ithEvent= entry.getValue();
			activeEvents.add(ithEvent);
		}
		return activeEvents;
	}

	@Override
	public List<Event> getPastEvents() {
		Map<Integer, Event> eventData = DataStorage.eventData;
		List<Event> pastEvents = new ArrayList<>();
		
		for (Map.Entry<Integer, Event> entry : eventData.entrySet()) {
			Event ithEvent= entry.getValue();
			// Checks if an event date is before today, if yes, then add to the past event list.
			if(ithEvent.getDate().before(new Date())) {
				pastEvents.add(ithEvent);
			}
		}
		return pastEvents;
	}

	@Override
	public Event addStudentToEvent(Student student, int eventID) throws StudyUpException {
		Event event = DataStorage.eventData.get(eventID);
		if(event == null) {
			throw new StudyUpException("No event found.");
		}
		List<Student> presentStudents = event.getStudents();
		if(presentStudents == null) {
			presentStudents = new ArrayList<>();
		}
		presentStudents.add(student);
		event.setStudents(presentStudents);		
		return DataStorage.eventData.put(eventID, event);
	}

	@Override
	public Event deleteEvent(int eventID) {		
		return DataStorage.eventData.remove(eventID);
	}

}
