package com.uoc.uocapi.model;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class Message {
	private String id;
	private String subject;
	private String snippet;
	private String date;
	private long color;
	private long status;
	private String from;
	private String to;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getColor() {
		return color;
	}
	public void setColor(long color) {
		this.color = color;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public static Message JSONToMessage(String messageJSON) {
		Gson gson = new Gson();
		Message obj = gson.fromJson(messageJSON, Message.class);
		return obj;
	}
	
	private static String toJSON(Message newMessage) {
		return new Gson().toJson(newMessage);
	}
	
	public static Message postMessageinClassRoomBoardWS(String token, String domain_id, String board_id, Message newMessage) {
		String m = RESTMethod.Post(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages",toJSON(newMessage),
				token);

		return JSONToMessage(m);
	}
	
	public static Message getMessagefromClassRoomBoardWS(String token, String domain_id, String board_id, String message_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages/"+message_id,
				token);

		return JSONToMessage(m);
	}
	
	public static Message getMessagefromClassRoomBoardFolderWS(String token, String domain_id, String board_id, String message_id, String folder_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/"+message_id,
				token);

		return JSONToMessage(m);
	}
	
	public static Message postSendMessageWS(String token, Message newMessage) {
		String m = RESTMethod.Post(
				Constants.BASEURI +"mail/messages",toJSON(newMessage),
				token);

		return JSONToMessage(m);
	}
	
	public static Message getMessageWS(String token, String message_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"mail/messages/"+message_id,
				token);

		return JSONToMessage(m);
	}
	
	public static Message postMessageinSubjectBoardWS(String token, String subject_id, String board_id, Message newMessage) {
		String m = RESTMethod.Post(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages",toJSON(newMessage),
				token);

		return JSONToMessage(m);
	}
	
	public static Message getMessagefromSubjectBoardWS(String token, String subject_id, String board_id, String message_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages/"+message_id,
				token);

		return JSONToMessage(m);
	}
	
	public static Message getMessagefromSubjectBoardFolderWS(String token, String subject_id, String board_id, String message_id, String folder_id) {
		String m = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/"+message_id,
				token);

		return JSONToMessage(m);
	}
}
