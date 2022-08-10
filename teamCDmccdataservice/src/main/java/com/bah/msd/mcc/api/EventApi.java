package com.bah.msd.mcc.api;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.mcc.domain.Event;

@RestController
@RequestMapping("/events")
public class EventApi {

	// Dummy Data
	ArrayList<Event> eventList = new ArrayList<Event>();

	public EventApi() {
		Event e1 = new Event(1, "CNF001", "All-Java Conference", "Lectures and exhibits covering all Java topics");
		Event e2 = new Event(2, "WKS002", "Spring Boot Workshop", "Hands-on Spring Boot Workshop");
		Event e3 = new Event(3, "TRN001", "Angular Training Course", "Five day introductory training in Angular");
		Event e4 = new Event(4, "RNR004", "Rock n Roll Concert", "BAH Employees RocknRoll Concert");
		
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
		eventList.add(e4);
		
	}

	// Get All
	@GetMapping
	public Collection<Event> getAll() {
		return this.eventList;
	}
	
	// Get One
	@GetMapping("/{eventId}")
	public Event getOneById(@PathVariable("eventId") long id) {
		
		// Set to null
		Event event = null;
		
		// return if ID matches
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i).getId() == id) {
				event = eventList.get(i);
			}
		}
		// If no match return event as null
		return event;
	}

}
