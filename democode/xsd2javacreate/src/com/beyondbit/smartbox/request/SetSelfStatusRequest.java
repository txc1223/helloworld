package com.beyondbit.smartbox.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.beyondbit.smartbox.common.StatusType;
public class SetSelfStatusRequest extends Request {
	private StatusType status;

	public void setStatus(StatusType status) {
		this.status = status;
	}
	public StatusType getStatus() {
		return status;
	}
	private String description;

	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}

}