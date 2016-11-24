package com.springboot.sse.web.context;

import java.util.Map;

public class CallEvent {

	public String eventType = "";
	public String callId = "";
	public String calledNumber = "";
	public String callingNumber = "";
	public String callingTerminal = "";
	public String UCID = "";
	public String UUI = "";
	public String UEC = "";
	public String customerNumber = "";
	public String queueTime = "";
	public String agentId = "";
	public String agentTerminal = "";
	public String agentNotes = "";
	public String sapActivityId = "";
	public String connectionId = "";
	public String ivrData = "";
	public String ivrUCID = "";
	public String oldCallId = "";
	public String oldUCID = "";
	public String timestamp = "";

	public CallEvent() {

	}

	public CallEvent(Map<String, String> map) {
		this.eventType = map.get("eventType");
		this.callId = map.get("callId");
		this.calledNumber = map.get("calledNumber");
		this.callingNumber = map.get("callingNumber");
		this.callingTerminal = map.get("callingTerminal");
		this.UCID = map.get("UCID");
		this.UUI = map.get("UUI");
		this.UEC = map.get("UEC");
		this.customerNumber = map.get("customerNumber");
		this.queueTime = map.get("queueTime");
		this.agentId = map.get("agentId");
		this.agentTerminal = map.get("agentTerminal");
		this.agentNotes = map.get("agentNotes");
		this.sapActivityId = map.get("sapActivityId");
		this.connectionId = map.get("connectionId");
		this.ivrData = map.get("ivrData");
		this.ivrUCID = map.get("ivrUCID");
		this.oldCallId = map.get("oldCallId");
		this.oldUCID = map.get("oldUCID");
		this.timestamp = map.get("timestamp");
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	public String getCallingNumber() {
		return callingNumber;
	}

	public void setCallingNumber(String callingNumber) {
		this.callingNumber = callingNumber;
	}

	public String getCallingTerminal() {
		return callingTerminal;
	}

	public void setCallingTerminal(String callingTerminal) {
		this.callingTerminal = callingTerminal;
	}

	public String getUCID() {
		return UCID;
	}

	public void setUCID(String uCID) {
		UCID = uCID;
	}

	public String getUUI() {
		return UUI;
	}

	public void setUUI(String uUI) {
		UUI = uUI;
	}

	public String getUEC() {
		return UEC;
	}

	public void setUEC(String uEC) {
		UEC = uEC;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getQueueTime() {
		return queueTime;
	}

	public void setQueueTime(String queueTime) {
		this.queueTime = queueTime;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getAgentTerminal() {
		return agentTerminal;
	}

	public void setAgentTerminal(String agentTerminal) {
		this.agentTerminal = agentTerminal;
	}

	public String getAgentNotes() {
		return agentNotes;
	}

	public void setAgentNotes(String agentNotes) {
		this.agentNotes = agentNotes;
	}

	public String getSapActivityId() {
		return sapActivityId;
	}

	public void setSapActivityId(String sapActivityId) {
		this.sapActivityId = sapActivityId;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}

	public String getIvrData() {
		return ivrData;
	}

	public void setIvrData(String ivrData) {
		this.ivrData = ivrData;
	}

	public String getIvrUCID() {
		return ivrUCID;
	}

	public void setIvrUCID(String ivrUCID) {
		this.ivrUCID = ivrUCID;
	}

	public String getOldCallId() {
		return oldCallId;
	}

	public void setOldCallId(String oldCallId) {
		this.oldCallId = oldCallId;
	}

	public String getOldUCID() {
		return oldUCID;
	}

	public void setOldUCID(String oldUCID) {
		this.oldUCID = oldUCID;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("eventType=").append(eventType).append(",");
		sb.append("callId=").append(callId).append(",");
		sb.append("calledNumber=").append(calledNumber).append(",");
		sb.append("callingNumber=").append(callingNumber).append(",");
		sb.append("callingTerminal=").append(callingTerminal).append(",");
		sb.append("UCID=").append(UCID).append(",");
		sb.append("UUI=").append(UUI).append(",");
		sb.append("UEC=").append(UEC).append(",");
		sb.append("customerNumber=").append(customerNumber).append(",");
		sb.append("queueTime=").append(queueTime).append(",");
		sb.append("agentId=").append(agentId).append(",");
		sb.append("agentTerminal=").append(agentTerminal).append(",");
		sb.append("agentNotes=").append(agentNotes).append(",");
		sb.append("sapActivityId=").append(sapActivityId).append(",");
		sb.append("connectionId=").append(connectionId).append(",");
		sb.append("ivrData=").append(ivrData).append(",");
		sb.append("ivrUCID=").append(ivrUCID).append(",");
		sb.append("oldCallId=").append(oldCallId).append(",");
		sb.append("oldUCID=").append(oldUCID).append(",");
		sb.append("timestamp=").append(timestamp);
		return sb.toString();
	}
}
