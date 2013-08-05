package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class PersonList {
	private ArrayList<Person> people;

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}
	
	private static PersonList JSONToPersonList(String personList) {
		return new Gson().fromJson(personList, PersonList.class);
	}
	
	public static PersonList getPersonListWS(String token, PeopleSearchOptions so) {
		String pl = RESTMethod.Get(
				Constants.BASEURI +"people",
				token, so.toUrlParameter());

		return JSONToPersonList(pl);
	}
}
