package com.uoc.uocapi.model;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.uoc.uocapi.Constants;
import com.uoc.uocapi.RESTMethod;

public class MessageList {
	private ArrayList<Message> messages;

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}
	
	private static MessageList JSONToMessageList(String messageList) {
		return new Gson().fromJson(messageList, MessageList.class);
	}
	
	public static MessageList getInboxfromClassRoomBoardWS(String token, String domain_id, String board_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getInboxfromClassRoomBoardWS(String token, String domain_id, String board_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromClassRoomBoardWS(String token, String domain_id, String board_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromClassRoomBoardWS(String token, String domain_id, String board_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getMessagesfromClassRoomBoardFolderWS(String token, String domain_id, String board_id, String folder_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getMessagesfromClassRoomBoardFolderWS(String token, String domain_id, String board_id, String folder_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromClassRoomBoardFolderWS(String token, String domain_id, String board_id, String folder_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromClassRoomBoardFolderWS(String token, String domain_id, String board_id, String folder_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"classrooms/"+domain_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getInboxMessagesWS(String token, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getInboxMessagesWS(String token, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromInboxWS(String token, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromInboxWS(String token, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}

	public static MessageList getMessagesfromFolderWS(String token, String start, String end, String folder_id) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getMessagesfromFolderWS(String token, String start, String end, String folder_id, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromFolderWS(String token, String start, String end, String folder_id) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromFolderWS(String token, String start, String end, String folder_id, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"mail/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getInboxfromSubjectBoardWS(String token, String subject_id, String board_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getInboxfromSubjectBoardWS(String token, String subject_id, String board_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromSubjectBoardWS(String token, String subject_id, String board_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromSubjectBoardWS(String token, String subject_id, String board_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getMessagesfromSubjectBoardFolderWS(String token, String subject_id, String board_id, String folder_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getMessagesfromSubjectBoardFolderWS(String token, String subject_id, String board_id, String folder_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromSubjectBoardFolderWS(String token, String subject_id, String board_id, String folder_id, String start, String end) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end);

		return JSONToMessageList(ml);
	}
	
	public static MessageList getUnreadfromSubjectBoardFolderWS(String token, String subject_id, String board_id, String folder_id, String start, String end, MessageSearchOptions so) {
		String ml = RESTMethod.Get(
				Constants.BASEURI +"subjects/"+subject_id+"/boards/"+board_id+"/folders/"+folder_id+"/messages/unread",
				token, "&start="+start+"&end="+end+so.toUrlParameter());

		return JSONToMessageList(ml);
	}
}