package com.uoc.uocapi.model;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class ClassRoom {
	private String id;
	private String title;
	private String color;
	private String fatherId;
	private String[] assignments;

	public ClassRoom() {
		//Default constructor
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String[] getAssignments() {
		return assignments;
	}

	public void setAssignments(String[] assignments) {
		this.assignments = assignments;
	}

	public static ClassRoom JSONToClassRoom(String classRoomJSON) {
		Gson gson = new Gson();
		ClassRoom obj = gson.fromJson(classRoomJSON, ClassRoom.class);
		return obj;
	}
	
	public static ClassRoom getClassRoomWS(String token, String id) {
		return JSONToClassRoom(RESTMethod
				.Get(Constants.BASEURI +"classrooms/"+id,
						token));
	}
	
	public static ClassRoom getSubjectClassRoomWS(String token, String subject_id) {
		return JSONToClassRoom(RESTMethod
				.Get(Constants.BASEURI +"subjects/"+subject_id,
						token));
	}

}
