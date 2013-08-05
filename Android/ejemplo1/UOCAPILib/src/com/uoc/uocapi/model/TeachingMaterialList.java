package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class TeachingMaterialList {
	private ArrayList<TeachingMaterial> teachingMaterials;

	public ArrayList<TeachingMaterial> getTeachingMaterials() {
		return teachingMaterials;
	}

	public void setTeachingMaterials(ArrayList<TeachingMaterial> teachingMaterials) {
		this.teachingMaterials = teachingMaterials;
	}
	
	public static TeachingMaterialList getTeachingMaterialListfromClassRoomWS(String token, String id) {
		String tml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+id+"/materials",
				token);

		return JSONtoTeachingMaterialList(tml);
	}

	private static TeachingMaterialList JSONtoTeachingMaterialList(String teachingMateriallist) {
		return new Gson().fromJson(teachingMateriallist, TeachingMaterialList.class);
	}
}