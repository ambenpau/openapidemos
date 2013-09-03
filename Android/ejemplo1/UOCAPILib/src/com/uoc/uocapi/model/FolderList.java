package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class FolderList {
	private ArrayList<Folder> folders;

	public ArrayList<Folder> getFolders() {
		return folders;
	}

	public void setFolders(ArrayList<Folder> folders) {
		this.folders = folders;
	}
	
	private static FolderList JSONToFolderList(String folderList) {
		return new Gson().fromJson(folderList, FolderList.class);
	}
	
	public static FolderList getFolderListfromClassRoomBoardWS(String token, String domain_id, String board_id) {
		String fl = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders",
				token);

		return JSONToFolderList(fl);
	}
	
	public static FolderList getUserFolderListWS(String token) {
		String fl = RESTMethod.Get(
				Constants.BASEURI +"mail/folders",
				token);

		return JSONToFolderList(fl);
	}
	
	public static FolderList getSubjectBoardFolderListWS(String token, String subject_id, String board_id) {
		String fl = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders",
				token);

		return JSONToFolderList(fl);
	}
}
