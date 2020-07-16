package edu.studyup.serviceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
		//Create Student
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("JohnDoe@email.com");
		student.setId(1);
		
		//Create Event1
		Event event = new Event();
		event.setEventID(1);
		event.setDate(new Date());
		event.setName("Event 1");
		Location location = new Location(-122, 37);
		event.setLocation(location);
		List<Student> eventStudents = new ArrayList<>();
		eventStudents.add(student);
		event.setStudents(eventStudents);
		
		DataStorage.eventData.put(event.getEventID(), event);
	}

	@AfterEach
	void tearDown() throws Exception {
		DataStorage.eventData.clear();
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
  
	//Checks for Name Length <= 20
	@Test
	void testUpdateEventNameLength_badCase() throws StudyUpException {
		int eventID = 1; 
		String eventName = "Event name is longer than 20 for testing";
		//assertTrue(eventName.length() <= 20 , "Event name is bigger than 20 for Testing");
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.updateEventName(eventID, eventName);
		});
	}

	//Good Testers, tests upcoming event
	@Test
	void testGetActiveEvents_GoodCase(){ 
		Event event = new Event();
		event.setEventID(2);
		event.setDate(new Date(100000000));
		event.setName("Event 2");
		Location location = new Location(-122, 37);
		event.setLocation(location);
		DataStorage.eventData.put(event.getEventID(), event);
		assertTrue(eventServiceImpl.getActiveEvents().contains(DataStorage.eventData.get(2)));
	}
	
	//Bad Case: The Date is 1997 which still is still returned in the Active Event List
	@Test
	void testGetActiveEvents_BadCase(){ 
		Event event = new Event();
		event.setEventID(2);
		event.setDate(new Date(97,1,1));
		event.setName("Event 2");
		Location location = new Location(-122, 37);
		event.setLocation(location);
		DataStorage.eventData.put(event.getEventID(), event);
		assertFalse(eventServiceImpl.getActiveEvents().contains(DataStorage.eventData.get(2)));
	}

	//Good Case
	@Test
	void testAddStudentToEvent_GoodCase() throws StudyUpException { 
		int eventID = 1;
		Student student = new Student();
		student.setFirstName("Jane");
		student.setLastName("Doe");
		student.setEmail("JaneDoe@email.com");
		student.setId(eventID);
		//Event event1 = eventServiceImpl.addStudentToEvent(student, eventID);
		//List<Student> listOfStudents = DataStorage.eventData.get(eventID).getStudents();
		assertTrue(eventServiceImpl.addStudentToEvent(student, eventID).getStudents().contains(student));
	}

	//Good Case to test Null StudentsList
	@Test
	void testAddStudentToEvent_GoodCase_StudentsNull() throws StudyUpException { 
		int eventID = 2;
		Event event = new Event();
		event.setEventID(eventID);
		Student student = new Student();
		student.setFirstName("Jane");
		student.setLastName("Doe");
		student.setEmail("JaneDoe@email.com");
		student.setId(eventID);
		DataStorage.eventData.put(eventID, event);
		assertTrue(eventServiceImpl.addStudentToEvent(student, eventID).getStudents().contains(student));
	}

	//Bad Case: The Event does not exist
	@Test
	void testAddStudentToEvent_BadCase_EventNull() { 
		//Event event = new Event();
		//event.setEventID(2);
		//DataStorage.eventData.put(event.getEventID(), null);

		Student student = new Student();
		student.setFirstName("Jane");
		student.setLastName("Doe");
		student.setEmail("JaneDoe@email.com");
		student.setId(2);
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.addStudentToEvent(student, 2);
		  });
	}
	//Bad Case: Adds more than two students per Event
	@Test
	void testAddStudentToEvent_BadCase_MoreThan2() throws StudyUpException{
		int eventID = 1;
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setId(eventID);
		student2.setId(eventID);
		eventServiceImpl.addStudentToEvent(student1, eventID);
		assertFalse(eventServiceImpl.addStudentToEvent(student2, eventID).getStudents().contains(student2));
	}

	//Bad Case: Cannot add the same student to same Event
	@Test
	void testAddStudentToEvent_BadCase_SameStudent() throws StudyUpException { 
		int eventID = 1;
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("JohnDoe@email.com");
		student.setId(eventID);
	
		assertFalse(eventServiceImpl.addStudentToEvent(student, eventID).getStudents().contains(student));

	}
	

	//Bad Case: Event ID does not exist
	@Test
	void testAddStudentToEvent_BadCase_WrongEventID() {
		Student student = new Student();
		student.setFirstName("Jane");
		student.setLastName("Doe");
		student.setEmail("JaneDoe@email.com");
		student.setId(2);
		Assertions.assertThrows(StudyUpException.class, () -> {
			eventServiceImpl.addStudentToEvent(student, 2);
		  });
	}

	@Test 
	void testDeleteEvent_GoodCase () {
		eventServiceImpl.deleteEvent(1);
		assertTrue(DataStorage.eventData.isEmpty());
	}

	@Test
	void testGetPastEvents_GoodCase() {
		Event event = new Event();
		event.setEventID(2);
		event.setDate(new Date(97,1,1));
		event.setName("Event 2");
		Location location = new Location(-122, 37);
		event.setLocation(location);
		DataStorage.eventData.put(event.getEventID(), event);
	
		assertTrue(eventServiceImpl.getPastEvents().contains(DataStorage.eventData.get(2)));
	}
}

