package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class ClassRoomList {
	private ArrayList<ClassRoom> classrooms;

	public ArrayList<ClassRoom> getClassRooms() {
		return classrooms;
	}

	public void setClassRoomList(ArrayList<ClassRoom> classrooms) {
		this.classrooms = classrooms;
	}
	
	public static ClassRoomList getClassRoomListWS(String token) {
		String crl = RESTMethod.Get(
				Constants.BASEURI +"classrooms",
				token);

		return JSONtoClassRoomList(crl);
	}
	
	public static ClassRoomList getClassRoomListGroupsWS(String token, String id) {
		String crl = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+id+"/groups",
				token);

		return JSONtoClassRoomList(crl);
	}

	private static ClassRoomList JSONtoClassRoomList(String classroomlist) {
		return new Gson().fromJson(classroomlist, ClassRoomList.class);
	}
	
	public static ClassRoomList getSubjectsClassRoomsWS(String token) {
		String crl = RESTMethod.Get(
				Constants.BASEURI +"subjects",
				token);

		return JSONtoClassRoomList(crl);
	}
}