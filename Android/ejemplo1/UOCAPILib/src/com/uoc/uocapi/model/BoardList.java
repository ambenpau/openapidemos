package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class BoardList {
	private ArrayList<Board> boards;

	public ArrayList<Board> getBoards() {
		return boards;
	}

	public void setBoards(ArrayList<Board> boards) {
		this.boards = boards;
	}
	
	public static BoardList getBoardListfromClassRoomWS(String token, String id) {
		String bl = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+id+"/boards",
				token);

		return JSONtoBoardList(bl);
	}

	private static BoardList JSONtoBoardList(String boardlist) {
		return new Gson().fromJson(boardlist, BoardList.class);
	}
	
	public static BoardList getSubjectBoardsWS(String token, String subject_id) {
		String bl = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards",
				token);

		return JSONtoBoardList(bl);
	}
}