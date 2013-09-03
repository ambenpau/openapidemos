package com.uoc.uocapi.model;

import java.util.ArrayList;
import com.uoc.uocapi.Constants;
import com.google.gson.Gson;
import com.uoc.uocapi.RESTMethod;

public class ResourceList {

	private ArrayList<Resource> resources;

	public ResourceList() {
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}

	public void setResources(ArrayList<Resource> resourcesList) {
		this.resources = resourcesList;
	}
	
	public static ResourceList getClassRoomResourceListWS(String token, String id) {
		String rl = RESTMethod
				.Get(Constants.BASEURI +"classrooms/"+id+"/resources",
						token);

		return JSONtoResourceList(rl);
	}

	private static ResourceList JSONtoResourceList(String resourceList) {
		return new Gson().fromJson(resourceList, ResourceList.class);
	}
	
	public static ResourceList getSubjectResoucesWS(String token, String subject_id) {
		String rl = RESTMethod
				.Get(Constants.BASEURI +"subjects/"+subject_id+"/resources",
						token);

		return JSONtoResourceList(rl);
	}
}