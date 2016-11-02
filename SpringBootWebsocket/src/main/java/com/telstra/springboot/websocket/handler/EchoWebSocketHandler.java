package com.telstra.springboot.websocket.handler;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.telstra.springboot.service.EchoService;

public class EchoWebSocketHandler extends TextWebSocketHandler {
	private static Logger logger = LoggerFactory.getLogger(EchoWebSocketHandler.class);
	private EchoService echoService;

	public EchoWebSocketHandler(EchoService echoService) {
		this.echoService = echoService;
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.debug("Closed session in instance " + session.getId() + "status=" + status.getCode());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		logger.debug("Opened new session " + session.getId());
		Principal p = session.getPrincipal();
		if (p != null) {
			session.sendMessage(new TextMessage("name=" + p.getName()));
		} else {
			session.sendMessage(new TextMessage("name=null"));
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		session.close(CloseStatus.SERVER_ERROR);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String echoMessage = this.echoService.getMessage(message.getPayload());
		logger.debug(echoMessage);
		session.sendMessage(new TextMessage(echoMessage));
	}

}
