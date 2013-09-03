package com.uoc.uocapi.model;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class TeachingMaterial {
	private String id;
	private String type;
	private String title;
	private String url;
	
	public TeachingMaterial() {
		//Default constructor
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	private static String toJSON(TeachingMaterial newTMaterial) {
		return new Gson().toJson(newTMaterial);
	}
	
	public static TeachingMaterial JSONToTeachingMaterial(String tMaterialJSON) {
		Gson gson = new Gson();
		TeachingMaterial obj = gson.fromJson(tMaterialJSON, TeachingMaterial.class);
		return obj;
	}
	
	public static TeachingMaterial postTeachingMaterialtoClassRoomWS(String token, String id, TeachingMaterial newTMaterial) {
		String tml = RESTMethod.Post(
				Constants.BASEURI +"classrooms/"+id+"/materials",
				token, toJSON(newTMaterial));

		return JSONToTeachingMaterial(tml);
	}
	
	public static TeachingMaterial getTeachingMaterialfromClassRoomWS(String token, String domain_id, String tmaterial_id) {
		String tm = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/materials/"+tmaterial_id,
				token);

		return JSONToTeachingMaterial(tm);
	}

}