package edu.studyup.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import edu.studyup.entity.Event;
import edu.studyup.entity.Location;
import edu.studyup.entity.Student;
import edu.studyup.util.DataStorage;
import edu.studyup.util.StudyUpException;

class EventServiceImplTest {

	EventServiceImpl eventServiceImpl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		eventServiceImpl = new EventServiceImpl();
		//Create Student 1
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("JohnDoe@email.com");
		student.setId(1);
		
		//Create Student 2
		Student student2 = new Student();
		student2.setFirstName("Jack");
		student2.setLastName("Invictus");
		student2.setEmail("JackInvictus@email.com");
		student2.setId(2);
		
		//Create Event1
		Event event = new Event();
		event.setEventID(1);
		event.setDate(new Date());
		event.setName("Event 1");
		Location location = new Location(-122, 37);
		event.setLocation(location);
		List<Student> eventStudents = new ArrayList<>();
		eventStudents.add(student);
		eventStudents.add(student2);
		event.setStudents(eventStudents);
		
		DataStorage.eventData.put(event.getEventID(), event);
		
		//Create Event2 outdated with no students 
		Event event2 = new Event();
		event2.setEventID(2);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date event2Date = cal.getTime();
		event2.setDate(event2Date);
		event2.setName("Event 2");
		Location location2 = new Location(-122, 38);
		event2.setLocation(location2);
		
		DataStorage.eventData.put(event2.getEventID(), event2);
	}

	@AfterEach
	void tearDown() throws Exception {
		// DataStorage.eventData.clear();
	}

	@Test
	void testUpdateEventName_GoodCase() throws StudyUpException {
		int eventID = 1;
		eventServiceImpl.updateEventName(eventID, "Renamed Event 1");
		assertEquals("Renamed Event 1", DataStorage.eventData.get(eventID).getName());
	}
	
	@Test
	void testUpdateEvent_WrongEventID_badCase() {
		int eventID = 3;
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.updateEventName(eventID, "Renamed Event 3");
		  });
	}
	
	@Test
	void testUpdateEventName_nameLengthMoreThanTwenty() {
		int eventID = 1;
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.updateEventName(eventID, "12345678901234567890123");
		});
	}
	
	@Test
	void testUpdateEventName_nameLengthTwenty() {
		int eventID = 1;
		try {
			eventServiceImpl.updateEventName(eventID, "12345678901234567890");
		} catch (StudyUpException e) {
			fail("Should not have thrown StudyUpException when the name length is 20.");
			e.printStackTrace();
		}
	}
	
	@Test
	void testGetActiveEvents_date() {
		List<Event> activeEvents = eventServiceImpl.getActiveEvents();
		for (Event activeEvent : activeEvents) {
			assertTrue(activeEvent.getDate().after(new Date()), "The active event date should after current date!");
		}
	}
	
	@Test
	void testGetPastEvents_date() {
		List<Event> pastEvents = eventServiceImpl.getPastEvents();
		for	(Event pastEvent : pastEvents) {
			assertTrue(pastEvent.getDate().before(new Date()), "The past event date should before current date!");
		}
	}

	@Test
	void testAddStudentToEvent_eventNull() {
		//Create Student 3
		Student student3 = new Student();
		student3.setFirstName("Steven");
		student3.setLastName("Harvey");
		student3.setEmail("StevenHarvey@email.com");
		student3.setId(3);
		
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.addStudentToEvent(student3, 3);
		});
	}
	
	@Test
	void testAddStudentToEvent_noPresentStudent() throws StudyUpException {
		//Create Student 3
		Student student3 = new Student();
		student3.setFirstName("Steven");
		student3.setLastName("Harvey");
		student3.setEmail("StevenHarvey@email.com");
		student3.setId(3);
		
		Event event2 = eventServiceImpl.addStudentToEvent(student3, 2);
		List<Student> students = event2.getStudents();
		assertEquals(students.size(), 1);
	}
	
	@Test
	void testAddStudentToEvent_moreThanTwoStudents() throws StudyUpException {
		//Create Student 3
		Student student3 = new Student();
		student3.setFirstName("Steven");
		student3.setLastName("Harvey");
		student3.setEmail("StevenHarvey@email.com");
		student3.setId(3);
		Event event = eventServiceImpl.addStudentToEvent(student3, 1);
		List<Student> students = event.getStudents();
		assertTrue(students.size() <= 2, "No more than two students can be in the same event!");
	}
	
	@Test
	void testDeleteEvent_deleted() {
		// Delete a past event 
		List<Event> pastEvents = eventServiceImpl.getPastEvents();
		eventServiceImpl.deleteEvent(2);
		List<Event> pastEvents2 = eventServiceImpl.getPastEvents();
		assertEquals(pastEvents.size()-1, pastEvents2.size(), "Not able to delete!");
	}
}