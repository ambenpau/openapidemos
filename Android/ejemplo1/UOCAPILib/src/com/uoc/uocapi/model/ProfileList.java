package com.uoc.uocapi.model;

import java.util.ArrayList;
import com.uoc.uocapi.Constants;
import com.google.gson.Gson;
import com.uoc.uocapi.RESTMethod;

public class ProfileList {
	ArrayList<Profile> profiles;

	public ProfileList() {
	}

	public ArrayList<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(ArrayList<Profile> profileList) {
		this.profiles = profileList;
	}
	
	public static ProfileList getProfileListWS(String token) {
		String pfl = RESTMethod
				.Get(Constants.BASEURI +"user/profiles",
						token);

		return JSONtoProfileList(pfl);
	}

	private static ProfileList JSONtoProfileList(String profileList) {
		return new Gson().fromJson(profileList, ProfileList.class);
	}
	
	public static ProfileList getPersonProfileWS(String token, String person_id) {
		String pfl = RESTMethod
				.Get(Constants.BASEURI +"people/"+person_id+"/profiles",
						token);

		return JSONtoProfileList(pfl);
	}

}
