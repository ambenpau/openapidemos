package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class EventList {
	private ArrayList<Event> events;

	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	
	public static EventList getEventListWS(String token) {
		String evl = RESTMethod.Get(
				Constants.BASEURI +"calendar/events/",
				token);

		return JSONtoEventList(evl);
	}
	
	public static EventList getEventListWS(String token, String start, String end) {
		String evl = RESTMethod.Get(
				Constants.BASEURI +"calendar/events/",
				token, "&start="+start+"&end="+end);

		return JSONtoEventList(evl);
	}
	
	public static EventList getEventListFromWS(String token, String start) {
		String evl = RESTMethod.Get(
				Constants.BASEURI +"calendar/events/",
				token, "&start="+start);

		return JSONtoEventList(evl);
	}
	
	public static EventList getEventListTillWS(String token, String end) {
		String evl = RESTMethod.Get(
				Constants.BASEURI +"calendar/events/",
				token, "&end="+end);

		return JSONtoEventList(evl);
	}

	private static EventList JSONtoEventList(String eventlist) {
		return new Gson().fromJson(eventlist, EventList.class);
	}
}