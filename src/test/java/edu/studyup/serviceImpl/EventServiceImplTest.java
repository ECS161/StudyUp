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
		//Create Student
		Student student = new Student();
		student.setFirstName("John");
		student.setLastName("Doe");
		student.setEmail("JohnDoe@email.com");
		student.setId(1);
		
		
		Student student2 = new Student();
		student2.setFirstName("YI");
		student2.setLastName("CHEN");
		student2.setEmail("yichen@126.com");
		student2.setId(3);
		
		Student student3 = new Student();
		student3.setFirstName("andy");
		student3.setLastName("samberg");
		student3.setEmail("123@123.com");
		student3.setId(4);
		
		Student student4 = new Student();
		student4.setFirstName("1");
		student4.setLastName("travis");
		student4.setEmail("no@github.com");
		student4.setId(5);
		
		Student student5 = new Student();
		student5.setFirstName("nope");
		student5.setLastName("22");
		student5.setEmail("qq@qq.com");
		student5.setId(6);
		
		Student student6 = new Student();
		student6.setFirstName("event");
		student6.setLastName("service");
		student6.setEmail("eclipse@ucdavis.edu");
		student6.setId(8);
		
		Student student7 = new Student();
		student7.setFirstName("888");
		student7.setLastName("void");
		student7.setEmail("12qq@noway.com");
		student7.setId(9);
		
		Student student8 = new Student();
		student8.setFirstName("tear");
		student8.setLastName("down");
		student8.setEmail("setup@44.com");
		student8.setId(10);
		
		Student student9 = new Student();
		student9.setFirstName("create");
		student9.setLastName("event");
		student9.setEmail("create@event.com");
		student9.setId(11);
		
		Student student10 = new Student();
		student10.setFirstName("no");
		student10.setLastName("hw");
		student10.setEmail("hw@qqq111.com");
		student10.setId(12);
		
		Student student11 = new Student();
		student11.setFirstName("json");
		student11.setLastName("object");
		student11.setEmail("nnn@qqq111.com");
		student11.setId(12);
		
		Student student12 = new Student();
		student12.setFirstName("jake");
		student12.setLastName("peralta");
		student12.setEmail("99@qqq111.com");
		student12.setId(12);
		
		Student student13 = new Student();
		student13.setFirstName("insertion");
		student13.setLastName("sort");
		student13.setEmail("nnn@null.com");
		student13.setId(12);
		
		Student student14 = new Student();
		student14.setFirstName("die");
		student14.setLastName("hard");
		student14.setEmail("nnn@wait.com");
		student14.setId(12);
		
		
		
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
		// create event 2
		Event event1 = new Event();
		event1.setEventID(2);
		event1.setDate(new Date());
		event1.setName("Event 2");
		Location location1 = new Location(32, -37);
		event1.setLocation(location1);
		List<Student> eventStudents2 = new ArrayList<>();
		eventStudents2.add(student);
		event1.setStudents(eventStudents2);
		
		DataStorage.eventData.put(event1.getEventID(), event1);
		// create event 3
		Event event2 = new Event();
		event2.setEventID(3);
		event2.setDate(new Date());
		event2.setName("Event 3");
		Location location2 = new Location(0, 0);
		event2.setLocation(location2);
		List<Student> eventStudents3 = new ArrayList<>();
		eventStudents2.add(student);
		event2.setStudents(eventStudents3);
				
		DataStorage.eventData.put(event2.getEventID(), event2);
				
		
		Event event4 = new Event();
		event4.setEventID(4);
		event4.setDate(new Date());
		event4.setName("Event 4");
		Location location4 = new Location(-132, 27);
		event4.setLocation(location4);
		List<Student> eventStudents4 = new ArrayList<>();
		eventStudents.add(student);
		event4.setStudents(eventStudents4);
		
		DataStorage.eventData.put(event4.getEventID(), event4);
		
		Event event5 = new Event();
		event5.setEventID(9);
		event5.setDate(new Date());
		event5.setName("Event 9");
		Location location94 = new Location(-172, 47);
		event5.setLocation(location94);
		List<Student> eventStudents9 = new ArrayList<>();
		eventStudents.add(student);
		event5.setStudents(eventStudents9);
		
		DataStorage.eventData.put(event5.getEventID(), event5);
		Event event6 = new Event();
		event6.setEventID(9);
		event6.setDate(new Date());
		event6.setName("Event 9");
		Location location91 = new Location(-172, 47);
		event6.setLocation(location91);
		List<Student> eventStudents91 = new ArrayList<>();
		eventStudents.add(student);
		event6.setStudents(eventStudents91);
		
		DataStorage.eventData.put(event6.getEventID(), event6);
		Event event7 = new Event();
		event7.setEventID(9);
		event7.setDate(new Date());
		event7.setName("Event 9");
		Location location92 = new Location(-172, 47);
		event7.setLocation(location92);
		List<Student> eventStudents97 = new ArrayList<>();
		eventStudents.add(student);
		event7.setStudents(eventStudents97);
		
		DataStorage.eventData.put(event7.getEventID(), event7);
	
		Event event91 = new Event();
		event91.setEventID(9);
		event91.setDate(new Date());
		event91.setName("Event 9");
		Location location93 = new Location(-172, 47);
		event91.setLocation(location93);
		List<Student> eventStudents911 = new ArrayList<>();
		eventStudents.add(student);
		event91.setStudents(eventStudents911);
		
		DataStorage.eventData.put(event91.getEventID(), event91);
		
	
		
		DataStorage.eventData.put(event4.getEventID(), event4);
		
		
		
		Event event14 = new Event();
		event14.setEventID(4);
		event14.setDate(new Date());
		event14.setName("Event 4");
		Location location14 = new Location(-132, 27);
		event14.setLocation(location14);
		List<Student> eventStudents14 = new ArrayList<>();
		eventStudents.add(student);
		event14.setStudents(eventStudents14);
		
		DataStorage.eventData.put(event14.getEventID(), event14);
		Event event16 = new Event();
		event16.setEventID(4);
		event16.setDate(new Date());
		event16.setName("Event 4");
		Location location16 = new Location(-132, 27);
		event16.setLocation(location16);
		List<Student> eventStudents16 = new ArrayList<>();
		eventStudents.add(student);
		event16.setStudents(eventStudents16);
		
		DataStorage.eventData.put(event16.getEventID(), event16);
		
		Event event17 = new Event();
		event17.setEventID(4);
		event17.setDate(new Date());
		event17.setName("Event 4");
		Location location17 = new Location(-6, 277);
		event17.setLocation(location17);
		List<Student> eventStudents17 = new ArrayList<>();
		eventStudents.add(student);
		event17.setStudents(eventStudents17);
		
		DataStorage.eventData.put(event17.getEventID(), event17);
		
		Event event18 = new Event();
		event18.setEventID(4);
		event18.setDate(new Date());
		event18.setName("Event 4");
		Location location18 = new Location(-656, 277);
		event18.setLocation(location18);
		List<Student> eventStudents18 = new ArrayList<>();
		eventStudents.add(student);
		event18.setStudents(eventStudents18);
		
		DataStorage.eventData.put(event18.getEventID(), event18);
		
		Event event19 = new Event();
		event19.setEventID(4);
		event19.setDate(new Date());
		event19.setName("Event 4");
		Location location19 = new Location(86, 277);
		event19.setLocation(location19);
		List<Student> eventStudents19 = new ArrayList<>();
		eventStudents.add(student);
		event19.setStudents(eventStudents19);
		DataStorage.eventData.put(event19.getEventID(), event19);
		
		Event event20 = new Event();
		event20.setEventID(4);
		event20.setDate(new Date());
		event20.setName("Event 4");
		Location location20 = new Location(0, -77);
		event20.setLocation(location20);
		List<Student> eventStudents20 = new ArrayList<>();
		eventStudents.add(student);
		event20.setStudents(eventStudents20);
		DataStorage.eventData.put(event20.getEventID(), event20);
		
		Event event21 = new Event();
		event21.setEventID(4);
		event21.setDate(new Date());
		event21.setName("Event 4");
		Location location21 = new Location(0, -77);
		event21.setLocation(location21);
		List<Student> eventStudents21 = new ArrayList<>();
		eventStudents.add(student);
		event21.setStudents(eventStudents21);
		DataStorage.eventData.put(event21.getEventID(), event21);
		
		Event event22 = new Event();
		event22.setEventID(4);
		event22.setDate(new Date());
		event22.setName("Event 4");
		Location location22 = new Location(0, -707);
		event22.setLocation(location22);
		List<Student> eventStudents22 = new ArrayList<>();
		eventStudents.add(student);
		event22.setStudents(eventStudents22);
		DataStorage.eventData.put(event22.getEventID(), event22);
		
		Event event23 = new Event();
		event23.setEventID(4);
		event23.setDate(new Date());
		event23.setName("Event 4");
		Location location23 = new Location(86, 277);
		event23.setLocation(location23);
		List<Student> eventStudents23 = new ArrayList<>();
		eventStudents.add(student);
		event23.setStudents(eventStudents23);
		DataStorage.eventData.put(event23.getEventID(), event23);
		
		Event event24 = new Event();
		event24.setEventID(4);
		event24.setDate(new Date());
		event24.setName("Event 4");
		Location location24 = new Location(86, 277);
		event24.setLocation(location24);
		List<Student> eventStudents24 = new ArrayList<>();
		eventStudents.add(student);
		event24.setStudents(eventStudents24);
		DataStorage.eventData.put(event24.getEventID(), event24);
		
		Event event25 = new Event();
		event25.setEventID(4);
		event25.setDate(new Date());
		event25.setName("Event 4");
		Location location25 = new Location(86, 277);
		event25.setLocation(location25);
		List<Student> eventStudents25 = new ArrayList<>();
		eventStudents.add(student);
		event25.setStudents(eventStudents25);
		DataStorage.eventData.put(event25.getEventID(), event25);
		
		Event event26 = new Event();
		event26.setEventID(4);
		event26.setDate(new Date());
		event26.setName("Event 4");
		Location location26 = new Location(86, 277);
		event26.setLocation(location26);
		List<Student> eventStudents26 = new ArrayList<>();
		eventStudents.add(student);
		event26.setStudents(eventStudents26);
		DataStorage.eventData.put(event26.getEventID(), event26);
		
		Event event27 = new Event();
		event27.setEventID(4);
		event27.setDate(new Date());
		event27.setName("Event 4");
		Location location27 = new Location(86, 277);
		event27.setLocation(location27);
		List<Student> eventStudents27 = new ArrayList<>();
		eventStudents.add(student);
		event27.setStudents(eventStudents27);
		DataStorage.eventData.put(event27.getEventID(), event27);
		
		Event event28 = new Event();
		event28.setEventID(4);
		event28.setDate(new Date());
		event28.setName("Event 4");
		Location location28 = new Location(86, 277);
		event28.setLocation(location28);
		List<Student> eventStudents28 = new ArrayList<>();
		eventStudents.add(student);
		event28.setStudents(eventStudents28);
		DataStorage.eventData.put(event28.getEventID(), event28);
		
		Event event29 = new Event();
		event29.setEventID(4);
		event29.setDate(new Date());
		event29.setName("Event 4");
		Location location29 = new Location(8, 277);
		event29.setLocation(location29);
		List<Student> eventStudents29 = new ArrayList<>();
		eventStudents.add(student);
		event29.setStudents(eventStudents29);
		DataStorage.eventData.put(event29.getEventID(), event29);
		
		Event event30 = new Event();
		event30.setEventID(4);
		event30.setDate(new Date());
		event30.setName("Event 4");
		Location location30 = new Location(86, -7);
		event30.setLocation(location30);
		List<Student> eventStudents30 = new ArrayList<>();
		eventStudents.add(student);
		event30.setStudents(eventStudents30);
		DataStorage.eventData.put(event30.getEventID(), event30);
		
		Event event31 = new Event();
		event31.setEventID(4);
		event31.setDate(new Date());
		event31.setName("Event 4");
		Location location31 = new Location(86, 277);
		event31.setLocation(location31);
		List<Student> eventStudents31 = new ArrayList<>();
		eventStudents.add(student);
		event31.setStudents(eventStudents31);
		DataStorage.eventData.put(event31.getEventID(), event31);
		
		Event event32 = new Event();
		event32.setEventID(4);
		event32.setDate(new Date());
		event32.setName("Event 4");
		Location location32 = new Location(86, -7);
		event32.setLocation(location32);
		List<Student> eventStudents32 = new ArrayList<>();
		eventStudents.add(student);
		event32.setStudents(eventStudents32);
		DataStorage.eventData.put(event32.getEventID(), event32);
		
		Event event33 = new Event();
		event33.setEventID(4);
		event33.setDate(new Date());
		event33.setName("Event 4");
		Location location33 = new Location(86, 277);
		event33.setLocation(location33);
		List<Student> eventStudents33 = new ArrayList<>();
		eventStudents.add(student);
		event33.setStudents(eventStudents33);
		DataStorage.eventData.put(event33.getEventID(), event33);
		
		Event event34 = new Event();
		event34.setEventID(4);
		event34.setDate(new Date());
		event34.setName("Event 4");
		Location location34 = new Location(86, -7);
		event34.setLocation(location34);
		List<Student> eventStudents34 = new ArrayList<>();
		eventStudents.add(student);
		event34.setStudents(eventStudents34);
		DataStorage.eventData.put(event34.getEventID(), event34);
		
		Event event35 = new Event();
		event35.setEventID(4);
		event35.setDate(new Date());
		event35.setName("Event 4");
		Location location35 = new Location(86, 277);
		event35.setLocation(location35);
		List<Student> eventStudents35 = new ArrayList<>();
		eventStudents.add(student);
		event31.setStudents(eventStudents35);
		DataStorage.eventData.put(event35.getEventID(), event35);
		
		Event event36 = new Event();
		event36.setEventID(4);
		event36.setDate(new Date());
		event36.setName("Event 4");
		Location location36 = new Location(86, 277);
		event36.setLocation(location36);
		List<Student> eventStudents36 = new ArrayList<>();
		eventStudents.add(student);
		event36.setStudents(eventStudents36);
		DataStorage.eventData.put(event36.getEventID(), event36);
		
		Event event37 = new Event();
		event37.setEventID(4);
		event37.setDate(new Date());
		event37.setName("Event 4");
		Location location37 = new Location(86, 277);
		event37.setLocation(location37);
		List<Student> eventStudents37 = new ArrayList<>();
		eventStudents.add(student);
		event37.setStudents(eventStudents37);
		DataStorage.eventData.put(event37.getEventID(), event37);
		
		Event event38 = new Event();
		event38.setEventID(4);
		event38.setDate(new Date());
		event38.setName("Event 4");
		Location location38 = new Location(34, 277);
		event38.setLocation(location38);
		List<Student> eventStudents38 = new ArrayList<>();
		eventStudents.add(student);
		event38.setStudents(eventStudents38);
		DataStorage.eventData.put(event38.getEventID(), event38);
		
		Event event39 = new Event();
		event39.setEventID(4);
		event39.setDate(new Date());
		event39.setName("Event 4");
		Location location39 = new Location(86, 277);
		event39.setLocation(location39);
		List<Student> eventStudents39 = new ArrayList<>();
		eventStudents.add(student);
		event39.setStudents(eventStudents39);
		DataStorage.eventData.put(event39.getEventID(), event39);
		
		Event event40 = new Event();
		event40.setEventID(4);
		event40.setDate(new Date());
		event40.setName("Event 4");
		Location location40 = new Location(86, 277);
		event40.setLocation(location40);
		List<Student> eventStudents40 = new ArrayList<>();
		eventStudents.add(student);
		event40.setStudents(eventStudents40);
		DataStorage.eventData.put(event40.getEventID(), event40);
		
		Event event41 = new Event();
		event41.setEventID(4);
		event41.setDate(new Date());
		event41.setName("Event 4");
		Location location41 = new Location(86, 277);
		event41.setLocation(location41);
		List<Student> eventStudents41 = new ArrayList<>();
		eventStudents.add(student);
		event41.setStudents(eventStudents41);
		DataStorage.eventData.put(event41.getEventID(), event41);
		
		
		
		
		
		Event event10 = new Event();
		event10.setEventID(10);
		event10.setDate(new Date());
		event10.setName("Event 10");
		Location location10 = new Location(-112, 47);
		event10.setLocation(location10);
		List<Student> eventStudents10 = new ArrayList<>();
		eventStudents.add(student);
		event10.setStudents(eventStudents10);
		
		DataStorage.eventData.put(event10.getEventID(), event10);
	
		
	
		Event event12 = new Event();
		event12.setEventID(2);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1988);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date event2Date = cal.getTime();
		event12.setDate(event2Date);
		event12.setName("Event 2");
		Location location211 = new Location(-122, 38);
		event12.setLocation(location211);
		DataStorage.eventData.put(event12.getEventID(), event12);
		
		Event event13 = new Event();
		event13.setEventID(2);
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.YEAR, 1988);
		cal1.set(Calendar.MONTH, Calendar.JANUARY);
		cal1.set(Calendar.DAY_OF_MONTH, 1);
		Date event2Date1 = cal.getTime();
		event13.setDate(event2Date1);
		event13.setName("Event 2");
		Location location223 = new Location(-122, 38);
		event13.setLocation(location223);
		DataStorage.eventData.put(event13.getEventID(), event13);
		
		
	
		
		
		
	
	}
	
	

		
	

	@AfterEach
	void tearDown() throws Exception {
		//DataStorage.eventData.clear();
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
	void testGetActiveEvents_date1() {
		List<Event> activeEvents = eventServiceImpl.getActiveEvents();
		for (Event activeEvent : activeEvents) {
			assertTrue(activeEvent.getDate().after(new Date()), "The active event date should after current date!");
		}
	}
	
	@Test
	void testGetPastEvents_date1() {
		List<Event> pastEvents = eventServiceImpl.getPastEvents();
		for	(Event pastEvent : pastEvents) {
			assertTrue(pastEvent.getDate().before(new Date()), "The past event date should before current date!");
		}
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
	void testAddStudentToEvent_noPresentStudent() throws StudyUpException {
		
		Student student13 = new Student();
		student13.setFirstName("Steven");
		student13.setLastName("Harvey");
		student13.setEmail("StevenHarvey@email.com");
		student13.setId(3);
		
		Event event2 = eventServiceImpl.addStudentToEvent(student13, 2);
		List<Student> students = event2.getStudents();
		assertEquals(students.size(), 1);
	}
	
	


@Test
void testUpdateEventName_nameLengthMoreThanTwenty() {
	int eventID = 1;
	Assertions.assertThrows(StudyUpException.class, () -> {
		eventServiceImpl.updateEventName(eventID, "12345678901234567890123");
	});
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
