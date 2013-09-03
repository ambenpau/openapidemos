package com.uoc.uocapi.model;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class MessageBody {
	private String id;
	private String body;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public static MessageBody JSONToMessageBody(String messageBodyJSON) {
		Gson gson = new Gson();
		MessageBody obj = gson.fromJson(messageBodyJSON, MessageBody.class);
		return obj;
	}
	
	public static MessageBody getMessageBodyfromClassRoomBoardFolderMessageWS(String token, String domain_id, String board_id, String message_id, String folder_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/"+message_id+"/body",
				token);

		return JSONToMessageBody(m);
	}
	
	public static MessageBody getMessageBodyWS(String token, String message_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"mail/messages/"+message_id+"/body",
				token);

		return JSONToMessageBody(m);
	}
	
	public static MessageBody getMessageBodyfromSubjectBoardFolderMessageWS(String token, String subject_id, String board_id, String message_id, String folder_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/"+message_id+"/body",
				token);

		return JSONToMessageBody(m);
	}
}