package com.newlecture.web;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

//서버쪽에 있는 끝점, 서버가 먼저 떠 있어야 한다. 
//{} 안의 내용은 고정되어 있지 않다는 것을 의미하고 변수처럼 사용할 수 있다.
@ServerEndpoint("/chat")
public class ChatServer {
	//동기화, 줄 세우기
	static CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();
	//OPEN
	@OnOpen
	public void openHandler(Session session) {
		System.out.println("Session: "+session);
	}
	//message
	@OnMessage
	public void messageHandler(String message, Session session) throws IOException {
		System.out.println(message);
		for(Session s: sessions)
			s.getBasicRemote().sendText(message);
	}
	
	//close 처리도 필요하다.
	@OnClose
	public void closeHandler(Session session) {
		//세션을 지워줘야 한다. -> 채팅방 나갈 때 구현 가능
		sessions.remove(session);
	}


}
